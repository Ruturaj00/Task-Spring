<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>edit</title>
</head>
<body>
<div style="border:2px solid red; padding:4px; width:300px; height:300px;">
<form  action="update" method="post">
<pre>
<input type="hidden" name="rollno" value="${student.rollno}"/>
Name : <input type="text" name="name" value="${student.name}"/><br/>
Username : <input type="text" name="username" value="${student.username}"/><br/>
Password : <input type="password" name="password" value="${student.password}"/><br/>
</pre>

<button type="submit">update</button>
</form>
</div>
</body>
</html>