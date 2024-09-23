package com.example.jspfinalwork.DAO;

import com.example.jspfinalwork.pojo.view;

import com.example.jspfinalwork.mapper.ViewMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;
import java.util.Map;

public class viewDAO{

    private SqlSessionFactory sessionFactory;

    public viewDAO() {
        this.sessionFactory = new SqlSessionFactoryBuilder().build(connect.class.getResourceAsStream("/mybatis-config.xml"));
    }

    public List<view> getViewInformation(String name) {
        try (SqlSession session = sessionFactory.openSession()) {
            ViewMapper mapper = session.getMapper(ViewMapper.class);
            return mapper.getViewInformation(name);
        }
    }
    public List<view> getAllView() {
        try (SqlSession session = sessionFactory.openSession()) {
            ViewMapper mapper = session.getMapper(ViewMapper.class);
            return mapper.getAllView();
        }
    }
    public void deleteView(String id) {
        try (SqlSession session = sessionFactory.openSession()) {
            ViewMapper mapper = session.getMapper(ViewMapper.class);
            mapper.deleteView(id);
            session.commit();
        }
    }
    public void changView(String id, String name, String characteristic, String introduce, String picture) {
        try (SqlSession session = sessionFactory.openSession()) {
            ViewMapper mapper = session.getMapper(ViewMapper.class);
            mapper.changeView(id, name, characteristic, introduce);
            session.commit();
        }

    }
    public List<String> getViewId() {
        try (SqlSession session = sessionFactory.openSession()) {
            ViewMapper mapper = session.getMapper(ViewMapper.class);
            return mapper.getViewId();
        }
    }
    public void insertView(view view) {
        try (SqlSession session = sessionFactory.openSession()) {
            ViewMapper mapper = session.getMapper(ViewMapper.class);
            mapper.insertView(view);
            session.commit();
        }

    }

    public void updatePicture(Map<String, Object> params) {
        try (SqlSession session = sessionFactory.openSession()) {
            ViewMapper mapper = session.getMapper(ViewMapper.class);
            mapper.updatePicture(params);
            session.commit();
        }
    }

}
