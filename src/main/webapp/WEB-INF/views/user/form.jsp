<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<nav>
    <h1>Calendar</h1>
    <button class="btn end"><a class="btn btn-lg main-button" href="/">Powrót</a></button>
</nav>
<div class="container bg-white">
    <p>
        Rejestracja
    </p>
    <form:form cssClass="d-flex flex-column justify-content-center" action="/user/form"
               modelAttribute="user">
        <form:hidden path="id"/>

        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="firstName">Imię: </form:label>
            <form:input path="firstName" class="registration col-9" placeholder="imię"/> <br>
        </div>
        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="lastName">Nazwisko: </form:label>
            <form:input path="lastName" class="registration col-9" placeholder="nazwisko"/> <br>
        </div>
        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="companyName">Nazwa firmy: </form:label>
            <form:input path="companyName" class="registration col-9" placeholder="nazwa firmy"/> <br>
        </div>
        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="email">Email: </form:label>
            <form:input path="email" class="registration col-9" placeholder="email"/> <br>
        </div>
        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="password">Hasło: </form:label>
            <form:password path="password" class="registration col-9" placeholder="hasło"/> <br>
        </div>
        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="">Powtórz hasło: </form:label>
            <form:password path="" class="registration col-9" placeholder="powtórz hasło"/> <br>
        </div>
        <button class="btn btn-lg main-button" type="submit">Zarejestruj</button>
    </form:form>
</div>
</body>
</html>
