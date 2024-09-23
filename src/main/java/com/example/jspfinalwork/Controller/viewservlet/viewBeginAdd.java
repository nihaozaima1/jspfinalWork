package com.example.jspfinalwork.Controller.viewservlet;
import com.example.jspfinalwork.DAO.viewDAO;
import com.example.jspfinalwork.pojo.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/viewBeginAdd")
public class viewBeginAdd extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String characteristic = request.getParameter("characteristic");
        String introduce = request.getParameter("introduce");
        String picture = request.getParameter("doc");
        request.setAttribute("doc","");
        HttpSession session = request.getSession(true);
        session.setAttribute("doc","");
        System.out.println("打印照片"+picture);
        viewDAO vm = new viewDAO();
        id = String.valueOf(id);
        File file = new File(picture);
        InputStream is = new FileInputStream(file);
        byte[] picturebyte = new byte[is.available()];
        view view = new view(id,name,characteristic,introduce,picturebyte);
        vm.insertView(view);

        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        if (!picture.equals("null") && !picture.equals("")) {
            File file1 = new File(picture);
            try {
                InputStream is1 = new FileInputStream(file1);
                System.out.println("file1"+file1);
                params.put("pictureInputSteam", is1);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            vm.updatePicture(params);
        }
        getServletContext().getRequestDispatcher("/AllViewServlet").forward(request,response);
    }
}
