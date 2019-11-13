package com.lrh.cs.pojo;

public class Medal {
    private Integer medalType;
    private String  medalName;
    private String  mdealImg;
    private Integer orderBy;

    public Integer getMedalType() {
        return medalType;
    }

    public void setMedalType(Integer medalType) {
        this.medalType = medalType;
    }

    public String getMedalName() {
        return medalName;
    }

    public void setMedalName(String medalName) {
        this.medalName = medalName;
    }

    public String getMdealImg() {
        return mdealImg;
    }

    public void setMdealImg(String mdealImg) {
        this.mdealImg = mdealImg;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }
}
