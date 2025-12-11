package se.lexicon;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeAPI {

    public static void timeExercises() {
        EX1();
        EX2();
        EX3();
        EX4();
        EX5();
        EX6();
        EX7();
        EX8();
        EX9();
        EX10();
        EX11();
        EX12();
        EX13();
        EX14();
        EX15();
        EX16();
    }

    private static void EX1() {
        System.out.println("\nEXERCISE 1");
        LocalDate ex1today = LocalDate.now();
        System.out.println(ex1today);
    }

    private static void EX2() {
        System.out.println("\nEXERCISE 2");
        LocalDate ex1today = LocalDate.now();
        DateTimeFormatter ex2today = DateTimeFormatter.ofPattern("EEEE dd LLLL");
        String formattedDate = ex1today.format(ex2today);
        System.out.println(formattedDate);
    }

    private static void EX3() {
        System.out.println("\nEXERCISE 3");
        LocalDate ex1today = LocalDate.now();
        int dayOfWeek = ex1today.getDayOfWeek().getValue();
        int daysSinceMonday = (dayOfWeek + 6) % 7;
        System.out.println("Days since monday: " + daysSinceMonday);
        LocalDate mondayDate = ex1today.minusDays(daysSinceMonday);
        System.out.println("Last monday date: " + mondayDate);

        for (int i = 0; i < 7; i++) {
            LocalDate currentDate = mondayDate.plusDays(i);
            System.out.println(currentDate);
        }
    }

    private static void EX4() {
        System.out.println("\nEXERCISE 4");
        LocalDate ex1today = LocalDate.now();
        LocalDate ex4 = LocalDate.parse(ex1today.toString());
        System.out.println(ex4);
    }

    private static void EX5() {
        System.out.println("\nEXERCISE 5");
        LocalDate bDay = LocalDate.parse("1992-09-19");
        System.out.println("1992-09-19 was a " + bDay.getDayOfWeek());
    }

    private static void EX6() {
        System.out.println("\nEXERCISE 6");
        LocalDate ex1today = LocalDate.now();
        LocalDate ex6 = ex1today.plusYears(10).minusMonths(10);
        Month ex61 = ex6.getMonth();
        System.out.println("Month after 10 years and minus 10 months: " + ex61);
    }

    private static void EX7() {
        System.out.println("\nEXERCISE 7");
        LocalDate ex1today = LocalDate.now();
        LocalDate bDay = LocalDate.parse("1992-09-19");
        LocalDate ex6 = ex1today.plusYears(10).minusMonths(10);
        Period ex7 = Period.between(bDay, ex6);
        System.out.println("Period between bDay and ex6: " + ex7.getYears() + " years, " + ex7.getMonths()
                + " months, " + ex7.getDays() + " days.");
    }

    private static void EX8() {
        System.out.println("\nEXERCISE 8");
        LocalDate ex1today = LocalDate.now();
        Period ex8 = Period.of(4, 7, 29);
        LocalDate ex81 = ex1today.plus(ex8);
        System.out.println("Period of 4 years, 7 months and 29 days: " + ex81);
    }

    private static void EX9() {
        System.out.println("\nEXERCISE 9");
        LocalTime ex9time = LocalTime.now();
        System.out.println("time: " + ex9time);
    }

    private static void EX10() {
        System.out.println("\nEXERCISE 10");
        LocalTime ex9time = LocalTime.now();
        LocalTime ex10 = LocalTime.ofNanoOfDay(ex9time.getNano());
        DateTimeFormatter ex10format = DateTimeFormatter.ofPattern("nn");
        String formattedMinutes = ex10.format(ex10format);
        System.out.println("nano: " + formattedMinutes);
    }

    private static void EX11() {
        System.out.println("\nEXERCISE 11");
        LocalTime ex11 = LocalTime.parse("00:00:00");
        System.out.println(ex11);
    }

    private static void EX12() {
        System.out.println("\nEXERCISE 12");
        LocalTime ex12 = LocalTime.now();
        DateTimeFormatter ex12format = DateTimeFormatter.ofPattern("HH:mm:ss");
        String ex12FormattedTime = ex12.format(ex12format);
        System.out.println(ex12FormattedTime);
    }

    private static void EX13() {
        System.out.println("\nEXERCISE 13");
        LocalDateTime ex13 = LocalDateTime.now();
        DateTimeFormatter ex13format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter ex13format2 = DateTimeFormatter.ofPattern("HH:mm");
        String ex13FormattedDateTime1 = ex13.format(ex13format1);
        String ex13FormattedDateTime2 = ex13.format(ex13format2);
        System.out.println(ex13FormattedDateTime1 + " time: " + ex13FormattedDateTime2);
    }

    private static void EX14() {
        System.out.println("\nEXERCISE 14");
        LocalDateTime ex13 = LocalDateTime.now();
        DateTimeFormatter ex14format = DateTimeFormatter.ofPattern("EEEE dd LLLL HH:mm");
        String ex14Formatted = ex13.format(ex14format);
        System.out.println(ex14Formatted);
    }

    private static void EX15() {
        System.out.println("\nEXERCISE 15");
        LocalDateTime ex15 = LocalDateTime.now();
        LocalDate ex151 = LocalDate.now();
        String ex152 = ex15.toString() + " " + ex151.toString();
        System.out.println(ex152);
    }

    private static void EX16() {
        System.out.println("\nEXERCISE 16");
        LocalDateTime ex15 = LocalDateTime.now();
        LocalDate ex151 = LocalDate.now();
        String ex152 = ex15.toString() + " " + ex151.toString();
        String[] ex16Parts = ex152.split(" "); // works when there is a single space
        LocalDateTime ex16DateTime = LocalDateTime.parse(ex16Parts[0]);
        LocalDate ex16Date = LocalDate.parse(ex16Parts[1]);
        System.out.println(ex16Date);
        System.out.println(ex16DateTime);
    }
}

/*
 * Java Time API basics: LocalDate, LocalTime, LocalDateTime represent date/time
 * without timezone.
 * Period measures time in days/months/years; Duration measures time in
 * seconds/nanoseconds.
 * DateTimeFormatter formats and parses date/time objects with custom patterns.
 * 
 * Common operations/methods (commands) used in the exercises:
 * LocalDate.now() // Current date
 * LocalTime.now() // Current time
 * LocalDateTime.now() // Current date and time
 * DateTimeFormatter.ofPattern(String pattern) // Create formatter with custom
 * pattern
 * .format(DateTimeFormatter formatter) // Format date/time as String
 * .getDayOfWeek() // Get day of week (Monday, Tuesday, etc.)
 * .getValue() // Get numeric value of DayOfWeek (1=Monday, 7=Sunday)
 * .getMonth() // Get month name
 * .plusYears(int years) // Add years
 * .minusMonths(int months) // Subtract months
 * .minusDays(int days) // Subtract days
 * .plusDays(int days) // Add days
 * Period.between(LocalDate start, LocalDate end) // Calculate period between
 * dates
 * Period.of(int years, int months, int days) // Create specific period
 * .plus(Period period) // Add period to date
 * LocalDate.parse(String text) // Parse string to LocalDate
 * LocalTime.parse(String text) // Parse string to LocalTime
 * LocalDateTime.parse(String text) // Parse string to LocalDateTime
 * .split(String regex) // Split string by delimiter
 * 
 * Utilities used:
 * java.time.LocalDate // Date without time
 * java.time.LocalTime // Time without date
 * java.time.LocalDateTime // Date and time combined
 * java.time.Period // Measures time in date-based units
 * java.time.Month // Enum of months
 * java.time.format.DateTimeFormatter // Format/parse dates and times
 */