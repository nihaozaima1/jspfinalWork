package com.example.jspfinalwork.Controller.peopleservlet;

import com.example.jspfinalwork.DAO.PeopleDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deletePeopleServlet")
public class deletePeopleServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("peopleid");
        System.out.println(id);
        PeopleDAO pm = new PeopleDAO();
        pm.deletePeople(id);
        RequestDispatcher report = request.getRequestDispatcher("/AllPeopleServlet");
        report.forward(request, response);
        getServletContext().getRequestDispatcher("/PeopleManage.jsp").forward(request, response);
    }
}
