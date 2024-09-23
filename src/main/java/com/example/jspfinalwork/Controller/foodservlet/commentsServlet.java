package com.example.jspfinalwork.Controller.foodservlet;
import com.example.jspfinalwork.DAO.commentsDAO;
import com.example.jspfinalwork.DAO.foodDAO;
import com.example.jspfinalwork.pojo.comments;
import com.example.jspfinalwork.pojo.food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/commentsServlet")
public class commentsServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String userName = request.getParameter("username");
        String foodName = request.getParameter("foodname");
        HttpSession session = request.getSession(true);
        System.out.println(userName);
        System.out.println(foodName);
        commentsDAO cd = new commentsDAO();
        List<comments> comments = cd.getComments(foodName);
        session.setAttribute("comments",comments);
        session.setAttribute("username",userName);
        session.setAttribute("foodname",foodName);
        getServletContext().getRequestDispatcher("/comments.jsp").forward(request, response);
    }
}
