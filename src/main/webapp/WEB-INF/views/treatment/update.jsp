<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<nav>
    <h1>Calendar</h1>
    <a href="/treatment/list">
        <button class="btn btn-lg main-button mt-4 mr-3">Powrót</button>
    </a>
</nav>
<div class="container bg-white main-container">
    <p>
        Edycja zabiegu
    </p>
    <form:form cssClass="d-flex flex-column justify-content-center" action="/treatment/form" modelAttribute="treatment">
        <form:hidden path="id"/>

        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="name">Nazwa: </form:label>
            <form:input path="name" class="col-9" placeholder="nazwa"/> <br>
        </div>

        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="price">Cena: </form:label>
            <form:input path="price" class="col-9" placeholder="cena"/> <br>
        </div>

        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="description">Opis: </form:label>
            <form:input path="description" class="col-9" placeholder="opis"/> <br>
        </div>

        <button class="btn btn-lg main-button" type="submit">Zapisz zmiany</button>
    </form:form>
</div>
</body>
</html>
