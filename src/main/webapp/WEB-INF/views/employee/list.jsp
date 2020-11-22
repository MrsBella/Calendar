<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Lista pracowników</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Imię</th>
        <th>Nazwisko</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>
                <a href="/employee/form/${employee.id}">Edytuj</a>
            </td>
            <th>
                <a href="/employee/confirm/${employee.id}">Usuń</a>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
