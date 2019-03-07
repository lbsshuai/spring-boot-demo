package com.example.demo.dao.cpts;

import com.example.demo.dao.mapper.ConsigneeInfoMapper;
import com.example.demo.dao.model.ConsigneeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 订单提交
 * @author lbs
 * @dete
 */
@Repository
public class CptsSubmitOrderDao {

    @Autowired
    private ConsigneeInfoMapper consigneeInfoMapper;

    public void submitOrder(ConsigneeInfo consigneeInfo){
        consigneeInfoMapper.insert(consigneeInfo);
    }
}
