package com.example.jspfinalwork.pojo;

public class comments {
    private String foodName;
    private String userName;
    private String comments;

    public comments(String foodName, String userName, String comments) {
        this.foodName = foodName;
        this.userName = userName;
        this.comments = comments;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
