<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Treatment</title>
</head>
<body>
Czy na pewno chcesz usunać zabieg?
<a href="/treatment/delete/${id}">Potwierdź</a><br/>
<a href="/treatment/list">Anuluj</a>
</body>
</html>