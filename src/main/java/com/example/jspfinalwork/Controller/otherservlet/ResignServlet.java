package com.example.jspfinalwork.Controller.otherservlet;
import com.example.jspfinalwork.DAO.LoginRegisterDAO;
import com.example.jspfinalwork.DAO.connect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

@WebServlet("/ResignServlet")
public class ResignServlet extends HttpServlet{
    public ResignServlet(){
        super();
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String message = "";
        String url = "/resign.jsp";

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        HttpSession session = request.getSession(true);
        if(!password.equals(repassword)){
            message = "两次输入密码不同";
            url = "/resign.jsp";
        }else{
            LoginRegisterDAO lm = new LoginRegisterDAO();
            lm.beginResign(username,password,email,telephone);
            url = "/login.jsp";
            message = "创建账号成功";
        }
        Enumeration e1=request.getParameterNames();//获取所有参数名
        while(e1.hasMoreElements()){//通过Enumeration类中的hasMoreElements()判断是否还有参数名
            String parameterName=(String)e1.nextElement(); //获取当前参数名
            //再通过request.getParameter("")的方法来获取对应参数名的值
            System.out.println(parameterName+": "+request.getParameter(parameterName));
        }

        session.setAttribute("message",message);
        try {
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}



