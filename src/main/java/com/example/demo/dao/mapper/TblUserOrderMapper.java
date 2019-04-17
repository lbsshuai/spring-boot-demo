package com.example.demo.dao.mapper;

import com.example.demo.dao.model.TblUserOrder;
import com.example.demo.dao.model.TblUserOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserOrderMapper {
    long countByExample(TblUserOrderExample example);

    int deleteByExample(TblUserOrderExample example);

    int insert(TblUserOrder record);

    int insertSelective(TblUserOrder record);

    List<TblUserOrder> selectByExample(TblUserOrderExample example);

    int updateByExampleSelective(@Param("record") TblUserOrder record, @Param("example") TblUserOrderExample example);

    int updateByExample(@Param("record") TblUserOrder record, @Param("example") TblUserOrderExample example);
}