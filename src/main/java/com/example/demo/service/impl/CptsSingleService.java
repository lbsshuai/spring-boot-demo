package com.example.demo.service.impl;

import com.example.demo.dao.common.CommonConstant;
import com.example.demo.dao.cpts.CptsSingleDao;
import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.model.SingleInfo;
import com.example.demo.dao.model.TblSysUser;
import com.example.demo.service.ICptsSingleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

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

    @Override
    public void addToCart(String id, String userName, String num) {
        boolean flag = false;
        //获取用户信息
        TblSysUser tblSysUser = cptsSingleDao.queryUserInfo(userName);
        //存入购物车
        jedis.connect();
        //判断购物车中商品是否存在
        Map<String, String> cartMap = jedis.hgetAll(userName);
        for(Map.Entry entry: cartMap.entrySet()){
            if(entry.getKey().equals(id)){
                Integer numCart = Integer.parseInt((String) entry.getValue()) + Integer.parseInt(num);
                jedis.hset(userName, id, numCart.toString());
                jedis.expire(userName, 3600);
                flag = true;
            }
        }
        if(!flag) {
            jedis.hset(userName, id, "1");
        }
    }

    @Override
    public ShoeInfo getImgByShoeId(Integer shoeId) {
       return cptsSingleDao.getImgByShoeId(shoeId);
    }
}
