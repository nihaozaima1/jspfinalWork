package com.example.jspfinalwork.Controller.permission;
import com.example.jspfinalwork.DAO.permissionDAO;
import com.example.jspfinalwork.pojo.key;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getKeyServlet")
public class getKeyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        permissionDAO pm =new permissionDAO();
        List<key> allkey = pm.getAllKey();
        ArrayList<String> keys = new ArrayList<>();
        for(key temp:allkey){
            keys.add(temp.getKey().trim().replace(" ",""));
        }
        System.out.println("wsws");
        HttpSession session = request.getSession(true);
        session.setAttribute("allkey",allkey);
        session.setAttribute("keys",keys);
        getServletContext().getRequestDispatcher("/permissionManage.jsp").forward(request, response);
    }

}
