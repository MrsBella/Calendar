package pl.coderslab.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.CustomerTreatment;
import pl.coderslab.repository.CustomerTreatmentRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ApiController {

    private final CustomerTreatmentRepository customerTreatmentRepository;

    public ApiController(CustomerTreatmentRepository customerTreatmentRepository) {
        this.customerTreatmentRepository = customerTreatmentRepository;
    }

    @GetMapping("/api/calendar")
 //   @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Map<String, String>> hello(@RequestParam String start, @RequestParam String end) {

        DateTimeFormatter parser = ISODateTimeFormat.dateTimeNoMillis();
        DateTime dateStart = parser.parseDateTime(start);
        LocalDateTime localDateTimeStart = LocalDateTime.of(dateStart.getYear(), dateStart.getMonthOfYear(),
                dateStart.getDayOfMonth(), dateStart.getHourOfDay(), dateStart.getMinuteOfHour(),
                dateStart.getSecondOfMinute());

        DateTime dateEnd = parser.parseDateTime(end);
        LocalDateTime localDateTimeEnd = LocalDateTime.of(dateEnd.getYear(), dateEnd.getMonthOfYear(),
                dateEnd.getDayOfMonth(), dateEnd.getHourOfDay(), dateEnd.getMinuteOfHour(), dateEnd.getSecondOfMinute());

        List<CustomerTreatment> customerTreatments = customerTreatmentRepository.findAllByDate(localDateTimeStart,
                localDateTimeEnd);

        List<Map<String, String>> mapList = new ArrayList<>();

        for (int i = 0; i < customerTreatments.size(); i++) {
            LocalDateTime plusMinutes = customerTreatments.get(i).getLocalDateTime().plusMinutes(30);
            String startToMap = customerTreatments.get(i).getLocalDateTime().toString();
            String endToMap = plusMinutes.toString();
            Map<String, String> map = new HashMap<>();
            map.put("event", customerTreatments.get(i).getTreatment().getName());
            map.put("start", startToMap);
            map.put("end", endToMap);
            mapList.add(map);
        }
//        return "{'aa':'bb'}";
//        return customerTreatments.toString();

        return mapList;
    }
}
