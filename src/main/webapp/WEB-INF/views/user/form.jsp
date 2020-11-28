<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form:errors path="firstName" cssClass="error"/>

        </div>
        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="lastName">Nazwisko: </form:label>
            <form:input path="lastName" class="registration col-9" placeholder="nazwisko"/> <br>
            <form:errors path="lastName" cssClass="error"/>

        </div>
        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="companyName">Nazwa firmy: </form:label>
            <form:input path="companyName" class="registration col-9" placeholder="nazwa firmy"/> <br>
            <form:errors path="companyName" cssClass="error"/>
        </div>

        <c:if test="${not empty msg}">
            <div class="alert alert-danger" role="alert">
                ${msg}
            </div>
        </c:if>

        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="email">Email: </form:label>
            <form:input path="email" class="registration col-9" placeholder="email"/> <br>
            <form:errors path="email" cssClass="error"/>

        </div>
        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="password">Hasło: </form:label>
            <form:password path="password" class="registration col-9" placeholder="hasło"/> <br>
            <form:errors path="password" cssClass="error"/>
        </div>

        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="">Powtórz hasło: </form:label>
            <form:password path="repeatPassword" class="registration col-9" placeholder="powtórz hasło"/> <br>
            <form:errors path="repeatPassword" cssClass="error"/>

        </div>
        <button class="btn btn-lg main-button" type="submit">Zarejestruj</button>
    </form:form>
</div>
</body>
</html>
