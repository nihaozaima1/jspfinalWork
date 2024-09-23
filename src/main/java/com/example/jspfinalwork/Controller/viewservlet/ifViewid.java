package com.example.jspfinalwork.Controller.viewservlet;
import com.example.jspfinalwork.DAO.viewDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ifViewid")
public class ifViewid extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String url = "/viewAdd.jsp";
        String id = request.getParameter("id");
        viewDAO vm = new viewDAO();
        HttpSession session = request.getSession(true);
        int pan = 0;
        if(id.equals("")||id.equals("null")){
            pan = 3;
        }
        else {
            List<String> ids = vm.getViewId();
            for (String temp : ids) {
                if (temp.equals(id)) {
                    pan = 1;
                }
            }
        }
        System.out.println(id);
        System.out.println(pan);
        if(pan == 0){
            RequestDispatcher report = request.getRequestDispatcher("/viewBeginAdd");
            report.forward(request,response);
        }else if(pan == 1) {
            String lable = "id重复";
            session.setAttribute("lable",lable);
            getServletContext().getRequestDispatcher(url).forward(request,response);
        }else{
            String lable = "id不能为空";
            session.setAttribute("lable",lable);
            getServletContext().getRequestDispatcher(url).forward(request,response);
        }

    }
}
