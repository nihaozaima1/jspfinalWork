package com.example.jspfinalwork.Controller.foodservlet;
import com.example.jspfinalwork.DAO.foodDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteFoodServlet")
public class deleteFoodServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("111");
        String id = request.getParameter("foodid");
        System.out.println(id);
        foodDAO fm = new foodDAO();
        fm.deleteFood(id);
        RequestDispatcher report = request.getRequestDispatcher("/AllFoodServlet");
        report.forward(request, response);
        getServletContext().getRequestDispatcher("/foodManage.jsp").forward(request, response);
    }
}
