package com.example.demo.service;

import com.example.demo.dao.vo.CartInfoVo;

import java.util.List;

/**
 * @author lbs
 * @dete
 */
public interface ICptsCheckoutService {

    List<CartInfoVo> getCartInfo(String userName);
}
