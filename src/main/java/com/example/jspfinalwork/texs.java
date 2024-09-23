//package com.example.jspfinalwork;
//
//import com.example.jspfinalwork.pojo.food;
//import com.example.jspfinalwork.Model.connect;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class texs {
//    public static void main(String[] args){
//        connect con = new connect();
//        List<food> foods = new ArrayList<>();
//        con.getConnection();
//        foods = con.getAllFood();
//        for(food temp:foods){
//            System.out.println(temp.getId());
//            System.out.println(temp.getIntroduce());
//        }
//        List<food> food1 = new ArrayList<>();
//        food1 = con.getFoodInformation("干菜");
//        for(food temp:food1){
//            System.out.println(temp.getIntroduce());
//        }
//        if(con.checkKey("12345")){
//            System.out.println(231);
//        }
//        con.changFood("5","dasd","dasadwd","sdqwdasdq","C:\\fakepath\\干菜鸭2.jpg");
//        ArrayList<String> ids = con.getId();
//        for(String temp:ids){
//            System.out.println(temp);
//        }
//    }
//}
