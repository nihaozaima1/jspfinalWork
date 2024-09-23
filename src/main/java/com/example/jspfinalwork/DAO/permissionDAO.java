package com.example.jspfinalwork.DAO;

import com.example.jspfinalwork.mapper.PermissionMapper;
import com.example.jspfinalwork.pojo.key;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.util.List;


public class permissionDAO{

    private SqlSessionFactory sessionFactory;
    SqlSession session;
    private PermissionMapper permissionMapper;

    public permissionDAO() {
        this.sessionFactory = new SqlSessionFactoryBuilder().build(connect.class.getResourceAsStream("/mybatis-config.xml"));
        session = sessionFactory.openSession();
        permissionMapper = session.getMapper(PermissionMapper.class);
    }

    public List<key> getAllKey() {
        return permissionMapper.getAllKeys();
    }

    public key getPermission(String key) {
        return permissionMapper.getPermission(key);
    }

    public void changePermission(key key) {
        permissionMapper.changePermission(key);
        session.commit();
    }


}
