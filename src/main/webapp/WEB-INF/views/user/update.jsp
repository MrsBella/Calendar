<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp"%>

<body>
<nav>
    <h1>Calendar</h1>
</nav>
<div class="container bg-white main-container">
    <p>
        Edycja użytkownika
    </p>
    <form:form cssClass="d-flex flex-column justify-content-center" action="/user/form" modelAttribute="user">
        <form:hidden path="id"/>

        <form:input path="firstName" class="col-9" placeholder="imię"/> <br>
        <form:input path="lastName" class="col-9" placeholder="nazwisko"/> <br>
        <form:input path="companyName" class="col-9" placeholder="nazwa firmy"/> <br>
        <form:input path="email" class="col-9" placeholder="email"/> <br>
        <form:password path="password" class="col-9" placeholder="hasło"/> <br>
        <form:password path="" class="col-9" placeholder="powtórz hasło"/> <br>
        <button class="btn btn-lg main-button" type="submit">Zapisz zmiany</button>
    </form:form>
</div>
</body>
</html>
