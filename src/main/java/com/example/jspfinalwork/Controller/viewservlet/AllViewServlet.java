package com.example.jspfinalwork.Controller.viewservlet;
import com.example.jspfinalwork.DAO.viewDAO;
import com.example.jspfinalwork.pojo.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/AllViewServlet")
public class AllViewServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession(true);
        viewDAO vm = new viewDAO();
        List<view> views = vm.getAllView();
        session.setAttribute("views",views);
        request.setAttribute("views",views);
        String pan = request.getParameter("panduan");
        pan = String.valueOf(pan);
        System.out.println(pan);
        if(pan.equals("1")) {
            getServletContext().getRequestDispatcher("/viewmain.jsp").forward(request, response);
        }else{
            getServletContext().getRequestDispatcher("/viewManage.jsp").forward(request, response);
        }

    }
}
