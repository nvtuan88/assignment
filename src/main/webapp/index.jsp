<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/13/2021
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="w3-container">

    <table class="w3-table w3-striped">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Class</th>
            <th>Details</th>
        </tr>
        <c:forEach var="s" items="${requestScope.students}">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.age}</td>
                <td>${s.phone}</td>
                <td>${s.address}</td>
                <td>${s.classEntity.name}</td>
                <td>
                    <c:url var="url" value="student">
                        <c:param name="id" value="${s.id}"/>
                    </c:url>
                    <a href="${url}">Detail</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
</body>
</html>
