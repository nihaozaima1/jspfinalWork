<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
    <style>
        .main {
            width: 500px;
            height: 300px;
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
            color: lightseagreen;
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
    <h2>欢迎</h2>
    <form action="KeyServlet" method="post" class="form">
        输入密钥: <input type="text", name="key"><br>
        <button type="submit">登录</button>
        <a href="index.html">
            <button type="button">返回</button>
        </a>
    </form>

    <div style="text-align: center;">
        <!-- 获取登录是否成功信息 -->
        <p class="col">${mes}</p>
    </div>
</div>
</body>
<%
    String mess=(String)session.getAttribute("mes");  //接收后台传来的message
    if(mess!=null&&!mess.equals("")){  //判断message
%>
<script type="text/javascript">
    alert("<%=mess%>");  //弹出警示框
</script>
<%
        session.setAttribute("message","");  //将message值设为空，否则将一直弹出。
    }
%>
</html>
