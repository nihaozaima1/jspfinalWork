package com.example.jspfinalwork.Controller.foodservlet;
import com.example.jspfinalwork.DAO.foodDAO;
import com.example.jspfinalwork.pojo.food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/getChangeFood")
public class getChangedFood extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("foodname");
        foodDAO fm = new foodDAO();
        List<food> temp = fm.getFoodInformation(name);
        food changedFood = temp.get(0);
        HttpSession session = request.getSession(true);
        session.setAttribute("changedFood",changedFood);
        System.out.println(changedFood.getName());
        try {
            request.getRequestDispatcher("/foodChange.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
