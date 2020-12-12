<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<nav>
    <h1>Calendar</h1>
    <a href="/product/list/${user.id}">
        <button class="btn btn-lg main-button mt-4 mr-3">Powrót</button>
    </a>
</nav>
<div class="container bg-white main-container">
    <p>
        Dodawanie produktu
    </p>
    <form:form cssClass="d-flex flex-column justify-content-center" action="/product/form" modelAttribute="product">
        <form:hidden path="id"/>

        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="name">Nazwa: </form:label>
            <form:input path="name" class="col-9" placeholder="nazwa"/> <br>
        </div>

        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="capacity">Pojemność: </form:label>
            <form:input path="capacity" class="col-9" placeholder="pojemność"/> <br>
        </div>

        <div class="form-group row">
            <form:label class="col-2 col-form-label mr-1" path="price">Cena: </form:label>
            <form:input path="price" class="col-9" placeholder="cena"/> <br>
        </div>

        <button class="btn btn-lg main-button" type="submit">Dodaj</button>
    </form:form>
</div>
</body>
</html>
