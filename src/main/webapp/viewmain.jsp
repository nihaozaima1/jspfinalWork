<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    #top{
        position:absolute;
        left:0%;
        top:5%;
        width: 100%;
        height: 15%;
        text-align: center;
    }
    #mainframe{
        position:absolute;
        left:0%;
        top:15%;
        width:100%;
        height:85%;
    }
</style>
<body>
<div id="top">
    <form  action="ViewDetailServlet" target="detail" method="post"class="form">
        景点名称<input type="text" size="10" name="xm"/>
        <input type="submit" value="查询"/>
    </form>
</div>
<div id="mainframe">
    <iframe name="detail" src="ViewshowTodoList.jsp?page=1" title="mainFrame" width="100%" height="100%"></iframe>
</div>
</body>
</html>
