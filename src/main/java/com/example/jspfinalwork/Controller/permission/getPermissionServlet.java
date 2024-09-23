package com.example.jspfinalwork.Controller.permission;

import com.example.jspfinalwork.DAO.permissionDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "getPermissionServlet", value = "/getPermissionServlet")
public class getPermissionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        permissionDAO pm = new permissionDAO();
        int change = pm.getPermission(request.getParameter("selectedValue")).getIfchange();
        int delete = pm.getPermission(request.getParameter("selectedValue")).getIfdelete();
        HttpSession session = request.getSession(true);
        session.setAttribute("change",change);
        session.setAttribute("delete",delete);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(change);
        response.getWriter().write(delete);
    }
}
