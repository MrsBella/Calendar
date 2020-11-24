<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Produkt</title>
</head>
<body>
Czy na pewno chcesz usunać produkt?
<a href="/product/delete/${id}">Potwierdź</a><br/>
<a href="/product/list">Anuluj</a>
</body>
</html>