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
import java.io.*;
import java.net.URLEncoder;

@WebServlet("/setComments")
public class setComments extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String userName = request.getParameter("username");
        String comments = request.getParameter("comments");
        String foodName = request.getParameter("foodname");
        commentsDAO cd = new commentsDAO();
        comments temp = new comments(foodName,userName,comments);
        cd.setComments(temp);
        String encodedUsername = URLEncoder.encode(userName, "UTF-8");
        String encodedFoodname = URLEncoder.encode(foodName, "UTF-8");
        String url = "commentsServlet?username="+encodedUsername+"&foodname="+encodedFoodname;
        response.sendRedirect(url);
    }
}
