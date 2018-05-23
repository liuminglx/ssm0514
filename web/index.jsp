<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/14
  Time: 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<fieldset>
    <legend>springmvc 使用变量接收</legend>
    <form action="member/selectById" method="post">
        <input type="text" name="id">
        <input type="submit" value="查询">
    </form>
</fieldset>
<fieldset>
    <legend>springmvc 使用对象接收</legend>
    <form action="member/selectByMember" method="post">
        <input type="text" name="id">
        <input type="submit" value="查询">
    </form>
</fieldset>
<fieldset>
    <legend>springmvc 直接跳转页面</legend>
    <form action="member/toResult" method="post">
        <input type="submit" value="跳转">
    </form>
</fieldset>
<fieldset>
    <legend>springmvc 接收ajax</legend>
    <input type="text" name="id" id="memId">
    <button id="btnSelect">查询</button>
    <button id="btnSelectBetter">更好的查询</button>
</fieldset>
<fieldset>
    <legend>springmvc 接收ajax数组</legend>
    <button id="btnArray">查询</button>
</fieldset>
<fieldset>
    <legend>springmvc 删除数据</legend>
    <form action="member/deleteById" method="post">
        <input type="text" name="id">
        <input type="submit" value="删除">
    </form>
</fieldset>
<fieldset>
    <legend>springmvc 添加数据</legend>
    <form action="member/insertMember" method="post">
        id:<input type="text" name="id"><br>
        name:<input type="text" name="name"><br>
        sex:<input type="radio" name="sex" value="男" checked>男
        <input type="radio" name="sex" value="女">女<br>
        salary:<input type="text" name="salary"><br>
        department:<select name="department">
        <option value="市场部">市场部</option>
        <option value="销售部">销售部</option>
        <option value="生产部">生产部</option>
        <option value="财务部">财务部</option>
        <option value="人力部">人力部</option>
        <option value="总务部">总务部</option>
    </select><br>
        <input type="submit" value="添加">
    </form>
</fieldset>
<fieldset>
    <legend>mybatis 动态查询</legend>
    <form action="member/selectMembers" method="post">
        id:<input type="text" name="id"><br>
        name:<input type="text" name="name"><br>
        sex:<input type="radio" name="sex" value="男">男
        <input type="radio" name="sex" value="女">女
        <input type="radio" name="sex" value="" checked>全部<br>
        salary:<input type="text" name="salary"><br>
        department:<select name="department">
        <option value="">全部</option>
        <option value="市场部">市场部</option>
        <option value="销售部">销售部</option>
        <option value="生产部">生产部</option>
        <option value="财务部">财务部</option>
        <option value="人力部">人力部</option>
        <option value="总务部">总务部</option>
    </select><br>
        <input type="submit" value="动态查询"></input>
    </form>
</fieldset>
<fieldset>
    <legend>mybatis 多条id范围查询</legend>
    <form action="member/selectByIds" method="post">
        id1:<input type="text" name="id"><br>
        id2:<input type="text" name="id"><br>
        id3:<input type="text" name="id"><br>
        <input type="submit" value="范围查询">
    </form>
</fieldset>
<script src="js/jquery-1.12.4.js"></script>
<script src="js/index.js?version=20180516"></script>
<script>
    $(function () {
        $('#btnSelect').click(function () {
            $.ajax({
                url: 'member/selectByAjax',
                data: {id: $('#memId').val()},
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                },
                error: function () {
                    console.log('失败');
                }
            })
        })
    });

    $(function () {
        $('#btnSelectBetter').click(function () {
            $.ajax({
                url: 'member/selectByAjaxBetter',
                data: {id: $('#memId').val()},
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    console.log(data.member);
                },
                error: function () {
                    console.log('失败');
                }
            })
        })
    });

    $(function () {
        $('#btnArray').click(function () {
            var ids = [];
            ids.push('1');
            ids.push('2');
            ids.push('3');
            $.ajax({
                url: 'member/selectByIdsAjax',
                data: {id: ids},
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                },
                error: function () {
                    console.log('失败');
                }
            })
        })
    });
</script>
</body>
</html>
