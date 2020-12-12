<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    daysOfWeek: [1, 2, 3, 4, 5], // Monday, Tuesday, Wednesday
                    startTime: '08:00', // 8am
                    endTime: '21:00' // 6pm
                },
                {
                    daysOfWeek: [6], // Thursday, Friday
                    startTime: '9:00', // 10am
                    endTime: '15:00' // 4pm
                }
            ],
            slotDuration: '00:15:00',
            firstDay: 1,
            dateClick: function (info) {
                $('#end').hide()
                $('#delete').hide()
                showModal("new")
                const clickedDate = info.date.getDate() + "-" + (info.date.getMonth() + 1) + "-" + info.date.getFullYear()
                    + " " + info.date.getHours() + ":" + info.date.getMinutes();
                $('#date').text(clickedDate)
                $('#dateHidden').val(info.dateStr)

                $('#save-new').click(function () {
                    const data = $('#modalForm').serializeArray();
                    console.log(data)
                    $.ajax({
                        type: "POST",
                        url: "/api/calendar",
                        data: data,
                        success: function (data) {
                            $('#visitModal-new').modal('hide')
                            calendar.refetchEvents();
                        },
                        error: function (error) {
                            console.log(error)
                        }
                    });
                })
            },
            eventClick: function (event) {

                const eventObject = event.event;

                const visitId = eventObject.extendedProps.visitId;

                console.log(eventObject)
                $('#date').text(eventObject.start.toLocaleString())
                $('#dateHidden').val(eventObject.start)
                $('#customerId').val(parseInt(eventObject.extendedProps.customerId))
                $('#employeeId').val(parseInt(eventObject.extendedProps.employeeId))
                $('#treatmentId').val(parseInt(eventObject.extendedProps.treatmentId))
                // $('#visitModal').modal('show')
                showModal(visitId)
                $('#end-' + visitId).show()
                $('#delete-' + visitId).show()

                $('#save-' + visitId).click(function () {
                    const data = $('#modalForm').serializeArray();
                    console.log(data)
                    $.ajax({
                        type: "POST",
                        url: "/api/calendar/" + visitId,
                        data: data,
                        success: function (data) {
                            $('#visitModal-' + visitId).modal('hide')
                            calendar.refetchEvents();
                        },
                        error: function (error) {
                            console.log(error)
                        }
                    });
                })

                $('#delete-' + visitId).click(function () {
                    $.ajax({
                        type: "DELETE",
                        url: "/api/calendar/" + visitId,
                        success: function (data) {
                            $('#visitModal-' + visitId).modal('hide')
                            calendar.refetchEvents();
                        },
                        error: function (error) {
                            console.log(error)
                        }
                    })
                })

                $('#end-' + visitId).click(function () {
                    $.ajax({
                        type: "PUT",
                        url: "/api/calendar/" + visitId + "/done",
                        success: function (data) {
                            $('#visitModal-' + visitId).modal('hide')
                            calendar.refetchEvents();
                        },
                        error: function (error) {
                            console.log(error)
                        }
                    })
                })
            },
            eventSources: [
                {
                    url: '/api/calendar',
                    method: 'GET',
                    failure: function () {
                        alert('Bład pobierania danych');
                    },
                }
            ]
        });
        calendar.render();
    });

    function showModal(id) {
        const modal = $(`
        <div class="modal fade" id="visitModal-` + id + `" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Wizyta</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form:form id="modalForm" action="user/home" modelAttribute="user">
                    <div class="form-group">
                        <input name="date" type="text" id="dateHidden" value="" hidden>
                        <span id="date"></span>
                        <br>
                        <form:label path="customers">Klient: </form:label>
                        <select class="form-control" id="customerId" name="customerId">
                            <c:forEach items="${user.customers}" var="customer">
                                <option value="${customer.id}">${customer.fullName}</option>
                            </c:forEach>
                        </select>
                        <form:label path="employees">Pracownik: </form:label>
                        <select class="form-control" id="employeeId" name="employeeId">
                            <c:forEach items="${user.employees}" var="employee">
                                <option value="${employee.id}">${employee.fullName}</option>
                            </c:forEach>
                        </select>
                        <form:label path="treatments">Zabieg: </form:label>
                        <select class="form-control" id="treatmentId" name="treatmentId">
                            <c:forEach items="${user.treatments}" var="treatment">
                                <option value="${treatment.id}">${treatment.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form:form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Wyjdź</button>
                <button type="button" class="btn btn-primary" id="save-` + id + `">Zapisz</button>
                <button type="button" class="btn btn-primary" id="delete-` + id + `" style="display:none">Anuluj wizytę</button>
                <button type="button" class="btn btn-primary" id="end-` + id + `" style="display:none">Zakończ</button>
            </div>
        </div>
    </div>
</div>
`)
        $('#calendar').after(modal)
        modal.modal('show');
    }
</script>
</body>
</html>
