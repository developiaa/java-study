package study.developia.java.모던자바인액션.ch12;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class DateTimeTest {
    @Test
    void test1() {
        LocalDate date = LocalDate.of(2024, 3, 18);
        boolean leapYear = date.isLeapYear(); // 윤년인지 확인
        int lengthOfMonth = date.lengthOfMonth();
        assertTrue(leapYear);
        assertEquals(lengthOfMonth, 31);
    }

    @Test
    void test2() {
        LocalDate date = LocalDate.of(2024, 3, 18);
        int y = date.get(ChronoField.YEAR);
        int y2 = date.getYear();
        int m = date.get(ChronoField.MONTH_OF_YEAR);
        int m2 = date.getMonth().getValue();
        int d = date.get(ChronoField.DAY_OF_MONTH);
        int d2 = date.getDayOfMonth();

        assertEquals(y, 2024);
        assertEquals(y, y2);
        assertEquals(m, 3);
        assertEquals(m, m2);
        assertEquals(d, 18);
        assertEquals(d, d2);
    }

    @Test
    void test3() {
        LocalTime time = LocalTime.of(13, 45, 20); // 13:45:20
        int hour = time.getHour(); // 13
        int minute = time.getMinute(); // 45
        int second = time.getSecond(); // 20

        assertEquals(hour, 13);
        assertEquals(minute, 45);
        assertEquals(second, 20);
    }

    @Test
    void test4() {
        LocalDateTime dt1 = LocalDateTime.of(2024, Month.MARCH, 18, 13, 45, 20); // 2014-03-18T13:45
        LocalDate localDate = dt1.toLocalDate();
        LocalTime localTime = dt1.toLocalTime();
        assertEquals(localDate, LocalDate.of(2024, Month.MARCH, 18));
        assertEquals(localTime, LocalTime.of(13, 45, 20));
    }

    @Test
    void test5() {
        Instant instant = Instant.ofEpochSecond(3);
        Instant instant1 = Instant.ofEpochSecond(3, 0);
        Instant instant2 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant instant3 = Instant.ofEpochSecond(4, -1_000_000_000);
        assertEquals(instant, instant1);
        assertEquals(instant1, instant2);
        assertEquals(instant2, instant3);
    }

    @Test
    void test6() {
        LocalTime time = LocalTime.of(13, 45, 20); // 13:45:20
        Instant instant = Instant.ofEpochSecond(44 * 365 * 86400);
        Instant now = Instant.now();
        Duration d1 = Duration.between(LocalTime.of(13, 45, 10), time);
        Duration d2 = Duration.between(instant, now);
        System.out.println(d1.getSeconds());
        System.out.println(d2.getSeconds());

        assertEquals(d1.getSeconds(), 10);
    }

    @Test
    void test7() {
        Duration duration = Duration.ofMinutes(3);
        Duration duration1 = Duration.of(3, ChronoUnit.MINUTES);
        assertEquals(duration, duration1);
    }

    @Test
    void test8() {
        Period period = Period.ofDays(21);
        Period period1 = Period.ofWeeks(3);
        assertEquals(period, period1);
    }

    @Test
    void test9() {
        LocalDate localDate = LocalDate.of(2024, 5, 10);
        LocalDate localDate1 = localDate.withYear(2025);
        LocalDate localDate2 = localDate.withMonth(7);
        LocalDate localDate3 = localDate.with(ChronoField.MONTH_OF_YEAR, 2);

        assertEquals(localDate.plusYears(1), localDate1);
        assertEquals(localDate.plusMonths(2), localDate2);
        assertEquals(localDate.minusMonths(3), localDate3);
    }




}
