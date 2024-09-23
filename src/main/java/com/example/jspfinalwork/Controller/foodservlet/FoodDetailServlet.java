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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/FoodDetailServlet")//
public class FoodDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public FoodDetailServlet(){
        super();
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String name = request.getParameter("xm");
        HttpSession session = request.getSession(true);
        List<food> foodtemp = new ArrayList<>();
        foodDAO fm = new foodDAO();
        foodtemp = fm.getFoodInformation(name);
        session.setAttribute("food",foodtemp);
        System.out.println(session.getAttribute("food"));
        String url = "/showdetail.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
}
