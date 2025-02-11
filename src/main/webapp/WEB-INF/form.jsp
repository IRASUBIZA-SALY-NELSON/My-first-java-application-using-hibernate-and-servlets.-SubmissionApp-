<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Student Registration</title>
    <style>
        table,tr,td, th{
            border:1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<h2>${message}</h2>
<form action="registration" method="POST">
    <label> FirstName</label><input type="text" name="fname"><br>
    <label> LastName</label><input type="text" name="lname"><br>
    <label> Email</label><input type="text" name="email"><br>
    <input type="submit" value="Register">
</form>
<table>
    <tr><th>ID</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
        <th>Age</th>
        <th>Birthdate</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td><c:out value="${student.id}"/></td>
            <td><c:out value="${student.firstName}"/></td>
            <td><c:out value="${student.lastName}"/></td>
            <td><c:out value="${student.email}"/></td>
            <td><c:out value="${student.age}"/></td>
            <td><c:out value="${student.birthDate}"/></td>
        </tr>

    </c:forEach>

</table>
</body>
</html>