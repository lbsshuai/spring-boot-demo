package com.example.demo.service.impl;

import com.example.demo.dao.common.ColorEnum;
import com.example.demo.dao.common.CommonConstant;
import com.example.demo.dao.cpts.CptsSingleDao;
import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.model.SingleInfo;
import com.example.demo.dao.model.TblSysUser;
import com.example.demo.dao.util.ObjectsTranscoderUtil;
import com.example.demo.dao.vo.CartRequestParam;
import com.example.demo.service.ICptsSingleService;
import com.sun.java.accessibility.util.java.awt.ListTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lbs
 * @dete
 */
@Service
public class CptsSingleService implements ICptsSingleService{

    //初始化jedis
    Jedis jedis = new Jedis(CommonConstant.redisAddress, CommonConstant.redisPort);

    @Autowired
    private CptsSingleDao cptsSingleDao;

    @Override
    public List<SingleInfo> queryById(Integer id) {
        return  cptsSingleDao.queryById(id);
    }

    /**
     * 加入购物车
     * @param cartRequestParam
     */
    @Override
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
    }

    @Override
    public ShoeInfo getImgByShoeId(Integer shoeId) {
       return cptsSingleDao.getImgByShoeId(shoeId);
    }
}
