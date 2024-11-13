package common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-mm-ddThh:mm:ssZ");

    public static String now() {

        return FORMATTER.format( LocalDateTime.now() );  // 07/15/2018 at 02:49 PM
    }
}
