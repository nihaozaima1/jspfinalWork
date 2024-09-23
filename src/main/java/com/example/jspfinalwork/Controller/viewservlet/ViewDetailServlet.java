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
import java.util.ArrayList;
import java.util.List;
@WebServlet("/ViewDetailServlet")
public class ViewDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ViewDetailServlet(){
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
        List<view> viewtemp = new ArrayList<>();
        viewDAO vm = new viewDAO();
        viewtemp = vm.getViewInformation(name);
        session.setAttribute("view",viewtemp);
        System.out.println(session.getAttribute("view"));
        for(view temp:viewtemp) {
            System.out.println(temp.getName());
        }
        String url = "/ViewshowDetail.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
}
