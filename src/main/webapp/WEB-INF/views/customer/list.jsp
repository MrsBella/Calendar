<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<nav>
    <h1>Calendar</h1>
    <a href="/customer/form">
        <button class="btn btn-lg main-button mt-4">Dodaj klienta</button>
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
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Email</th>
            <th>Numer telefonu</th>
            <th>Notatka</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.email}</td>
                <td>${customer.phoneNumber}</td>
                <td>${customer.note}</td>
                <th>
                    <a class="mr-3" href="/customer/form/${customer.id}">Edytuj</a>
                    <a href="/customerTreatment/findById/${customer.id}">Pokaż</a>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
