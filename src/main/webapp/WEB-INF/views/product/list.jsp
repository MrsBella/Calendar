<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<nav>
    <h1>Calendar</h1>
    <a href="/product/form">
        <button class="btn btn-lg main-button mt-4">Dodaj produkt</button>
    </a>
    <a href="/user/home">
        <button class="btn btn-lg main-button mt-4 mr-3">Powrót</button>
    </a>
</nav>
<div class="container bg-white">
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Nazwa</th>
        <th>Pojemność</th>
        <th>Cena</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.capacity}</td>
            <td>${product.price}</td>
            <th>
                <a href="/product/form/${product.id}">Edytuj</a>
            </th>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>
