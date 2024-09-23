package com.example.jspfinalwork.pojo;

import java.io.Serializable;

public class food implements Serializable {
    private static final long serialVersionUID = 1L;
    String id;
    String name;
    String origin;
    String introduce;
    byte[] b = new byte[1024];

    public food() {

    }

    public food(String id, String name, String origin, String introduce, byte[] b) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.introduce = introduce;
        this.b = b;
    }

    public byte[] getB() {
        return b;
    }

    public void setB(byte[] b) {
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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

}
