<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="ISO-8859-1">
    <title>Success</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>Roll No</th>
            <th>Name</th>
            <th>Username</th>
            <th>Password</th>
            <th>Action</th>
        </tr>
        <c:forEach var="data" items="${data}">
            <tr>
                <td>${data.rollno}</td>
                <td>${data.name}</td>
                <td>${data.username}</td>
                <td>${data.password}</td>
                <td><a href="delete?name=${data.name}">Delete</a>||<a href="edit?rollno=${data.rollno}">Edit</a></td> <!-- Assuming data has an 'id' property -->
            </tr>
        </c:forEach>
    </table>
    <a href="paging?pageNo=0">Next</a> || <a href="paging?pageNo=0">1</a> ||
    <a href="paging?pageNo=1">2</a> || <a href="paging?pageNo=0">Prev</a> 
  
</body>
</html>
