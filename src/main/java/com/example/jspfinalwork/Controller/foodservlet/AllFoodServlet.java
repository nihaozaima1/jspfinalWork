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
import java.util.List;

@WebServlet("/AllFoodServlet")
public class AllFoodServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession(true);
        foodDAO fm = new foodDAO();
        List<food> foods = fm.getAllFood();
        session.setAttribute("foods",foods);
        request.setAttribute("foods",foods);
        String pan = request.getParameter("panduan");
        pan = String.valueOf(pan);
        System.out.println(pan);
        if(pan.equals("1")) {
            getServletContext().getRequestDispatcher("/foodmain.jsp").forward(request, response);
        }else{
            getServletContext().getRequestDispatcher("/foodManage.jsp").forward(request, response);
        }

    }
}
