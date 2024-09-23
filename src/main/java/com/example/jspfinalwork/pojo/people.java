package com.example.jspfinalwork.pojo;

public class people {
    private static final long serialVersionUID = 1L;
    String id;
    String name;
    String year;
    String introduce;

    public people(String id, String name, String year, String introduce, byte[] b) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.introduce = introduce;
        this.b = b;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public byte[] getB() {
        return b;
    }

    public void setB(byte[] b) {
        this.b = b;
    }

    byte[] b = new byte[1024];
    public people(){

    }
}
