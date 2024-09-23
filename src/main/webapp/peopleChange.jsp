<%@ page import="com.example.jspfinalwork.pojo.food" %>
<%@ page import="com.example.jspfinalwork.pojo.view" %>
<%@ page import="com.example.jspfinalwork.pojo.people" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .main{
            width: 500px;
            height: 650px;
            box-shadow: 0 5px 20px 0 #e8e8e8;
            background-color: white;
            border-radius: 10px;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
        }
        .main h2 {
            color: black;
            margin-left: 220px;
        }
        .form {
            margin-top: 30px;
            margin-left: 60px;
        }
        .form input {
            width: 300px;
            height: 25px;
            border: 1px solid lightgray;
            margin-top: 20px;
            outline: none;      /*输入内容时不显示边框*/
            word-break: break-all;
        }
        .form button {
            width: 150px;
            height: 30px;
            color: white;
            background-color: lightseagreen;
            border-style: none;
            border-radius: 5px;
            font-size: 15px;
            margin-top: 15px;
            margin-left: 30px;
            outline: none;
            cursor: pointer;    /*光标放到上面有小手*/
        }
        .form a{
            width: 0px;
            height: 0px;
            color: white;
            background-color: lightseagreen;
            border-style: none;
            border-radius: 5px;
            font-size: 0px;
            margin-top: 15px;
            margin-right: 30px;
            outline: none;
            cursor: pointer;
        }
    </style>
</head>

<body>
<div class="main">
    <% people temp = (people) session.getAttribute("changedPeople");
    %>
    <h2>编号:<%=temp.getId()%></h2>
    <form action="PeopleChangeServlet" method="get" class="form">
        人名: <input type="text" name="peoplename" value=<%=temp.getName()%>><br>    <!--输入的用户名保存到username变量，传回后端-->
        时代: <input type="text" name="year" value=<%=temp.getYear()%>><br>
        介绍: <textarea rows="10" style="width: 300px" type="text" name = "introduce" ><%=temp.getIntroduce()%></textarea><br>
        图片: <input type="file" id="picture" onchange="getFile(value)"><br>
        路径: <input type="text" id="doc" name="doc">
        <button type="submit">上传</button>
        <a href="peopleManage.jsp">
            <button type="button">返回</button>
        </a>
    </form>
</div>
</body>
<script>
    function getFile(value){
        let oFReader = new FileReader();
        var doc = document.getElementById('doc');
        var picture = document.getElementById('picture');
        var fileName = picture.files[0].name;
        var filePath = picture.value;
        doc.value = filePath;
    }
</script>
</html>
