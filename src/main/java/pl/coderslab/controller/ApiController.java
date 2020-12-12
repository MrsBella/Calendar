package pl.coderslab.controller;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Customer;
import pl.coderslab.entity.CustomerTreatment;
import pl.coderslab.entity.Treatment;
import pl.coderslab.entity.Visit;
import pl.coderslab.repository.CustomerRepository;
import pl.coderslab.repository.CustomerTreatmentRepository;
import pl.coderslab.repository.TreatmentRepository;
import pl.coderslab.repository.VisitRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

@RestController
public class ApiController {

    private final CustomerTreatmentRepository customerTreatmentRepository;
    public final CustomerRepository customerRepository;
    public final TreatmentRepository treatmentRepository;
    public final VisitRepository visitRepository;

    public ApiController(CustomerTreatmentRepository customerTreatmentRepository, CustomerRepository customerRepository, TreatmentRepository treatmentRepository, VisitRepository visitRepository) {
        this.customerTreatmentRepository = customerTreatmentRepository;
        this.customerRepository = customerRepository;
        this.treatmentRepository = treatmentRepository;
        this.visitRepository = visitRepository;
    }

    @GetMapping("/api/calendar")
 //   @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
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

        Visit visit = new Visit();

        visit.setCustomer(foundCustomer);
        visit.setTreatment(foundTreatment);
        visit.setStartDate(dateTime);
        visit.setEndDate(dateTime.plusMinutes(30));

        visitRepository.save(visit);

        return visit.toString();
    }
}
