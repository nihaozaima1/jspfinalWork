<%@ page import="com.example.jspfinalwork.pojo.comments" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        .main{
            float: left;
            width: 250px;
            height: 150px;
            box-shadow: 0 5px 20px 0 #e8e8e8;
            background-color: white;
            border-radius: 10px;
        }
         .button {
             margin-left: 50px;
         }
        .modal {
            display: none; /* 默认隐藏弹窗 */
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.5); /* 半透明黑色背景 */
        }

        .modal-content {
            background-color: #fefefe;
            margin: 20% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 300px;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }

        .close:hover, .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
    <%
        String food = (String)session.getAttribute("foodname");
        List<comments> commentsList =(List<comments>) session.getAttribute("comments");
    %>
    <title><%=food%></title>
</head>
<body>
<h1><%=food%>
    <button onclick="showModal()">发表评论</button>
</h1>
<%
    for(comments temp:commentsList){
%>
<div class="main">
    <a><%=temp.getUserName()%></a>
    <br>
    <br>

    <label>评论内容:</label><br>
    <a><%=temp.getComments()%></a>
</div>
<%
    }
%>
<div id="myModal" class="modal">
    <div class="modal-content">
        <%
            String username = (String) session.getAttribute("username");
        %>
        <form action="setComments?username=<%=username%>&foodname=<%=food%>" method="post" class="form">
            <span class="close" onclick="closeModal()">&times;</span>
            <h3>输入评论内容</h3>
            <textarea rows="3" type="text" name = "comments" style="width: 200px"></textarea>
            <button class="button">提交</button>
        </form>
    </div>
</div>
</body>
<script>
    function showModal() {
        var modal = document.getElementById("myModal");
        modal.style.display = "block";
    }

    function closeModal() {
        var modal = document.getElementById("myModal");
        modal.style.display = "none";
    }
</script>
</html>