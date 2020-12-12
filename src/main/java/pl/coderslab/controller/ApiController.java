package pl.coderslab.controller;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.*;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

@RestController
public class ApiController {

    public final CustomerRepository customerRepository;
    public final TreatmentRepository treatmentRepository;
    public final VisitRepository visitRepository;
    public final EmployeeRepository employeeRepository;

    public ApiController(CustomerRepository customerRepository,
                         TreatmentRepository treatmentRepository, VisitRepository visitRepository,
                         EmployeeRepository employeeRepository) {
        this.customerRepository = customerRepository;
        this.treatmentRepository = treatmentRepository;
        this.visitRepository = visitRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/api/calendar")
    public List<Map<String, String>> hello(@RequestParam String start, @RequestParam String end) {

        DateTime jodaDateStart = ISODateTimeFormat.dateTimeParser().parseDateTime(start);
        DateTime dateEnd = ISODateTimeFormat.dateTimeParser().parseDateTime(end);

        LocalDateTime localDateTimeStart = LocalDateTime.of(jodaDateStart.getYear(), jodaDateStart.getMonthOfYear(),
                jodaDateStart.getDayOfMonth(), jodaDateStart.getHourOfDay(), jodaDateStart.getMinuteOfHour(),
                jodaDateStart.getSecondOfMinute());


        LocalDateTime localDateTimeEnd = LocalDateTime.of(dateEnd.getYear(), dateEnd.getMonthOfYear(),
                dateEnd.getDayOfMonth(), dateEnd.getHourOfDay(), dateEnd.getMinuteOfHour(), dateEnd.getSecondOfMinute());

        List<Visit> visits = visitRepository.findAllByDate(localDateTimeStart,
                localDateTimeEnd);

        List<Map<String, String>> mapList = new ArrayList<>();

        for (int i = 0; i < visits.size(); i++) {
            String startToMap = visits.get(i).getStartDate().toString();
            String endToMap = visits.get(i).getEndDate().toString();
            Map<String, String> map = new HashMap<>();
            map.put("title", visits.get(i).getTreatment().getName());
            map.put("start", startToMap);
            map.put("end", endToMap);
            map.put("visitId", visits.get(i).getId().toString());
            map.put("customerId", visits.get(i).getCustomer().getId().toString());
            map.put("treatmentId", visits.get(i).getTreatment().getId().toString());
            map.put("employeeId", visits.get(i).getEmployee().getId().toString());

            if (visits.get(i).isDone()) {
                map.put("backgroundColor", "darkslategrey");
            }
            mapList.add(map);
        }

        return mapList;
    }

    @PostMapping("/api/calendar")
    @Transactional
    public String createEvent(@RequestParam String customerId, @RequestParam String employeeId,
                              @RequestParam String treatmentId, @RequestParam String date) {

        DateTime jodaDateStart = ISODateTimeFormat.dateTimeParser().parseDateTime(date);

        LocalDateTime dateTime = LocalDateTime.of(jodaDateStart.getYear(), jodaDateStart.getMonthOfYear(),
                jodaDateStart.getDayOfMonth(), jodaDateStart.getHourOfDay(), jodaDateStart.getMinuteOfHour(),
                jodaDateStart.getSecondOfMinute());

        Optional<Customer> customer = customerRepository.findById(Long.parseLong(customerId));
        Customer foundCustomer = customer.orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        Optional<Treatment> treatment = treatmentRepository.findById(Long.parseLong(treatmentId));
        Treatment foundTreatment = treatment.orElseThrow(() -> new EntityNotFoundException("Treatment not found"));

        Optional<Employee> employee = employeeRepository.findById(Long.parseLong(employeeId));
        Employee foundEmployee = employee.orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        Visit visit = new Visit();

        visit.setCustomer(foundCustomer);
        visit.setTreatment(foundTreatment);
        visit.setEmployee(foundEmployee);
        visit.setStartDate(dateTime);
        visit.setEndDate(dateTime.plusMinutes(30));

        visitRepository.save(visit);

        return visit.toString();
    }

    @DeleteMapping("/api/calendar/{id}")
    public @ResponseBody
    void deleteEvent(@PathVariable Long id) {
        visitRepository.deleteById(id);
    }

    @PostMapping("/api/calendar/{id}")
    @Transactional
    public void putEvent(@PathVariable Long id, @RequestParam String customerId, @RequestParam String employeeId,
                         @RequestParam String treatmentId, @RequestParam String date) {

        Optional<Visit> visit = visitRepository.findById(id);
        Visit foundVisit = visit.orElseThrow(() -> new EntityNotFoundException("Visit not found"));

        Optional<Customer> customer = customerRepository.findById(Long.parseLong(customerId));
        Customer foundCustomer = customer.orElseThrow(() -> new EntityNotFoundException("Customer not found"));

        Optional<Treatment> treatment = treatmentRepository.findById(Long.parseLong(treatmentId));
        Treatment foundTreatment = treatment.orElseThrow(() -> new EntityNotFoundException("Treatment not found"));

        Optional<Employee> employee = employeeRepository.findById(Long.parseLong(employeeId));
        Employee foundEmployee = employee.orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        foundVisit.setCustomer(foundCustomer);
        foundVisit.setTreatment(foundTreatment);
        foundVisit.setEmployee(foundEmployee);

        visitRepository.save(foundVisit);
    }

    @PutMapping("/api/calendar/{id}/done")
    public @ResponseBody
    void setEventDone(@PathVariable Long id) {
        Optional<Visit> visit = visitRepository.findById(id);
        Visit foundVisit = visit.orElseThrow(() -> new EntityNotFoundException("Visit not found"));

        foundVisit.setDone(true);
        visitRepository.save(foundVisit);
    }
}
