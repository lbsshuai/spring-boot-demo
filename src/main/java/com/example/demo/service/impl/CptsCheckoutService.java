package com.example.demo.service.impl;

import com.example.demo.dao.common.CommonConstant;
import com.example.demo.dao.cpts.CptsSingleDao;
import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.vo.CartInfoVo;
import com.example.demo.service.ICptsCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author lbs
 * @dete
 */
@Service
public class CptsCheckoutService implements ICptsCheckoutService {

    //初始化jedis
    Jedis jedis = new Jedis(CommonConstant.redisAddress, CommonConstant.redisPort);

    @Autowired
    private CptsSingleDao cptsSingleDao;

    @Override
    public List<CartInfoVo> getCartInfo(String userName) {
        List<CartInfoVo> list = new ArrayList<>();
        CartInfoVo cartInfoVo = null;
        jedis.connect();
        Map<String, String> map = jedis.hgetAll(userName);
        for(Map.Entry<String, String> entry: map.entrySet()){
            String shoeId = entry.getKey();
            String num = entry.getValue();
            //获取鞋子信息
            ShoeInfo shoeInfo = cptsSingleDao.getImgByShoeId(Integer.parseInt(shoeId));
            cartInfoVo = new CartInfoVo();
            cartInfoVo.setId(shoeInfo.getId());
            cartInfoVo.setImg(shoeInfo.getImg());
            cartInfoVo.setName(shoeInfo.getName());
            cartInfoVo.setPrice(shoeInfo.getPrice());
            cartInfoVo.setNum(num);
            list.add(cartInfoVo);
        }
        return list;
    }
}
