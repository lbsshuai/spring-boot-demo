package com.example.demo.dao.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author lbs
 * @date
 */
@Data
@ApiModel(description = "商品信息实体类")
public class CartRequestParam implements Serializable {
    //商品ID
    @ApiModelProperty(value = "商品ID")
    private String id;
    //商品数量
    @ApiModelProperty(value = "商品数量")
    private String num;
    //商品颜色
    @ApiModelProperty(value = "商品颜色")
    private String color;
    //商品大小
    @ApiModelProperty(value = "商品大小")
    private String size;

    //用户名
    @ApiModelProperty(value = "用户名")
    private String userName;
}
