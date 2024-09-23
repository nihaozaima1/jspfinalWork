package com.example.jspfinalwork.DAO;

import com.example.jspfinalwork.mapper.commentsMapper;
import com.example.jspfinalwork.pojo.comments;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;

public class commentsDAO {
    private SqlSessionFactory sessionFactory;
    SqlSession session;
    private commentsMapper commentsMapper;
    public commentsDAO(){
        this.sessionFactory = new SqlSessionFactoryBuilder().build(connect.class.getResourceAsStream("/mybatis-config.xml"));//加载mybatis信息
        session = sessionFactory.openSession();
        commentsMapper = session.getMapper(commentsMapper.class);
    }
    public List<comments> getComments(String foodName){
        return commentsMapper.getComments(foodName);
    }
    public void setComments(comments comments){
        commentsMapper.setComments(comments);
        session.commit();
    }
}
