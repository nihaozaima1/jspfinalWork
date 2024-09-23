package com.example.jspfinalwork.mapper;

import com.example.jspfinalwork.pojo.comments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface commentsMapper {
    List<comments> getComments(@Param("foodName") String foodName);
    void setComments(comments comments);
}
