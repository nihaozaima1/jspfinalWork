package com.example.jspfinalwork.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginRegisterMapper {
    boolean checkAccount(@Param("username") String username, @Param("ipassword") String ipassword);

    List<String> getId();

    void beginResign(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("telephone") String telephone);
}