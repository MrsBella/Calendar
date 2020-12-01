<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<nav>
    <h1>Calendar</h1>
    <a href="/customer/list">
        <button class="btn btn-lg main-button mt-4 mr-3">Powrót</button>
    </a>
</nav>
<div class="container bg-white main-container">
    <p>
        Klient
    </p>
    <div>
        <table class="table">
            <tr>
                <th>Imię</th>
                <td>${customer.firstName}</td>
            </tr>
            <tr>
                <th>Nazwisko</th>
                <td>${customer.lastName}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${customer.email}</td>
            </tr>
            <tr>
                <th>Numer telefonu</th>
                <td>${customer.phoneNumber}</td>
            </tr>
            <tr>
                <th>Notatka</th>
                <td>${customer.note}</td>
            </tr>
        </table>

        <table class="table">
            <thead>
            <th>Nazwa zabiegu</th>
            <th>Data wykonania</th>
            </thead>
            <tbody>
            <c:if test="${not empty customerTreatments}">
            <c:forEach items="${customerTreatments}" var="customerTreatment">
                <tr>
                    <td>${customerTreatment.treatment.name}</td>
                    <td>${customerTreatment.localDateTime}</td>
                </tr>
            </c:forEach>
            </c:if>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>