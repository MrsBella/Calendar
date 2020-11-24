<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp"%>

<body>
<nav>
    <h1>Calendar</h1>
</nav>
<div class="container bg-white">
    <p>
        Dodawanie produktu
    </p>
    <form:form cssClass="d-flex flex-column justify-content-center" action="/product/form" modelAttribute="product">
        <form:hidden path="id"/>

        <form:input path="name" class="registration" placeholder="nazwa"/> <br>
        <form:input path="capacity" class="registration" placeholder="pojemność"/> <br>
        <form:input path="price" class="registration" placeholder="cena"/> <br>
        <button class="btn btn-lg main-button" type="submit">Dodaj</button>
    </form:form>
</div>
</body>
</html>
