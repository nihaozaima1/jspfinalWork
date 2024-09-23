<%@ page import="com.example.jspfinalwork.pojo.food" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.jspfinalwork.pojo.view" %>
<%@ page import="com.example.jspfinalwork.pojo.people" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link type = "text/css" rel="stylesheet" href="css/show.css">
    <style>
        .it{
            text-align: center;
            margin-bottom: 10px;
        }
        .food-image {
            max-width: 100px;
            max-height: 100px;
        }
    </style>
</head>
<body>
<div class="it">
    <form action="peopleAdd.jsp">
        <input  type="submit" value="添加新的人文"/>
    </form>
</div>
<table>
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>时代</th>
        <th>介绍</th>
        <th>图片</th>
        <th>管理</th>
    </tr>
    <tbody>
    <%
        List<people> peoples = (List) session.getAttribute("peoples");
        if(peoples != null){
            for(people temp:peoples){
    %>
    <tr>
        <td width="50px"><%=temp.getId() %></td>
        <td width="100px"><%=temp.getName() %></td>
        <td width="80px"><%=temp.getYear() %></td>
        <td width="1000px"><%=temp.getIntroduce() %></td>
        <td width="100"><img src="peopleFindImage?name=<%=temp.getName()%>" class = "food-image"/></td>
        <td>
            <%
                int addp = (int) session.getAttribute("addp");
                if(addp==1){
            %>
            <a type="submit" href="getChangePeople?peoplename=<%=temp.getName()%>"> 更改    </a>
            <%
                }
                int deletep = (int) session.getAttribute("deletep");
                if(deletep==1){
            %>
            <a type="submit" href="deletePeopleServlet?peopleid=<%=temp.getId()%>" value="删除">删除</a>
            <%
                        }
                    }
                }
            %>
        </td>



    </tbody>

</table>
</body>
</html>
