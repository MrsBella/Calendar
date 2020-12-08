package pl.coderslab.controller;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class ApiController {

    @GetMapping("/api/calendar")
    public String hello(@RequestParam String start, @RequestParam String end) {

        DateTimeFormatter parser = ISODateTimeFormat.dateTimeNoMillis();
        DateTime dateStart = parser.parseDateTime(start);
        LocalDateTime localDateTimeStart = LocalDateTime.of(dateStart.getYear(), dateStart.getMonthOfYear(),
                dateStart.getDayOfMonth(), dateStart.getHourOfDay(), dateStart.getMinuteOfHour(),
                dateStart.getSecondOfMinute());

        DateTime dateEnd = parser.parseDateTime(end);
        LocalDateTime localDateTimeEnd = LocalDateTime.of(dateEnd.getYear(), dateEnd.getMonthOfYear(),
                dateEnd.getDayOfMonth(), dateEnd.getHourOfDay(), dateEnd.getMinuteOfHour(), dateEnd.getSecondOfMinute());

        return localDateTimeStart.toString() + "\n" + localDateTimeEnd.toString();
    }
}
