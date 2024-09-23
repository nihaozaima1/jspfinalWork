package com.example.jspfinalwork.Controller.peopleservlet;

import com.example.jspfinalwork.DAO.PeopleDAO;
import com.example.jspfinalwork.pojo.people;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/peopleBeginAdd")
public class peopleBeginAdd extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String year = request.getParameter("year");
        String introduce = request.getParameter("introduce");
        String picture = request.getParameter("doc");
        request.setAttribute("doc","");
        HttpSession session = request.getSession(true);
        session.setAttribute("doc","");
        System.out.println(picture);
        PeopleDAO pm = new PeopleDAO();
        File file = new File(picture);
        InputStream is = new FileInputStream(file);
        byte[] peoplebyte = new byte[is.available()];
        people p = new people(id,name,year,introduce,peoplebyte);
        pm.insertPeople(p);

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        if (!picture.equals("null") && !picture.equals("")) {
            File file1 = new File(picture);
            try {
                InputStream is1 = new FileInputStream(file1);
                System.out.println("file"+file1);
                params.put("pictureInputSteam", is1);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            pm.updatePicture(params);
        }

        getServletContext().getRequestDispatcher("/AllPeopleServlet").forward(request,response);
    }
}
