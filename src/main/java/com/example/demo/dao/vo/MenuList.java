package com.example.demo.dao.vo;

import lombok.Data;

import java.util.List;

/**
 * @author lbs
 * @date 2019/5/23
 */
@Data
public class MenuList {
    private String menuCode;
    private String menuName;
    private List<MenuList> subMenu;
    private Boolean leafMenu;
    private String icon;
}
