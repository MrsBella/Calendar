<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employee</title>
</head>
<body>
Czy na pewno chcesz usunać pracownika?
<a href="/employee/delete/${id}">Potwierdź</a><br/>
<a href="/employee/list">Anuluj</a>
</body>
</html>