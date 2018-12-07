package com.example.demo.dao.model;

public class SingleInfo {
    private Integer id;

    private String singleImg;

    private String isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSingleImg() {
        return singleImg;
    }

    public void setSingleImg(String singleImg) {
        this.singleImg = singleImg == null ? null : singleImg.trim();
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}