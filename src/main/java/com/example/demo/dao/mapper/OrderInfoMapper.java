package com.example.demo.dao.mapper;

import com.example.demo.dao.model.OrderInfo;
import com.example.demo.dao.model.OrderInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;

public interface OrderInfoMapper {
    long countByExample(OrderInfoExample example);

    int deleteByExample(OrderInfoExample example);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    List<OrderInfo> selectByExample(OrderInfoExample example);

    int updateByExampleSelective(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    int updateByExample(@Param("record") OrderInfo record, @Param("example") OrderInfoExample example);

    /**
     * 批量插入数据
     */
    int insertOrderInfoList(@Param("list")List<OrderInfo> orderInfos);
}