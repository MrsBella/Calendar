<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<nav>
    <h1>Calendar</h1>
    <a href="/employee/form">
        <button class="btn btn-lg main-button mt-4">Dodaj pracownika</button>
    </a>
    <a href="/user/home">
        <button class="btn btn-lg main-button mt-4 mr-3">Powrót</button>
    </a>
</nav>
<div class="container bg-white">
    <table class="table">
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
                <th>
                    <a href="/employee/form/${employee.id}">Edytuj</a>
                </th>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
