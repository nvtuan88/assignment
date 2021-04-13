<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/13/2021
  Time: 7:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
<c:set var="s" value="${requestScope.student}"/>

<div class="w3-container">

    <table class="w3-table w3-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Class</th>
        </tr>
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
            <td>${s.phone}</td>
            <td>${s.address}</td>
            <td>${s.classEntity.name}</td>
        </tr>
    </table>
</div>
</body>
</html>
