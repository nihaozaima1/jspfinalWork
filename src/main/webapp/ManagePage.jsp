<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员界面</title>
</head>
<style>
    #top{
        height: 20px;
    }
    #navigation{
        position: relative;
        width: 100%;
        height: 40px;
        background-color: rgb(0, 0, 0);
    }
    #main{
        float: left;
        width: 100%;
        height:700px;
    }
</style>
<body>
    <div id="top">
        <a href="index.html">←返回</a>
    </div>
    <div id="navigation" >
        <a style="font-size: 30px;color: rgb(255, 255, 255);position: relative; ;left: 2%;text-decoration: none" href="AllFoodServlet?panduan=2" target="mainbody">食物管理</a>
        <a style="font-size: 30px;color: rgb(255, 255, 255);position: relative; ;left: 10%;text-decoration: none" href="AllViewServlet?panduan=2" target="mainbody">景点管理</a>
        <a style="font-size: 30px;color: rgb(255, 255, 255);position: relative; ;left: 18%;text-decoration: none" href="AllPeopleServlet?panduan=2" target="mainbody">人文管理</a>
        <%  String key = (String)session.getAttribute("key");
            key.replace(" ","");
            key.trim();
            if(key.equals("12345")){
        %>
        <a style="font-size: 30px;color: rgb(255, 255, 255);position: relative; ;left: 26%;text-decoration: none" href="getKeyServlet" target="mainbody">权限管理</a>
        <%
            }
        %>
    </div>
    <div id="main">
        <iframe style = "border: medium none;" name="mainbody" frameborder="1" width="100%"  height="100%"/>
    </div>
</body>
</html>