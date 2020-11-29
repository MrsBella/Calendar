<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        Dodawanie kienta
    </p>
    <form:form cssClass="d-flex flex-column justify-content-center" action="/customer/form" modelAttribute="customer">
        <form:hidden path="id"/>

    <div class="form-group row">
        <form:label class="col-2 col-form-label mr-1" path="firstName">Imię: </form:label>
        <form:input path="firstName" class="col-9" placeholder="imię"/> <br>
    </div>

    <div class="form-group row">
        <form:label class="col-2 col-form-label mr-1" path="lastName">Nazwisko: </form:label>
        <form:input path="lastName" class="col-9" placeholder="nazwisko"/> <br>
    </div>

    <div class="form-group row">
        <form:label class="col-2 col-form-label mr-1" path="email">Email: </form:label>
        <form:input path="email" class="col-9" placeholder="email"/> <br>
    </div>

    <div class="form-group row">
        <form:label class="col-2 col-form-label mr-1" path="phoneNumber">Numer telefonu: </form:label>
        <form:input path="phoneNumber" class="col-9" placeholder="numer telefonu"/> <br>
    </div>

    <div class="form-group row">
        <form:label class="col-2 col-form-label mr-1" path="note">Notatka: </form:label>
        <form:textarea path="note" class="col-9" placeholder="notatka"/> <br>
    </div>

        <button class="btn btn-lg main-button" type="submit">Dodaj</button>
        </form:form>
    </div>
</body>
</html>
