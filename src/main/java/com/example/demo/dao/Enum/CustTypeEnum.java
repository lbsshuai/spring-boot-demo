package com.example.demo.dao.Enum;

/**
 * 客户类型枚举
 * @author lbs
 * @date 2019/9/19
 */
public enum CustTypeEnum {

    PERSON("0", "人类"),
    PRODUCT("1", "产品");

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private CustTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(String code) {
        if (code == null) return null;
        for (CustTypeEnum c : CustTypeEnum.values()) {
            if (c.getCode().equals(code)) {
                return c.getName();
            }
        }
        throw new IllegalArgumentException("No enum code '"+ code +"'." + CustTypeEnum.class);
    }
}
