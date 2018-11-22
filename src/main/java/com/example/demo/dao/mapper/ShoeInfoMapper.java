package com.example.demo.dao.mapper;

import com.example.demo.dao.model.ShoeInfo;
import com.example.demo.dao.model.ShoeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShoeInfoMapper {
    long countByExample(ShoeInfoExample example);

    int deleteByExample(ShoeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShoeInfo record);

    int insertSelective(ShoeInfo record);

    List<ShoeInfo> selectByExample(ShoeInfoExample example);

    ShoeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShoeInfo record, @Param("example") ShoeInfoExample example);

    int updateByExample(@Param("record") ShoeInfo record, @Param("example") ShoeInfoExample example);

    int updateByPrimaryKeySelective(ShoeInfo record);

    int updateByPrimaryKey(ShoeInfo record);

    List<ShoeInfo> queryAll();
}