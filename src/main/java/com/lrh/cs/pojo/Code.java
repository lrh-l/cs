package com.lrh.cs.pojo;

import java.util.List;

public class Code {
    private Integer id;
    private String title;
    private Integer dirid;
    private Integer parid;
    private List<Code> codeList;

    public List<Code> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<Code> codeList) {
        this.codeList = codeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDirid() {
        return dirid;
    }

    public void setDirid(Integer dirid) {
        this.dirid = dirid;
    }

    public Integer getParid() {
        return parid;
    }

    public void setParid(Integer parid) {
        this.parid = parid;
    }
}
