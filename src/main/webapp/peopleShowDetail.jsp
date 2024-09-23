<%@ page import="com.example.jspfinalwork.pojo.food" %>
<%@ page import="java.util.List" %>
<%@ page import="javax.swing.text.View" %>
<%@ page import="com.example.jspfinalwork.pojo.view" %>
<%@ page import="com.example.jspfinalwork.pojo.people" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type = "text/css" rel="stylesheet" href="/css/show.css">
    <style>
        .food-image {
            max-width: 100px;
            max-height: 100px;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>时代</th>
        <th>介绍</th>
        <th>图片</th>
    </tr>
    <tbody>
    <%
        List<people> views = (List) session.getAttribute("people");
        for(people temp:views){
    %>
    <tr>
        <td width="50px"><%=temp.getId() %></td>
        <td width="100px"><%=temp.getName() %></td>
        <td width="80px"><%=temp.getYear() %></td>
        <td><%=temp.getIntroduce() %></td>
        <td width="100"><img src="peopleFindImage?name=<%=temp.getName()%>" class = "food-image"/></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
