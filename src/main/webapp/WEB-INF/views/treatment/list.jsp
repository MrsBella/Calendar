<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<nav>
    <h1>Calendar</h1>
    <a href="/treatment/form">
        <button class="btn btn-lg main-button mt-4">Dodaj zabieg</button>
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
            <th>Cena</th>
            <th>Opis</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${treatments}" var="treatment">
            <tr>
                <td>${treatment.id}</td>
                <td>${treatment.name}</td>
                <td>${treatment.price}</td>
                <td>${treatment.description}</td>
                <th>
                    <a class="mr-3" href="/treatment/form/${treatment.id}">Edytuj</a>
<%--                    <a href="/treatment/confirm/${treatment.id}">Usuń</a>--%>
                </th>
<%--                <th>--%>
<%--                    <a href="/treatment/confirm/${treatment.id}">Usuń</a>--%>
<%--                </th>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
