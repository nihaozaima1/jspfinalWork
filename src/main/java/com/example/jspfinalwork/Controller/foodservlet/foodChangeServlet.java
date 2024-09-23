package com.example.jspfinalwork.Controller.foodservlet;
import com.example.jspfinalwork.DAO.foodDAO;
import com.example.jspfinalwork.pojo.food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/foodChangeServlet")
public class foodChangeServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        HttpSession session = request.getSession();
        food temps = (food)session.getAttribute("changedFood");
        String name = temps.getName();
        foodDAO fm = new foodDAO();
        List<food> temp = fm.getFoodInformation(name);
        System.out.println(name);
        food f = temp.get(0);
        String id = f.getId();
        name = request.getParameter("foodname");
        String origin = request.getParameter("origin");
        String introduce = request.getParameter("introduce");
        String picture = request.getParameter("doc");
        request.setAttribute("doc","");

        session.setAttribute("doc","");
        File file = new File(picture);
        InputStream is = new FileInputStream(file);
        byte[] picturebyte = new byte[is.available()];
        food f1 = new food(id,name,origin,introduce,picturebyte);
        fm.changeFood(f1);

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        if (!picture.equals("null") && !picture.equals("")) {
            File file1 = new File(picture);
            try {
                InputStream is1 = new FileInputStream(file1);
                System.out.println(file1);
                params.put("pictureInputSteam", is1);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fm.updatePicture(params);
        }

        session.setAttribute("puanduan",2);
        try {
            getServletContext().getRequestDispatcher("/AllFoodServlet").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
