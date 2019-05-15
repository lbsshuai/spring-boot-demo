package com.example.demo.dao.cpts;

import com.example.demo.dao.mapper.CartInfoMapper;
import com.example.demo.dao.mapper.OrderInfoMapper;
import com.example.demo.dao.mapper.ShoeInfoMapper;
import com.example.demo.dao.mapper.SingleInfoMapper;
import com.example.demo.dao.mapper.TblSysUserMapper;
import com.example.demo.dao.mapper.TblUserOrderMapper;
import com.example.demo.dao.model.*;
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

    @Autowired
    private CartInfoMapper cartInfoMapper;

    private final String IS_DELETE_ZERO = "0";

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


    /**
     * 查找购物车中信息
     * @return
     */
    public List<CartInfo> queryCartInfoByInfo(CartInfo cartInfo){
        CartInfoExample example = new CartInfoExample();
        CartInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(cartInfo.getUsername());
        criteria.andIdEqualTo(cartInfo.getId());
        criteria.andColorEqualTo(cartInfo.getColor());
        criteria.andSizeEqualTo(cartInfo.getSize());
        criteria.andIsDeleteEqualTo("0");

       return cartInfoMapper.selectByExample(example);
    }

    /**
     * 通过用户名获取有效的购物车信息
     * @param userName
     * @return
     */
    public List<CartInfo> queryUserCartInfoByUserName(String userName){
        CartInfoExample example = new CartInfoExample();
        CartInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);
        criteria.andIsDeleteEqualTo("0");

        return cartInfoMapper.selectByExample(example);
    }

    /**
     * 新增购物车信息
     * @param cartInfo
     */
    public void insertCartInfo(CartInfo cartInfo){
        cartInfoMapper.insertSelective(cartInfo);
    }

    /**
     * 更新购物车数量信息
     * @param cartInfo
     */
    public void updateCartInfo(CartInfo cartInfo){
        CartInfoExample example = new CartInfoExample();
        CartInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(cartInfo.getUsername());
        criteria.andIdEqualTo(cartInfo.getId());
        criteria.andColorEqualTo(cartInfo.getColor());
        criteria.andSizeEqualTo(cartInfo.getSize());

        cartInfoMapper.updateByExampleSelective(cartInfo, example);
    }

    /**
     * 通过商品id获取商品信息
     * @param id
     * @return
     */
    public ShoeInfo queryShoeInfoById(Integer id){
        ShoeInfoExample example = new ShoeInfoExample();
        example.createCriteria().andIdEqualTo(id);

        return shoeInfoMapper.selectByExample(example).get(0);
    }

    /**
     * 删除购物车中商品
     * @param cartInfo
     */
    public void deleteCartInfoByInfo( CartInfo cartInfo){
        cartInfoMapper.deleteByCartInfo(cartInfo);
    }
}
