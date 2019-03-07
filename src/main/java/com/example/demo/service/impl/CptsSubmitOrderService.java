package com.example.demo.service.impl;

import com.example.demo.dao.cpts.CptsSubmitOrderDao;
import com.example.demo.dao.exception.MyException;
import com.example.demo.dao.model.ConsigneeInfo;
import com.example.demo.service.ICptsSubmitOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单提交
 * @author lbs
 * @dete
 */
@Service
public class CptsSubmitOrderService implements ICptsSubmitOrderService {

    @Autowired
    private CptsSubmitOrderDao cptsSubmitOrderDao;

    public void submitOrder(ConsigneeInfo consigneeInfo) throws MyException{
        if(consigneeInfo.getId() == null){
            throw new MyException("请登录后再提交订单！");
        }
        cptsSubmitOrderDao.submitOrder(consigneeInfo);
    }



}
