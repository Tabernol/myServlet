<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

Hello it is me!
<h2>All Students</h2><br/>

<c:forEach var="student" items="${requestScope.students}">
    <ul>

        <li>name: <c:out value="${student.nameStudent}"/></li>

        <li>id: <c:out value="${student.idStudent}"/></li>
    </ul>
    <hr/>

</c:forEach>

<h2>Create new student</h2><br/>
<form method="post" action="">

    <label><input type="text" name="name"></label>name<br>

    <label><input type="number" name="id"></label>id<br>

    <input type="submit" value="Ok" name="Ok"><br>
</form>

</body>
</html>