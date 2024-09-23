<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        .main {
            width: 600px;
            height: 400px;
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
        }
        .form {
            margin-top: 30px;
            margin-left: 60px;
            margin-right: 60px;
        }
        .form input {
            width: 200px;
            height: 25px;
            border: 1px solid lightgray;
            border-radius: 8px;
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
            text-align: center;
            outline: none;
            cursor: pointer;    /*光标放到上面有小手*/
        }
        .form label{
            margin-top: 15px;
            text-align: left;
            width: 100px;
            margin-left: 80px;
        }
    </style>
</head>
<body>
    <div class = "main">
        <h2 style="text-align: center">注册界面</h2>
        <form action="ResignServlet" method="post" class="form">
            <label>&nbsp;&nbsp;&nbsp;用户名:</label><input type="text"name="username"><br>    <!--输入的用户名保存到username变量，传回后端-->
            <label>&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码:</label><input type="password"name="password"><br>
            <label>确认密码:</label><input type="password"name="repassword"><br>
            <label>&nbsp;&nbsp;&nbsp;邮&nbsp;&nbsp;&nbsp;箱:</label><input type="text"name="email"><br>
            <label>手机号码:</label><input type="text"name="telephone"><br>


            <p style="text-align: center">
                <button type="submit">注册</button>
            </p>
        </form>

        <div style="text-align: center;">
            <p>${message}</p>
        </div>
        <div>
            <p style="text-align: right">已有账号，<a href="login.jsp">立即登录</a></p>
        </div>
    </div>
</body>
<%
    String mess=(String)session.getAttribute("message");  //接收后台传来的message
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
