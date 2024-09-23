package com.example.jspfinalwork.mapper;

import com.example.jspfinalwork.pojo.view;

import java.util.List;
import java.util.Map;

public interface ViewMapper {
    List<view> getAllView();

    List<view> getViewInformation(String name);

    List<String> getViewId();

    void deleteView(String id);

    void changeView(String id, String name, String characteristic, String introduce);

    void insertView(view view);

    void updatePicture(Map<String, Object> params);
}
