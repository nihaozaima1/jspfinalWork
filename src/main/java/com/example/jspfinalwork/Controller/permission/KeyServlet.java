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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/KeyServlet")
public class KeyServlet extends HttpServlet {
    String mes = "";
    String url="/manageLogin.jsp";
    int addp =0;
    int deletep = 0;
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String key = request.getParameter("key");
        permissionDAO pm = new permissionDAO();
        List<com.example.jspfinalwork.pojo.key> allkey = pm.getAllKey();
        boolean judge = false;
        for(key temp:allkey){
            System.out.println(temp.getKey());
            if(temp.getKey().trim().replace(" ","").equals(key)){
                judge = true;
                break;
            }
        }
        if (judge) {
            url="/ManagePage.jsp";
            session.setAttribute("key",key);
            addp = pm.getPermission(key).getIfchange();
            deletep = pm.getPermission(key).getIfdelete();
        } else {
            mes = "Wrong Key";
        }
        session.setAttribute("mes",mes);
        session.setAttribute("addp",addp);
        session.setAttribute("deletep",deletep);
        try {
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
