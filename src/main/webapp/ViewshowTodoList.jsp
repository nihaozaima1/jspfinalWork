<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jspfinalwork.pojo.food" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jspfinalwork.pojo.view" %>
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
        <th>特色</th>
        <th>介绍</th>
        <th>图片</th>
    </tr>
    <tbody>
    <%
        List<view> views = (List) session.getAttribute("views");
        if(views != null){
            for(view temp:views){
    %>
    <tr>
        <td width="50px"><%=temp.getId() %></td>
        <td width="100px"><%=temp.getName() %></td>
        <td width="80px"><%=temp.getCharacteristic() %></td>
        <td><%=temp.getIntroduce() %></td>
        <td width="100"><img src="viewFindImage?name=<%=temp.getName()%>" class="food-image"/></td>
            <%
                    }
                }
            %>
    </tbody>
</table>

</body>

</html>
