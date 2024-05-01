package support.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    private DateUtil(){}

    public static String convertDateToStringFormatNumbersMonthDayYear(LocalDate date){
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("dd");
        String day = date.format(dayFormatter);

        DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");
        String month = date.format(monthFormatter);

        return String.format("%s/%s/%s", month, day, date.getYear());
    }
}
