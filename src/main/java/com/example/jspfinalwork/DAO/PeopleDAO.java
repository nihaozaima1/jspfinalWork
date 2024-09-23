package com.example.jspfinalwork.DAO;

import com.example.jspfinalwork.mapper.FoodMapper;
import com.example.jspfinalwork.mapper.PeopleMapper;
import com.example.jspfinalwork.pojo.people;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;
import java.util.Map;

public class PeopleDAO{
    private SqlSessionFactory sessionFactory;

    public PeopleDAO() {
        this.sessionFactory = new SqlSessionFactoryBuilder().build(connect.class.getResourceAsStream("/mybatis-config.xml"));
    }
    public List<people> getPeopleInformation(String fname) {
        try (SqlSession session = sessionFactory.openSession()) {
            PeopleMapper mapper = session.getMapper(PeopleMapper.class);
            return mapper.getPeopleInformation(fname);
        }
    }

    public List<people> getAllPeople() {
        try (SqlSession session = sessionFactory.openSession()) {
            PeopleMapper mapper = session.getMapper(PeopleMapper.class);
            return mapper.getAllPeople();
        }
    }

    public void deletePeople(String id) {
        try (SqlSession session = sessionFactory.openSession()) {
            PeopleMapper mapper = session.getMapper(PeopleMapper.class);
            mapper.deletePeople(id);
            session.commit();
        }
    }

    public void changePeople(String id, String name, String year, String introduce) {
        try (SqlSession session = sessionFactory.openSession()) {
            PeopleMapper mapper = session.getMapper(PeopleMapper.class);
            mapper.changePeople(id, name, year, introduce);
            session.commit();
        }
    }
    public List<String> getPeopleId() {
        try (SqlSession session = sessionFactory.openSession()) {
            PeopleMapper mapper = session.getMapper(PeopleMapper.class);
            return mapper.getPeopleId();
        }
    }

    public void insertPeople(people p) {
        try (SqlSession session = sessionFactory.openSession()) {
            PeopleMapper mapper = session.getMapper(PeopleMapper.class);
            mapper.insertPeople(p);
            session.commit();
        }
    }

    public void updatePicture(Map<String, Object> params) {
        try (SqlSession session = sessionFactory.openSession()) {
            PeopleMapper mapper = session.getMapper(PeopleMapper.class);
            mapper.updatePicture(params);
            session.commit();
        }
    }
}
