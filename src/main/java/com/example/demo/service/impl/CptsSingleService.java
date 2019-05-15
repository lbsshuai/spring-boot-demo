package com.example.demo.service.impl;

import com.example.demo.dao.common.CommonConstant;
import com.example.demo.dao.cpts.CptsSingleDao;
import com.example.demo.dao.model.CartInfo;
import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.model.SingleInfo;
import com.example.demo.dao.vo.CartRequestParam;
import com.example.demo.service.ICptsSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author lbs
 * @dete
 */
@Service
public class CptsSingleService implements ICptsSingleService{

    //初始化jedis
    Jedis jedis = new Jedis(CommonConstant.redisAddress, CommonConstant.redisPort);

    private final String IS_DELETE = "0";

    @Autowired
    private CptsSingleDao cptsSingleDao;

    @Override
    public List<SingleInfo> queryById(Integer id) {
        return  cptsSingleDao.queryById(id);
    }

    /**
     * 加入购物车
     * redis版本
     * @param cartRequestParam
     */
    @Override
    public void addToCart(CartRequestParam cartRequestParam) {
        //商品ID
        String id = cartRequestParam.getId();
        //用户名
        String userName = cartRequestParam.getUserName();
        String num = cartRequestParam.getNum();
        String color = cartRequestParam.getColor();
        String size = cartRequestParam.getSize();

        //即将存储购物车产品
        CartInfo cartInfo = new CartInfo();
        cartInfo.setUsername(userName);
        cartInfo.setId(Integer.parseInt(id));
        cartInfo.setSize(size);
        cartInfo.setColor(color);
        //判断购物车中是否存在此商品
        List<CartInfo> cartInfos = cptsSingleDao.queryCartInfoByInfo(cartInfo);
        if (cartInfos.size() != 0){
            Integer totalNum = Integer.parseInt(cartInfos.get(0).getNum()) + Integer.parseInt(num);
            cartInfo.setNum(totalNum.toString());
            //修改购物车中的商品数量
            cptsSingleDao.updateCartInfo(cartInfo);
        }else {
            cartInfo.setIsDelete(IS_DELETE);
            cartInfo.setNum(num);
            //新增购物车表信息
            cptsSingleDao.insertCartInfo(cartInfo);
        }
    }

    /**
     * 加入购物车
     * redis版本
     */
   /* @Override
    public void addToCart(CartRequestParam cartRequestParam) {
        String id = cartRequestParam.getId();
        String userName = cartRequestParam.getUserName();
        String num = cartRequestParam.getNum();
        String color = cartRequestParam.getColor();
        String size = cartRequestParam.getSize();

        boolean flag = false;
        //获取用户信息
        TblSysUser tblSysUser = cptsSingleDao.queryUserInfo(userName);
        //连接redis
        jedis.connect();

        Set<CartRequestParam> set = new HashSet<>();
        //判断购物车中商品是否存在
        byte[] hget = jedis.hget(userName.getBytes(), id.getBytes());

        if (hget == null) {
            //不存在该商品时，直接添加
            set.add(cartRequestParam);
        }else {
            set = (Set<CartRequestParam>) ObjectsTranscoderUtil.unserizlize(hget);
            //当存在该商品信息时
            if (set != null) {
                if (set.size() > 0) {
                    for (CartRequestParam cart : set){
                        //当存在的商品信息相同时
                        if (cart.getColor().equals(color) && cart.getSize().equals(size)){
                            Integer total = Integer.parseInt(cart.getNum()) + Integer.parseInt(num);
                            cartRequestParam.setNum(total.toString());
                        }else{
                            //当存在的商品不同时
                            set.add(cartRequestParam);
                        }
                    }
                }
            }
        }
        //添加到redis中
        jedis.hset(userName.getBytes(), id.getBytes(), ObjectsTranscoderUtil.serialize(set));
        jedis.close();
    }*/

    @Override
    public ShoeInfo getImgByShoeId(Integer shoeId) {
       return cptsSingleDao.getImgByShoeId(shoeId);
    }
}
