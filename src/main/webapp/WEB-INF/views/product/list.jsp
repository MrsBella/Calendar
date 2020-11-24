<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Lista produktów</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Nazwa</th>
        <th>Pojemność</th>
        <th>Cena</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.capacity}</td>
            <td>${product.price}</td>
            <td>
                <a href="/product/form/${product.id}">Edytuj</a>
            </td>
            <th>
                <a href="/product/confirm/${product.id}">Usuń</a>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
