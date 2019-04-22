package com.example.demo.dao.vo;

import lombok.Data;

import java.util.List;

/**
 * @author lbs
 * @dete
 */
public class CartInfoVoList {

    private List<CartInfoVo> cartInfoVos;

    public List<CartInfoVo> getCartInfoVos() {
        return cartInfoVos;
    }

    public void setCartInfoVos(List<CartInfoVo> cartInfoVos) {
        this.cartInfoVos = cartInfoVos;
    }
}
