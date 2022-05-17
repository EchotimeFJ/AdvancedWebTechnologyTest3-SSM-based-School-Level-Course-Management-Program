<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2022/4/21
  Time: 20:58
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
    <script src="https://unpkg.com/vue@next"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <style>
        .panel-body {
            height: 1000px;
            width: 1000px;
            margin: auto;
        }
        .input-group {
            width: 300px;
            padding-left: 10px;
            margin-left: 254px;
            margin-bottom: 10px;
        }
        .btn {
            font-size: 10px;
        }
        .inAddInfo {
            width: 490px;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<div class="container mt-3" id="app">
    <div>
        <a href="${pageContext.request.contextPath}/course/toAdd" class="btn btn-success">添加课程</a>
    </div>
    <table class="table" id="courseList">
        <thead>
        <tr>
            <th>课程封面</th>
            <th>课程名称</th>
            <th>课时</th>
            <th>所属学院</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody >
        <tr v-for="course in courseList" style="height: 200px">
            <td style="vertical-align: middle"> {{course.courseImage}}</td>
            <td style="vertical-align: middle"> {{course.courseName}}</td>
            <td style="vertical-align: middle"> {{course.courseHours}}</td>
            <td style="vertical-align: middle"> {{course.academyName}}</td>
            <td style="vertical-align: middle">
                <a :href="'${pageContext.request.contextPath}/course/toUpdate?courseId='+course.courseId" class="btn btn-warning">修改</a>
                <a :href="update(course.courseId)" class="btn btn-danger">删除</a>

            </td>
        </tr>
        </tbody>
    </table>
</div>
<script>
    const App = {
        data() {
            return {
                length: null,
                courseList : null
            }
        },
        mounted() {
            axios.get("${pageContext.request.contextPath}/course/list")
                .then(response => {
                    this.length = response.data.name;
                    this.courseList = response.data.value;
                }).catch(function (error) {
            });
        },
        methods: {
            modify(courseId) {
                return "${pageContext.request.contextPath}/course/toUpdate?courseId=" +courseId;
            },
            update(courseId) {
                return "javascript:if(confirm('确定删除吗?'))location='"+"${pageContext.request.contextPath}/course/delete?courseId=" +courseId+"'";
            },
        }
    };
    const app = Vue.createApp(App);
    app.mount("#app");
</script>
</body>
</html>