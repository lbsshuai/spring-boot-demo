package com.example.demo.dao.cpts;

import com.example.demo.dao.mapper.OrderInfoMapper;
import com.example.demo.dao.mapper.ShoeInfoMapper;
import com.example.demo.dao.mapper.SingleInfoMapper;
import com.example.demo.dao.mapper.TblSysUserMapper;
import com.example.demo.dao.mapper.TblUserOrderMapper;
import com.example.demo.dao.model.*;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lbs
 * @dete
 */
@Repository
public class CptsSingleDao {

    @Autowired
    private SingleInfoMapper singleInfoMapper;

    @Autowired
    private TblSysUserMapper tblSysUserMapper;

    @Autowired
    private ShoeInfoMapper shoeInfoMapper;

    @Autowired
    private TblUserOrderMapper tblUserOrderMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    public List<SingleInfo> queryById(Integer id){
        SingleInfoExample example = new SingleInfoExample();
        example.createCriteria().andIdEqualTo(id);

        List<SingleInfo> singleInfos = singleInfoMapper.selectByExample(example);
        return singleInfos;
    }

    /**
     * 通过鞋ID获取鞋子信息
     * @param shoeId
     * @return
     */
    public ShoeInfo getImgByShoeId(Integer shoeId){
        ShoeInfoExample example = new ShoeInfoExample();
        example.createCriteria().andIdEqualTo(shoeId);

        List<ShoeInfo> shoeInfos = shoeInfoMapper.selectByExample(example);
        return shoeInfos.get(0);
    }

    //通过用户名获取用户信息
    public TblSysUser queryUserInfo(Object userName){
        TblSysUser tblSysUser = tblSysUserMapper.queryUserInfoByUserName(userName);
        return tblSysUser;
    }

    /**
     * 新增用户订单表信息
     * @param tblUserOrder
     */
    public void insertSelectiveUserOrder(TblUserOrder tblUserOrder){
        tblUserOrderMapper.insertSelective(tblUserOrder);
    }

    /**
     * 新增订单表信息
     * @param orderInfo
     */
    //单条插入
    public void insertSelectiveOrderInfo(OrderInfo orderInfo) {
        orderInfoMapper.insertSelective(orderInfo);
    }
    //批量插入
    public void insertOrderInfoList(List<OrderInfo> orderInfos){
        orderInfoMapper.insertOrderInfoList(orderInfos);
    }

}
