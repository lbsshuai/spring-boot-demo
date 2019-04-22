package com.example.demo.dao.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lbs
 * @dete
 */
@Data
public class CartRequestParam implements Serializable {
    //商品ID
    private String id;
    //商品数量
    private String num;
    //商品颜色
    private String color;
    //商品大小
    private String size;

    //用户名
    private String userName;
}
