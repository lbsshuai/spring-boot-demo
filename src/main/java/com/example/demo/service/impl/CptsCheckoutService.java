package com.example.demo.service.impl;

import com.example.demo.dao.common.CommonConstant;
import com.example.demo.dao.cpts.CptsSingleDao;
import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.model.CartInfo;
import com.example.demo.dao.model.OrderInfo;
import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.model.TblSysUser;
import com.example.demo.dao.model.TblUserOrder;
import com.example.demo.dao.util.DateUtil;
import com.example.demo.dao.util.SysUtil;
import com.example.demo.dao.vo.CartInfoVo;
import com.example.demo.service.ICptsCheckoutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lbs
 * @dete
 */
@Service
public class CptsCheckoutService implements ICptsCheckoutService {

    //初始化jedis
    Jedis jedis = new Jedis(CommonConstant.redisAddress, CommonConstant.redisPort);

    private static final Logger logger = LoggerFactory.getLogger(CptsCheckoutService.class);

    @Autowired
    private CptsSingleDao cptsSingleDao;

    /**
     *  获取购物车数据
     * @param userName
     * @return
     */
    public List<CartInfoVo> getCartInfo(String userName) {

        List<CartInfoVo> cartInfoVoList = new ArrayList<>();
        //通过用户名 获取购物车信息
        List<CartInfo> cartInfosList = cptsSingleDao.queryUserCartInfoByUserName(userName);
        CartInfoVo cartInfoVo = null;
        //如果购物车为空时
        if(cartInfosList == null || cartInfosList.size() == 0){
            return null;
        }
        for (int i= 0; i < cartInfosList.size(); i++) {
            CartInfo cartInfo = cartInfosList.get(i);
            //获取该商品详细信息
            ShoeInfo shoeInfo = cptsSingleDao.queryShoeInfoById(cartInfosList.get(i).getId());

            cartInfoVo = new CartInfoVo();
            cartInfoVo.setId(shoeInfo.getId());
            cartInfoVo.setPrice(shoeInfo.getPrice());
            cartInfoVo.setImg(shoeInfo.getImg());
            cartInfoVo.setName(shoeInfo.getName());
            cartInfoVo.setColor(cartInfo.getColor());
            cartInfoVo.setSize(cartInfo.getSize());
            cartInfoVo.setNum(cartInfo.getNum());

            cartInfoVoList.add(cartInfoVo);
        }
        return cartInfoVoList;
    }

    /**
     * 删除购物车中商品信息
     * @param id
     */
    @Override
    public void deleteCartInfo(String id, String userName, String color, String size){
        CartInfo cartInfo = new CartInfo();
        cartInfo.setId(Integer.parseInt(id));
        cartInfo.setColor(color);
        cartInfo.setSize(size);
        cartInfo.setUsername(userName);
       /* SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String format1 = format.format(date);
        try {
            cartInfo.setUpdatedate(format.parse(format1));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        //删除购物车中商品
        cptsSingleDao.deleteCartInfoByInfo(cartInfo);
    }

    /**
     * 获取购物车数据 redis方案
     * @param userName
     * @return
     * @throws MyException
     */
  /*  @Override
    public List<CartInfoVo> getCartInfo(String userName) throws MyException{
        List<CartInfoVo> list = new ArrayList<>();
        CartInfoVo cartInfoVo = null;
        jedis.connect();
        Map<byte[], byte[]> map = jedis.hgetAll(userName.getBytes());
       if (map == null) {
           return null;
       }
        //遍历不同商品
        for (Map.Entry<byte[], byte[]> bytes : map.entrySet()) {
            byte[] value = bytes.getValue();
            Set<CartRequestParam> set = (Set<CartRequestParam>)ObjectsTranscoderUtil.unserizlize(value);
            //遍历同一商品 不同属性
            if (set != null) {
                for (CartRequestParam cart : set) {
                    String idStr = cart.getId();
                    Integer id = Integer.parseInt(idStr);
                    //获取鞋子信息
                    ShoeInfo shoeInfo = cptsSingleDao.getImgByShoeId(id);
                    if (shoeInfo == null){
                        logger.error("是商品信息不存在"+ id);
                        throw new MyException(id + "该商品信息不存在");
                    }
                    cartInfoVo = new CartInfoVo();
                    cartInfoVo.setId(shoeInfo.getId());
                    cartInfoVo.setImg(shoeInfo.getImg());
                    cartInfoVo.setName(shoeInfo.getName());
                    cartInfoVo.setPrice(shoeInfo.getPrice());
                    cartInfoVo.setColor(cart.getColor());
                    cartInfoVo.setNum(cart.getNum());
                    cartInfoVo.setSize(cart.getSize());
                    list.add(cartInfoVo);
                }
            }

        }
        return list;
    }*/


    /**
     * 删除购物车中商品信息 redis 版本
     * @param id
     */
   /* @Override
    public void deleteCartInfo(String id, String userName) {
        jedis.connect();
        jedis.hdel(userName, id);
        jedis.close();
    }*/

    /**
     * 新增订单
     * @param userName
     * @throws MyException
     */
    @Override
    @Transactional
    public void storageCartInfo(String userName) throws MyException {
        List<CartInfoVo> cartInfos = getCartInfo(userName);
        //查找用户信息
        TblSysUser tblSysUser = cptsSingleDao.queryUserInfo(userName);
        //生成订单号
        String orderNum = SysUtil.getOrderIdByTime();
        //商品总价
        Integer totalPrices = 0;
        if (cartInfos != null){
            for (CartInfoVo cartInfoVo : cartInfos){
                totalPrices = Integer.parseInt(cartInfoVo.getNum()) * Integer.parseInt(cartInfoVo.getPrice());
            }
        }
        //添加用户订单表信息
        TblUserOrder userOrder = new TblUserOrder();
        userOrder.setId(tblSysUser.getId());
        userOrder.setOrderNum(orderNum);
        userOrder.setTotalPrices(totalPrices.toString());
        userOrder.setCreatTime(DateUtil.getSystemTimestamp().toString());
        userOrder.setIsDelete("0");
        cptsSingleDao.insertSelectiveUserOrder(userOrder);

        //新增订单表信息
        OrderInfo orderInfo = null;
        List<OrderInfo> orderinfoList = new ArrayList<>();
        for (CartInfoVo cartInfo : cartInfos) {
            //逐个插入订单表
            orderInfo = new OrderInfo();
            orderInfo.setOrderNum(orderNum);
            orderInfo.setShoeId(cartInfo.getId());
            orderInfo.setShoeSize(cartInfo.getSize());
            orderInfo.setShoePrice(cartInfo.getPrice());
            orderInfo.setShoeAmount(cartInfo.getNum());
            orderInfo.setShoeColor(cartInfo.getColor());
            orderinfoList.add(orderInfo);

            //逐个删除购物车中的商品
            deleteCartInfo(cartInfo.getId().toString(), userName,cartInfo.getColor(), cartInfo.getSize());
        }
        cptsSingleDao.insertOrderInfoList(orderinfoList);

       /* //购物车中商品失效
        jedis.connect();
        //删除redis中商品
        for (CartInfoVo cartInfoVo : cartInfos) {
            jedis.hdel(userName.getBytes(), cartInfoVo.getId().toString().getBytes());
        }
        jedis.close();*/
    }
}
