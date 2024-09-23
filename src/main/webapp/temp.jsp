<%@ page import="com.example.jspfinalwork.DAO.connect" %>
<%@ page import="com.example.jspfinalwork.pojo.view" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jspfinalwork.DAO.viewDAO" %><%--
  Created by IntelliJ IDEA.
  User: hmpyx
  Date: 2023/6/24
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    viewDAO vm = new viewDAO();
    vm.getConnection();
    List<view> temp  = vm.getViewInformation("梅城");
    byte[] img = null;
    img = temp.get(0).getB();
    ServletOutputStream sos = response.getOutputStream();
    sos.write(img);
    sos.flush();
    sos.close();

%>
