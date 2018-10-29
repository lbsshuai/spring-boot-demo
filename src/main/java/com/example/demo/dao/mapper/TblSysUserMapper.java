package com.example.demo.dao.mapper;

import com.example.demo.dao.model.TblSysUser;
import com.example.demo.dao.model.TblSysUserExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblSysUserMapper {
    long countByExample(TblSysUserExample example);

    int deleteByExample(TblSysUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblSysUser record);

    int insertSelective(TblSysUser record);

    List<TblSysUser> selectByExample(TblSysUserExample example);

    TblSysUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblSysUser record, @Param("example") TblSysUserExample example);

    int updateByExample(@Param("record") TblSysUser record, @Param("example") TblSysUserExample example);

    int updateByPrimaryKeySelective(TblSysUser record);

    int updateByPrimaryKey(TblSysUser record);
    
    //插入数据
    void signIn(TblSysUser record);
    
    //获取用户表主键id
    int queryId();
    
}