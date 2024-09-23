package com.example.jspfinalwork.Controller.peopleservlet;

import com.example.jspfinalwork.DAO.PeopleDAO;
import com.example.jspfinalwork.pojo.people;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/getChangePeople")
public class getChangePeople extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("peoplename");
        PeopleDAO pm = new PeopleDAO();
        List<people> temp = pm.getPeopleInformation(name);
        people changedPeople = temp.get(0);
        HttpSession session = request.getSession(true);
        session.setAttribute("changedPeople",changedPeople);
        System.out.println(changedPeople.getName());
        try {
            request.getRequestDispatcher("/peopleChange.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
