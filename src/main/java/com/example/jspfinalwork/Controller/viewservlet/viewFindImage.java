package com.example.jspfinalwork.Controller.viewservlet;
import com.example.jspfinalwork.DAO.viewDAO;
import com.example.jspfinalwork.pojo.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
@WebServlet("/viewFindImage")
public class viewFindImage extends HttpServlet{

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
        viewDAO vm = new viewDAO();
        List<view> temp = vm.getViewInformation(name);
        view fo = temp.get(0);
        System.out.println(temp.get(0).getB());
        img = fo.getB();
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(img);
        outputStream.flush();//排出流中所有数据
        outputStream.close();//关闭流
    }
}
