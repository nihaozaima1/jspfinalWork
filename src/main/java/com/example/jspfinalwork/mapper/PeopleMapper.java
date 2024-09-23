package com.example.jspfinalwork.mapper;
import com.example.jspfinalwork.pojo.food;
import com.example.jspfinalwork.pojo.people;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
public interface PeopleMapper {
    List<people> getPeopleInformation(String fname);
    List<people> getAllPeople();
    void deletePeople(String id);
    void changePeople(String id, String name, String year, String introduce);
    void insertPeople(people p);
    List<String> getPeopleId();

    void updatePicture(Map<String, Object>  params);
}
