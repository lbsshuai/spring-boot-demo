package com.example.demo.dao.mapper;

import com.example.demo.dao.model.SingleInfo;
import com.example.demo.dao.model.SingleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SingleInfoMapper {
    long countByExample(SingleInfoExample example);

    int deleteByExample(SingleInfoExample example);

    int insert(SingleInfo record);

    int insertSelective(SingleInfo record);

    List<SingleInfo> selectByExample(SingleInfoExample example);

    int updateByExampleSelective(@Param("record") SingleInfo record, @Param("example") SingleInfoExample example);

    int updateByExample(@Param("record") SingleInfo record, @Param("example") SingleInfoExample example);
}