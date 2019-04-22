package com.example.demo.dao.common;

import org.apache.poi.hssf.util.HSSFColor;

/**
 * @author lbs
 * @dete
 */
public enum ColorEnum {
    WHITE(1, "米白色"),
    BLUE(2, "蓝色"),
    DEEPPINK(3, "深粉色"),
    GREEN(4, "绿色"),
    ORANGE(5, "橘色"),
    BLACK(6, "黑色"),
    RED(7, "红色"),
    YELLOW(8, "黄色");

    ColorEnum(Integer num, String des) {
        this.num = num;
        this.des = des;
    }

    private Integer num;
    private String des;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getDesByNum(Integer num){
        for (ColorEnum colorEnum: ColorEnum.values()) {
            if(colorEnum.getNum() == num) {
                return colorEnum.getDes();
            }
        }
        return "";
    }

    public Integer getNumByDes(String des){
        for (ColorEnum colorEnum: ColorEnum.values()) {
            if (colorEnum.getDes().equals(des)){
                return colorEnum.getNum();
            }
        }
        return 0;
    }
}
