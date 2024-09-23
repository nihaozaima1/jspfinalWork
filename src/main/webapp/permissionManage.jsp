<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.jspfinalwork.pojo.key" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>权限分配</title>
    <style>
        .main {
            width: 500px;
            height: 670px;
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
            margin-left: 110px;
        }
        .main h1{
            margin-left: 110px;
        }
        .main select{
            height: 30px;
            margin-left: 110px;
        }
        .main input{
            margin-top: 20px;
            margin-left: 165px;
        }
        .main p{
            margin-left: 110px;
        }

    </style>
</head>
<body>
<div class="main">
    <form action="changePerServlet" method="get">
        <p>请选择管理员账号：</p>
        <select name="selectedKey" id="selectedKey" onchange="updateSelect2()" style="width: 200px;">
            <option value="">请选择账号</option>
            <%
                ArrayList<String> keys = (ArrayList<String>) session.getAttribute("keys");
                keys.remove(0);
                for (String temp : keys) {
            %>
            <option value="<%= temp %>"><%= temp %></option>
            <%
                }
            %>
        </select>
        <p>删除权限情况：</p>
        <select name="delete" id="delete" style="width: 200px;">
            <option selected>请选择账号</option>
            <option value="1">赋予</option>
            <option value="0">回收</option>
        </select>
        <p>修改权限情况：</p>
        <select name="change" id="change" style="width: 200px;">
            <option selected>请选择账号</option>
            <option value="1">赋予</option>
            <option value="0">回收</option>
        </select>
        <input type="submit" value="确认修改">
    </form>

</div>
</body>
<script>
    function updateSelect2(){
        var selectedKey = document.getElementById("selectedKey");
        var index = selectedKey.selectedIndex;
        var text = selectedKey.options[index].text;
        var deleteSelect = document.getElementById("delete");
        var changeSelect = document.getElementById("change");
        var yes = 1;
        deleteSelect.options[0].selected = true
        changeSelect.options[0].selected = true
        <%
            List<key> allkey = (List<key>)session.getAttribute("allkey");
            allkey.remove(0);
            key a;
            for(key temp:allkey){
        %>
            if(text == <%=temp.getKey().trim().replace(" ","")%>){
                console.log(<%=temp.getKey()%>)
                console.log(<%=temp.getIfchange()%>)
                if(yes == <%=temp.getIfchange()%>){
                    changeSelect.options[0].text = "该管理员拥有修改权限"
                    changeSelect.options[0].value = "1"
                }else{
                    changeSelect.options[0].text = "该管理员没有修改权限"
                    changeSelect.options[0].value = "0"
                }
                if(yes == <%=temp.getIfdelete()%>){
                    deleteSelect.options[0].text = "该管理员拥有删除权限"
                    deleteSelect.options[0].value = "1"
                }else{
                    deleteSelect.options[0].text = "该管理员没有删除权限"
                    deleteSelect.options[0].value = "0"
                }
                changeSelect.options[0].prop()
            }

        <%
            }
        %>
    }


</script>

</html>