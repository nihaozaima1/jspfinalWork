package com.example.jspfinalwork.Controller.otherservlet;
import com.example.jspfinalwork.DAO.LoginRegisterDAO;
import com.example.jspfinalwork.DAO.connect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/LoginServlet")//读取/LoginServlet完整路径
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String message = "";//定义一个变量

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/login.jsp";
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(true);
        String userid = "";
        LoginRegisterDAO lm = new LoginRegisterDAO();
        url = "/register.jsp";
        if (lm.checkAccount(username, password)) {
            //用于记录该用户状态
            //cookie加入用户名
            Cookie u = new Cookie("userid", username);
            //设置有效期
            u.setMaxAge(60 * 60 * 24 * 365 * 2);
            //设置路径
            u.setPath("/");
            //将cookie加入浏览器
            response.addCookie(u);
            session.setAttribute("userid", userid);
            //调用selectU从message表中读出所有数据
            url = "/index.html";
            session.setAttribute("username",username);
        } else {
            message = "Wrong password";
            url = "/login.jsp";
            session.setAttribute("msg", message);

        }

        //设置登入是否成功的提示信息

        session.setAttribute("message", message);
        session.setAttribute("msg", message);
        //调用forward()方法，转发请求
        try {
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


