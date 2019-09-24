package com.example.demo.dao.Enum;

/**
 * 证件类型枚举
 * @author lbs
 * @date 2019/9/19
 */
public enum IdentityTypeEnum {;

    private String type;
    private String code;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    private IdentityTypeEnum(String type, String code, String name) {
        this.type = type;
        this.code = code;
        this.name = name;
    }

    /**
     * 只拿证件名
     * @param type 身份类型
     * @param code 证件code
     * @return
     */
    public static String getName(String type, String code) {
        if (type == null || code == null) return null;
        for (IdentityTypeEnum i : IdentityTypeEnum.values()) {
            if (type.equals(i.getType()) && code.equals(i.getCode())) {
                return i.getName();
            }
        }
        throw new IllegalArgumentException("No enum code '"+type+":"+code+"'." + IdentityTypeEnum.class);
    }
}
