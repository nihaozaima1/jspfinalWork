package com.example.jspfinalwork.pojo;

public class view {
    private static final long serialVersionUID = 1L;
    String id;
    String name;
    String characteristic;
    String introduce;

    public view(String id, String name, String characteristic, String introduce, byte[] b) {
        this.id = id;
        this.name = name;
        this.characteristic = characteristic;
        this.introduce = introduce;
        this.b = b;
    }

    byte[] b = new byte[1024];

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

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
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

    public view() {

    }
}
