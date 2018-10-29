package com.example.demo.dao.mapper;

import com.example.demo.dao.model.SysUserLove;
import com.example.demo.dao.model.SysUserLoveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserLoveMapper {
    long countByExample(SysUserLoveExample example);

    int deleteByExample(SysUserLoveExample example);

    int insert(SysUserLove record);

    int insertSelective(SysUserLove record);

    List<SysUserLove> selectByExample(SysUserLoveExample example);

    int updateByExampleSelective(@Param("record") SysUserLove record, @Param("example") SysUserLoveExample example);

    int updateByExample(@Param("record") SysUserLove record, @Param("example") SysUserLoveExample example);
}