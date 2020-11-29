<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        Czy na pewno chcesz usunać zabieg?
    </p>
    <a href="/treatment/delete/${id}">
        <button class="btn btn-lg main-button mt-4 mr-3">Potwierdź</button>
    </a><br/>
    <a href="/treatment/list">
        <button class="btn btn-lg main-button mt-4 mr-3">Anuluj</button>

    </a>
</div>
</body>
</html>