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
@WebServlet("/AllPeopleServlet")
public class AllPeopleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession(true);
        PeopleDAO pm = new PeopleDAO();
        List<people> peoples = pm.getAllPeople();
        session.setAttribute("peoples",peoples);
        request.setAttribute("views",peoples);
        String pan = request.getParameter("panduan");
        pan = String.valueOf(pan);
        System.out.println(pan);
        if(pan.equals("1")) {
            getServletContext().getRequestDispatcher("/peoplemain.jsp").forward(request, response);
        }else{
            getServletContext().getRequestDispatcher("/peopleManage.jsp").forward(request, response);
        }

    }
}
