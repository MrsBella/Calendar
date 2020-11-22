<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp"%>

<body>
<nav>
    <h1>Calendar</h1>
</nav>
<div class="container bg-white">
    <p>
        Dodawanie kienta
    </p>
    <form:form cssClass="d-flex flex-column justify-content-center" action="/customer/form" modelAttribute="customer">
        <form:hidden path="id"/>

        <form:input path="firstName" class="registration" placeholder="imię"/> <br>
        <form:input path="lastName" class="registration" placeholder="nazwisko"/> <br>
        <form:input path="email" class="registration" placeholder="email"/> <br>
        <form:input path="phoneNumber" class="registration" placeholder="numer telefonu"/> <br>
        <form:textarea path="note" class="registration" placeholder="notatka"/> <br>
        <button class="btn btn-lg main-button" type="submit">Dodaj</button>
    </form:form>
</div>
</body>
</html>
