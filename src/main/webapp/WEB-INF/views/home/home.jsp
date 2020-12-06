<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/head.jsp" %>

<body>
<pre>
    ${user}
    ${user.id}
    sesja:
    ${sessionScope}
</pre>
<nav>
    <h1>Calendar</h1>
    <ul class="menu pt-4">
        <li class="list">
            <a href="/customer/list/${user.id}">
                <button class="btn btn-lg main-button">Klienci</button>
            </a>
        </li>
        <li class="list">
            <a href="/treatment/list/${user.id}">
                <button class="btn btn-lg main-button">Zabiegi</button>
            </a>
        </li>
        <li class="list">
            <a href="/product/list/${user.id}">
                <button class="btn btn-lg main-button">Produkty</button>
            </a>
        </li>
        <li class="list">
            <a href="/employee/list/${user.id}">
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
            headerToolbar: {
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth,timeGridWeek,timeGridDay'
            },
            initialView: 'timeGridWeek',
            nowIndicator: true,
            now: Date.now(),
            selectable: true,
            businessHours: [ // specify an array instead
                {
                    daysOfWeek: [ 1, 2, 3, 4, 5 ], // Monday, Tuesday, Wednesday
                    startTime: '08:00', // 8am
                    endTime: '21:00' // 6pm
                },
                {
                    daysOfWeek: [ 6 ], // Thursday, Friday
                    startTime: '9:00', // 10am
                    endTime: '15:00' // 4pm
                }
            ],
            slotDuration: '00:15:00',
            firstDay: 1,
            // dateClick: function(info) {
            //     alert('Clicked on: ' + info.dateStr);
            //     alert('Coordinates: ' + info.jsEvent.pageX + ',' + info.jsEvent.pageY);
            //     alert('Current view: ' + info.view.type);
            //     // change the day's background color just for fun
            //     info.dayEl.style.backgroundColor = 'blue';
            // }
        });
        calendar.render();
    });
</script>
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
    Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Wizyta</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form:form action="user/home" modelAttribute="customerTreatment">

                </form:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
