package com.example.demo.dao.mapper;

import com.example.demo.dao.model.ConsigneeInfo;
import com.example.demo.dao.model.ConsigneeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsigneeInfoMapper {
    long countByExample(ConsigneeInfoExample example);

    int deleteByExample(ConsigneeInfoExample example);

    int insert(ConsigneeInfo record);

    int insertSelective(ConsigneeInfo record);

    List<ConsigneeInfo> selectByExample(ConsigneeInfoExample example);

    int updateByExampleSelective(@Param("record") ConsigneeInfo record, @Param("example") ConsigneeInfoExample example);

    int updateByExample(@Param("record") ConsigneeInfo record, @Param("example") ConsigneeInfoExample example);
}