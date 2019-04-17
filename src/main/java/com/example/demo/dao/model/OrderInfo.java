package com.example.demo.dao.model;

public class OrderInfo {
    private String orderNum;

    private Integer shoeId;

    private String shoeColor;

    private String shoeSize;

    private String shoePrice;

    private String shoeAmount;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public Integer getShoeId() {
        return shoeId;
    }

    public void setShoeId(Integer shoeId) {
        this.shoeId = shoeId;
    }

    public String getShoeColor() {
        return shoeColor;
    }

    public void setShoeColor(String shoeColor) {
        this.shoeColor = shoeColor == null ? null : shoeColor.trim();
    }

    public String getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(String shoeSize) {
        this.shoeSize = shoeSize == null ? null : shoeSize.trim();
    }

    public String getShoePrice() {
        return shoePrice;
    }

    public void setShoePrice(String shoePrice) {
        this.shoePrice = shoePrice == null ? null : shoePrice.trim();
    }

    public String getShoeAmount() {
        return shoeAmount;
    }

    public void setShoeAmount(String shoeAmount) {
        this.shoeAmount = shoeAmount == null ? null : shoeAmount.trim();
    }
}