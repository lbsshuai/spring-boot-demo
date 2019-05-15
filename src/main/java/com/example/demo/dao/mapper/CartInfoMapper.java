package com.example.demo.dao.mapper;

import com.example.demo.dao.model.CartInfo;
import com.example.demo.dao.model.CartInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CartInfoMapper {
    long countByExample(CartInfoExample example);

    int deleteByExample(CartInfoExample example);

    int insert(CartInfo record);

    int insertSelective(CartInfo record);

    List<CartInfo> selectByExample(CartInfoExample example);

    int updateByExampleSelective(@Param("record") CartInfo record, @Param("example") CartInfoExample example);

    int updateByExample(@Param("record") CartInfo record, @Param("example") CartInfoExample example);

    int deleteByCartInfo(CartInfo cartInfo);
}