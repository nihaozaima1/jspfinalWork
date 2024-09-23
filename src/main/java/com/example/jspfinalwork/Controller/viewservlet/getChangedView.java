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
import java.util.List;

@WebServlet("/getChangeView")
public class getChangedView extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response){
        String name = request.getParameter("viewname");
        viewDAO vm = new viewDAO();
        List<view> temp = vm.getViewInformation(name);
        view changedView = temp.get(0);
        HttpSession session = request.getSession(true);
        session.setAttribute("changedView",changedView);
        System.out.println(changedView.getName());
        try {
            request.getRequestDispatcher("/viewChange.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
