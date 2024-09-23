<%@ page import="com.example.jspfinalwork.pojo.food" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type = "text/css" rel="stylesheet" href="css/show.css">
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
        <th>食物名称</th>
        <th>起源</th>
        <th>介绍</th>
        <th>图片</th>
    </tr>
    <tbody>
    <%
        List<food> foods = (List) session.getAttribute("food");
        for(food temp:foods){
    %>
    <tr>
        <td width="50px"><%=temp.getId() %></td>
        <td width="100px"><%=temp.getName() %></td>
        <td width="80px"><%=temp.getOrigin() %></td>
        <td><%=temp.getIntroduce() %></td>
        <td width="100"><img src="findImg?name=<%=temp.getName()%>" class="food-image"/></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
