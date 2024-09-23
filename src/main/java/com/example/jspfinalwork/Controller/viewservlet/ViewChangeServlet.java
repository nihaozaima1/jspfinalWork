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
@WebServlet("/ViewChangeServlet")
public class ViewChangeServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        view temps = (view)session.getAttribute("changedView");
        String name = temps.getName();
        viewDAO vm = new viewDAO();
        List<view> temp = vm.getViewInformation(name);
        System.out.println(name);
        view f = temp.get(0);
        name = request.getParameter("viewname");
        String id = f.getId();
        String characteristic = request.getParameter("characteristic");
        String introduce = request.getParameter("introduce");
        String picture = request.getParameter("doc");
        request.setAttribute("doc","");
        session.setAttribute("doc","");
        vm.changView(id,name,characteristic,introduce,picture);
        session.setAttribute("panduan",2);
        try {
            getServletContext().getRequestDispatcher("/AllViewServlet").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
