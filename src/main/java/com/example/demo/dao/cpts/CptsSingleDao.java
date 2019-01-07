package com.example.demo.dao.cpts;

import com.example.demo.dao.mapper.ShoeInfoMapper;
import com.example.demo.dao.mapper.SingleInfoMapper;
import com.example.demo.dao.mapper.TblSysUserMapper;
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
}
