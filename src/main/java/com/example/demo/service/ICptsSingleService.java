package com.example.demo.service;

import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.model.SingleInfo;
import com.example.demo.dao.vo.CartRequestParam;

import java.util.List;

/**
 * 单品信息
 * @author lbs
 * @dete
 */
public interface ICptsSingleService {
    List<SingleInfo> queryById(Integer id);

    void addToCart( CartRequestParam cartRequestParam);

    ShoeInfo getImgByShoeId(Integer shoeId);
}
