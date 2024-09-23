package com.example.jspfinalwork.Controller.permission;

import com.example.jspfinalwork.DAO.permissionDAO;
import com.example.jspfinalwork.pojo.key;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "changePerServlet", value = "/changePerServlet")
public class changePerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        permissionDAO pm = new permissionDAO();
        int change = Integer.parseInt(request.getParameter("change"));
        int delete = Integer.parseInt(request.getParameter("delete"));
        String key = request.getParameter("selectedKey");
        key key1 = new key(key,change,delete);
        pm.changePermission(key1);
        List<key> allkey = pm.getAllKey();
        ArrayList<String> keys = new ArrayList<>();
        for(key temp:allkey){
             keys.add(temp.getKey().trim().replace(" ",""));
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("keys",keys);
        getServletContext().getRequestDispatcher("/permissionManage.jsp").forward(request, response);
    }
}
