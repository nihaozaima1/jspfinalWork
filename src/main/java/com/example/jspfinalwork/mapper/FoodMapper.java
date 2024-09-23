package com.example.jspfinalwork.mapper;

import com.example.jspfinalwork.pojo.food;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

public interface FoodMapper {

    List<food> getFoodInformation(String fname);
    List<food> getAllFood();
    void deleteFood(String id);
    void changeFood(food food);
    void insertFood(food food);

    void updatePicture(Map<String, Object>  params);
}