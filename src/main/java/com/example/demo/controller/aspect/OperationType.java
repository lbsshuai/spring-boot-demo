package com.example.demo.controller.aspect;

/**
 * @author lbs
 * @dete
 */
public enum OperationType {

    ADD(1, "增加"),
    DELETE(2, "删除"),
    UPDATE(3, "修改"),
    SELECT(4, "查找"),
    UNKNOW(5, "未知");
    private int flag;
    private String desc;

    private OperationType(int flag, String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
