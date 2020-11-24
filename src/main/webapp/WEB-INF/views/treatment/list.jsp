<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Lista zabiegów</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Nazwa</th>
        <th>Cena</th>
        <th>Opis</th>
    </tr>
    <c:forEach items="${treatments}" var="treatment">
        <tr>
            <td>${treatment.id}</td>
            <td>${treatment.name}</td>
            <td>${treatment.price}</td>
            <td>${treatment.description}</td>
            <td>
                <a href="/treatment/form/${treatment.id}">Edytuj</a>
            </td>
            <th>
                <a href="/treatment/confirm/${treatment.id}">Usuń</a>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
