<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rejestracja</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/registrationStyle.css">
</head>
<body>
<nav>
    <h1>LOGO</h1>
</nav>
<div class="container">
    <p>
        Rejestracja
    </p>
    <form:form action="/user/form" autocomplete="off" modelAttribute="user">

        <form:input path="firstName" class="registration" placeholder="imię"/> <br>
        <form:input path="lastName" class="registration" placeholder="nazwisko"/> <br>
        <form:input path="companyName" class="registration" placeholder="nazwa firmy"/> <br>
        <form:input path="email" class="registration" placeholder="email"/> <br>
        <form:password path="password" class="registration" placeholder="hasło"/> <br>
        <form:password path="" class="registration" placeholder="powtórz hasło"/> <br>
        <button type="submit">Zarejestruj</button>
    </form:form>
</div>
</body>
</html>
