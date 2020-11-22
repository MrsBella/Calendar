<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp"%>

<body>
<nav>
    <h1>Calendar</h1>
</nav>
<div class="container bg-white">
    <p>
        Rejestracja
    </p>
    <form:form cssClass="d-flex flex-column justify-content-center" action="/user/form" autocomplete="false" modelAttribute="user">

        <form:input path="firstName" class="registration" placeholder="imię"/> <br>
        <form:input path="lastName" class="registration" placeholder="nazwisko"/> <br>
        <form:input path="companyName" class="registration" placeholder="nazwa firmy"/> <br>
        <form:input path="email" class="registration" placeholder="email"/> <br>
        <form:password path="password" class="registration" placeholder="hasło"/> <br>
        <form:password path="" class="registration" placeholder="powtórz hasło"/> <br>
        <button class="btn btn-lg main-button" type="submit">Zarejestruj</button>
    </form:form>
</div>
</body>
</html>
