<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<%--<pre>--%>
<%--    ${user}--%>
<%--    sesja:--%>
<%--    ${sessionScope}--%>
<%--</pre>--%>
<nav>
    <h1>Calendar</h1>
    <ul class="menu pt-4">
        <li class="list">
            <a href="/customer/list">
                <button class="btn btn-lg main-button">Klienci</button>
            </a>
        </li>
        <li class="list">
            <a href="/treatment/list">
                <button class="btn btn-lg main-button">Zabiegi</button>
            </a>
        </li>
        <li class="list">
            <a href="/employee/list">
                <button class="btn btn-lg main-button">Pracownicy</button>
            </a>
        </li>
    </ul>
    <a href="/user/login">
        <button class="btn btn-lg main-button mt-4 mr-3">Wyloguj</button>
    </a>
</nav>
<div class="calendar-container">
    <div id='calendar'></div>
</div>
<script>
    document.addEventListener('DOMContentLoaded', function () {
        const calendarEl = document.getElementById('calendar');
        const calendar = new FullCalendar.Calendar(calendarEl, {
            // initialView: 'dayGridMonth',
            headerToolbar: {
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth,dayGridWeek,timeGridDay'
            }
        });
        calendar.render();
    });
</script>
</body>
</html>
