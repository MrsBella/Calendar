<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp"%>

<body>
<nav>
    <h1>Calendar</h1>
</nav>
<div class="container bg-white">
    <p>
        Dodawanie pracownika
    </p>
    <form:form cssClass="d-flex flex-column justify-content-center" action="/employee/form" modelAttribute="employee">
        <form:hidden path="id"/>

        <form:input path="firstName" class="registration" placeholder="imię"/> <br>
        <form:input path="lastName" class="registration" placeholder="nazwisko"/> <br>

        <button class="btn btn-lg main-button" type="submit">Dodaj</button>
    </form:form>
</div>
</body>
</html>
