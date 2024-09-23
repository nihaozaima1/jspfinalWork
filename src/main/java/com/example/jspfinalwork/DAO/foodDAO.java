package com.example.jspfinalwork.DAO;

import com.example.jspfinalwork.mapper.FoodMapper;
import com.example.jspfinalwork.pojo.food;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;
import java.util.Map;

public class foodDAO {
    private SqlSessionFactory sessionFactory;

    public foodDAO() {
        this.sessionFactory = new SqlSessionFactoryBuilder().build(connect.class.getResourceAsStream("/mybatis-config.xml"));
    }

    public List<food> getFoodInformation(String fname) {
        try (SqlSession session = sessionFactory.openSession()) {
            FoodMapper mapper = session.getMapper(FoodMapper.class);
            return mapper.getFoodInformation(fname);
        }
    }

    public List<food> getAllFood() {
        try (SqlSession session = sessionFactory.openSession()) {
            FoodMapper mapper = session.getMapper(FoodMapper.class);
            return mapper.getAllFood();
        }
    }

    public void deleteFood(String id) {
        try (SqlSession session = sessionFactory.openSession()) {
            FoodMapper mapper = session.getMapper(FoodMapper.class);
            mapper.deleteFood(id);
            session.commit();
        }
    }

    public void changeFood(food food) {
        try (SqlSession session = sessionFactory.openSession()) {
            FoodMapper mapper = session.getMapper(FoodMapper.class);
            mapper.changeFood(food);
            session.commit();
        }
    }

    public void insertFood(food food) {
        try (SqlSession session = sessionFactory.openSession()) {
            FoodMapper mapper = session.getMapper(FoodMapper.class);
            mapper.insertFood(food);
            session.commit();
        }
    }

    public void updatePicture(Map<String, Object> params) {
        try (SqlSession session = sessionFactory.openSession()) {
            FoodMapper mapper = session.getMapper(FoodMapper.class);
            mapper.updatePicture(params);
            session.commit();
        }
    }
}