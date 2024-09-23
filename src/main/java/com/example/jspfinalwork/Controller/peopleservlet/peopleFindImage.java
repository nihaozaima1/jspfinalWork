package com.example.jspfinalwork.Controller.peopleservlet;

import com.example.jspfinalwork.DAO.PeopleDAO;
import com.example.jspfinalwork.pojo.people;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
@WebServlet("/peopleFindImage")
public class peopleFindImage extends HttpServlet {
    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        byte[] img = null;
        String name=request.getParameter("name");
        System.out.println(name);
        PeopleDAO pm  = new PeopleDAO();
        List<people> temp = pm.getPeopleInformation(name);
        people fo = temp.get(0);
        img = fo.getB();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(img);
        outputStream.flush();//排出流中所有数据
        outputStream.close();//关闭流
    }
}
