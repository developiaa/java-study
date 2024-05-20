package study.developia.java.모던자바인액션.ch12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

public class TemporalAdjustersTest {
    @Test
    void test1() {
        LocalDate localDate = LocalDate.of(2024, 5, 12);
        LocalDate localDate2 = LocalDate.of(2024, 5, 13);
        LocalDate with = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate with2 = localDate2.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate with3 = localDate.with(TemporalAdjusters.firstDayOfMonth());


        assertEquals(with.getDayOfMonth(), 12);
        assertEquals(with2.getDayOfMonth(), 19);
        assertEquals(with3.getDayOfWeek(), DayOfWeek.WEDNESDAY);
    }


    static class NextWorkingDay implements TemporalAdjuster {
        @Override
        public Temporal adjustInto(Temporal temporal) {
            DayOfWeek dow = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            else if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        }
    }

    @Test
    void test2() {
        LocalDate localDate = LocalDate.parse("2024-05-13");
        LocalDate localDate2 = LocalDate.parse("2024-05-13", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("localDate = " + localDate);
        System.out.println("localDate2 = " + localDate2);
        assertEquals(localDate,localDate2);
    }

    @Test
    void test3() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate localDate = LocalDate.of(2024, 5, 20);
        String format = localDate.format(dateTimeFormatter);
        System.out.println("format = " + format);
    }

    @Test
    void test4() {
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        System.out.println("zoneId = " + zoneId);
        assertEquals(zoneId.toString(), "Asia/Seoul");
    }

    @Test
    void test5() {
        LocalDate localDate = LocalDate.of(2024, 5, 20);
        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        LocalDateTime localDatetime = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = localDatetime.atZone(ZoneId.systemDefault());
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.systemDefault());

        assertEquals(zonedDateTime.getZone(), zonedDateTime1.getZone());
        assertEquals(zonedDateTime1.getZone(), zonedDateTime2.getZone());
    }

    @Test
    void test6() {
        Instant instant = Instant.now();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
}
