package com.example.demo.dao.model;

public class SysUserLove {
    private Integer id;

    private String love;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love == null ? null : love.trim();
    }
}