package com.example.demo.service;

import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.vo.CartInfoVo;

import java.util.List;

/**
 * @author lbs
 * @dete
 */
public interface ICptsCheckoutService {

    List<CartInfoVo> getCartInfo(String userName)  throws MyException;

    void deleteCartInfo(String id, String userName);

    void storageCartInfo(String userName) throws MyException;
}
