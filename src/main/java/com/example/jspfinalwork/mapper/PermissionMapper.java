package com.example.jspfinalwork.mapper;

import com.example.jspfinalwork.pojo.key;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    List<key> getAllKeys();

    key getPermission(@Param("key") String key);

    void changePermission(key key);
}