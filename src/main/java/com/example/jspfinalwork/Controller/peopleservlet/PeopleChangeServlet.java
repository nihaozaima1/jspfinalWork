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
import java.io.UnsupportedEncodingException;
import java.util.List;
@WebServlet("/PeopleChangeServlet")
public class PeopleChangeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        people temps = (people)session.getAttribute("changedPeople");
        String name = temps.getName();
        PeopleDAO pm = new PeopleDAO();
        List<people> temp = pm.getPeopleInformation(name);
        System.out.println(name);
        people f = temp.get(0);
        name = request.getParameter("peoplename");
        String id = f.getId();
        String characteristic = request.getParameter("year");
        String introduce = request.getParameter("introduce");
        String picture = request.getParameter("doc");
        request.setAttribute("doc","");
        session.setAttribute("doc","");
        pm.changePeople(id,name,characteristic,introduce);
        session.setAttribute("panduan",2);
        try {
            getServletContext().getRequestDispatcher("/AllPeopleServlet").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
