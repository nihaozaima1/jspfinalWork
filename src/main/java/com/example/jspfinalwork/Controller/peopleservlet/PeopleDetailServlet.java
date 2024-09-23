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
import java.util.ArrayList;
import java.util.List;
@WebServlet("/PeopleDetailServlet")
public class PeopleDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public PeopleDetailServlet(){
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
        List<people> peopletemp = new ArrayList<>();
        PeopleDAO pm  = new PeopleDAO();
        peopletemp = pm.getPeopleInformation(name);
        session.setAttribute("people",peopletemp);
        System.out.println(session.getAttribute("people"));
        String url = "/peopleShowDetail.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
}
