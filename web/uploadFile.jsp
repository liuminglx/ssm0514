<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/22
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<fieldset>
    <legend>单文件上传</legend>
    <form action="uploadFile" method="post" enctype="multipart/form-data" id="form1">
        <input type="text" name="username">
        <input type="file" name="file"><br>
        <input type="submit" value="表单上传">
        <input type="button" value="ajax上传" id="btnUploadFile">
    </form>
</fieldset>

<fieldset>
    <legend>多文件上传</legend>
    <form action="uploadFiles" method="post" enctype="multipart/form-data" id="form2">
        <input type="text" name="username">
        <input type="file" name="file">
        <input type="file" name="file"><br>
        <input type="submit" value="表单上传">
        <input type="button" value="ajax上传" id="btnUploadFiles">
    </form>
</fieldset>
<script src="js/jquery-1.12.4.js"></script>
<script>

    // 单文件上传
    $(function () {
        $("#btnUploadFile").click(function () {

            var dataForm = new FormData($('#form1')[0]);

            $.ajax({
                url: 'uploadFile',
                data: dataForm,
                contentType: false,
                processData: false,
                type: 'post',
                dataType: 'text',
                success: function (data) {
                    alert('成功');
                },
                error: function () {
                    alert('失败');
                }
            })
        })
    });

    // 多文件上传
    $(function () {
        $("#btnUploadFiles").click(function () {

            var dataForm = new FormData($('#form2')[0]);

            $.ajax({
                url: 'uploadFiles',
                data: dataForm,
                contentType: false,
                processData: false,
                type: 'post',
                dataType: 'text',
                success: function (data) {
                    alert('成功');
                },
                error: function () {
                    alert('失败');
                }
            })
        })
    })
</script>
</body>
</html>
