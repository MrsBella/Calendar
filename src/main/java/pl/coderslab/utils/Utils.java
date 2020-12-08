package pl.coderslab.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.time.LocalDateTime;

public class Utils {

    public LocalDateTime stringToLocalDateTime(String string) {

        DateTimeFormatter parser2 = ISODateTimeFormat.dateTimeNoMillis();
        DateTime date = parser2.parseDateTime(string);
        LocalDateTime localDateTime = LocalDateTime.of(date.getYear(), date.getMonthOfYear(), date.getDayOfMonth(),
                date.getHourOfDay(), date.getMinuteOfHour(), date.getSecondOfMinute());

        return localDateTime;
    }
}
