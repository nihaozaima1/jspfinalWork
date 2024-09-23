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
        .form textarea{
            margin-top: 20px;
        }
        .bu{
            text-align: center;
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
            text-align: center;
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
    <form action="ifPeopleid" method="get" class="form">
        编号：<input name="id" type="text"/><br>
        人名：<input name="name" type="text"/><br>
        年代：<input name="year" type="text"/><br>
        介绍: <textarea rows="10" style="width: 300px" type="text" name = "introduce" ></textarea><br>
        图片: <input type="file" id="picture" onchange="getFile(value)"><br>
        路径: <input type="text" id="doc" name="doc">
        <div class="bu">
            <button type="submit">上传</button>
        </div>
    </form>
    <div style="text-align: center;">
        <!-- 获取登录是否成功信息 -->
        <p class="col">${lable}</p>
    </div>
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
