<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<nav>
    <h1>Calendar</h1>
    <button class="btn end"><a class="btn btn-lg main-button" href="/">Powrót</a></button>
</nav>
<div class="container bg-white main-container">
    <p>
        Logowanie
    </p>
    <c:if test="${not empty msg}">
        <div class="alert alert-danger" role="alert">
                ${msg}
        </div>
    </c:if>


    <form:form cssClass="d-flex flex-column justify-content-center" action="/user/login" modelAttribute="user">
        <form:hidden path="id"/>

        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="email">Email: </form:label>
            <form:input path="email" class="col-9" placeholder="email"/> <br>
        </div>
        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="password">Hasło: </form:label>
            <form:password path="password" class="col-9" placeholder="hasło"/> <br>
        </div>
        <button class="btn btn-lg main-button" type="submit">Zaloguj</button>
    </form:form>
</div>
</body>
</html>
