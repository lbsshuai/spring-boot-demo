package com.example.demo.dao.mapper;

import com.example.demo.dao.model.Export;
import com.example.demo.dao.model.ExportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExportMapper {
    long countByExample(ExportExample example);

    int deleteByExample(ExportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Export record);

    int insertSelective(Export record);

    List<Export> selectByExample(ExportExample example);

    Export selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Export record, @Param("example") ExportExample example);

    int updateByExample(@Param("record") Export record, @Param("example") ExportExample example);

    int updateByPrimaryKeySelective(Export record);

    int updateByPrimaryKey(Export record);

    List<Export> selectDifferentId(Integer id);
}