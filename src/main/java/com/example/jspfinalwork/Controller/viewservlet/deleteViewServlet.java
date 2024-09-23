package com.example.jspfinalwork.Controller.viewservlet;
import com.example.jspfinalwork.DAO.viewDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteViewServlet")
public class deleteViewServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("111");
        String id = request.getParameter("viewid");
        System.out.println(id);
        viewDAO vm = new viewDAO();
        vm.deleteView(id);
        RequestDispatcher report = request.getRequestDispatcher("/AllViewServlet");
        report.forward(request, response);
        getServletContext().getRequestDispatcher("/viewManage.jsp").forward(request, response);
    }
}
