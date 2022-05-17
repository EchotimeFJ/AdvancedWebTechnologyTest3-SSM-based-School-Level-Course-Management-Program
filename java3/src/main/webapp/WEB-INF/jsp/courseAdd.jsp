<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2022/4/22
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-3">
    <form class="form-horizontal" >
        <div class="form-group">
            <div class="col-sm-10">
                <input type="hidden" class="form-control" name="courseId" id="courseId" value="0">
            </div>
        </div>
        <div class="form-group">
            <label for="courseName" class="col-sm-2 control-label">课程名称</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="courseName" id="courseName">
            </div>
        </div>
        <div class="form-group">
            <label for="courseHours" class="col-sm-2 control-label">课时</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="courseHours" id="courseHours">
            </div>
        </div>
        <div class="form-group">
            <label for="academyId" class="col-sm-2 control-label">所属学院</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="academyId" id="academyId">
            </div>
        </div>
        <div class="form-group">
            <label for="academyId" class="col-sm-2 control-label">课程封面</label>
            <div class="col-sm-10">
                <input type="file" id="updateCouPic" name="courseImage" multiple="multiple" value="上传" style="margin-bottom: 10px;">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <a href="${pageContext.request.contextPath}/course/courseList" class="btn btn-default">取消</a>
                <button type="button" class="btn btn-default" id="submit">保存</button>
            </div>
        </div>
    </form>
</div>
<script>
    $("#submit").click(function(){
        var courseId = 0;
        var courseName = $("#courseName").val();
        var courseHours = $("#courseHours").val();
        var academyId = $("#academyId").val();
        $.get(
            "${pageContext.request.contextPath}/course/addIsOk",
            {"courseName":courseName},
            function(data) {
            if(data === "true") {
                window.location.href = "${pageContext.request.contextPath}/course/add?"+"courseId="+courseId+"&courseName="+courseName+"&courseHours="+courseHours+"&academyId="+academyId;
            }else {
                alert("课程名："+courseName+"已存在！");
            }
        }
    );
    });
</script>
</body>
</html>