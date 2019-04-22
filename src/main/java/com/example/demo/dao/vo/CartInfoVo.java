package com.example.demo.dao.vo;

import lombok.Data;

/**
 * @author lbs
 * @dete
 */
@Data
public class CartInfoVo {
    //鞋子ID
    private Integer id;
    //鞋名
    private String name;
    //图片名
    private String img;
    //价格
    private String price;
    //数量
    private String num;
    //颜色
    private String color;
    //大小
    private String size;
}
