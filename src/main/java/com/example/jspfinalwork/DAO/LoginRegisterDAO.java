package com.example.jspfinalwork.DAO;

import com.example.jspfinalwork.mapper.LoginRegisterMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.util.List;

public class LoginRegisterDAO {
    private SqlSessionFactory sessionFactory;
    SqlSession session;
    private LoginRegisterMapper loginRegisterMapper;

    public LoginRegisterDAO() {
        this.sessionFactory = new SqlSessionFactoryBuilder().build(connect.class.getResourceAsStream("/mybatis-config.xml"));//加载mybatis信息
        session = sessionFactory.openSession();
        loginRegisterMapper = session.getMapper(LoginRegisterMapper.class);//获得映射器
    }

    public boolean checkAccount(String username, String ipassword) {
        return loginRegisterMapper.checkAccount(username, ipassword);
    }

    public List<String> getId() {
        return loginRegisterMapper.getId();
    }

    public void beginResign(String username, String password, String email, String telephone) {
        loginRegisterMapper.beginResign(username, password, email, telephone);
        session.commit();
    }
}