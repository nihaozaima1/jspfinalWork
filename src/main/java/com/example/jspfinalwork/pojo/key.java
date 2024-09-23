package com.example.jspfinalwork.pojo;

public class key {
    private String key;
    private int ifchange;
    private int ifdelete;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setIfchange(int ifadd) {
        this.ifchange = ifadd;
    }

    public void setIfdelete(int ifdelete) {
        this.ifdelete = ifdelete;
    }

    public int getIfchange() {
        return ifchange;
    }

    public int getIfdelete() {
        return ifdelete;
    }

    public key(String key, int ifchange, int ifdelete) {
        this.key = key;
        this.ifchange = ifchange;
        this.ifdelete = ifdelete;
    }
}
