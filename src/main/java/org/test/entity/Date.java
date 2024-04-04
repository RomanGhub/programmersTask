package org.test.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Date {

    private LocalDate fromDate;
    private LocalDate toDate;
    private static final String PATTERN = "dd.MM.yyyy";


    public Date(String date) {
        setDateFromString(date);
    }

    private void setDateFromString(String period) {
        String[] segments = period.split("-");

        if (segments.length > 2 || segments.length == 0) {
            throw new IllegalArgumentException("Invalid question id's number: " + segments.length);
        } else if (segments.length == 1) {
            setDate(segments[0]);
        } else {
            setDatePeriod(segments[0], segments[1]);
        }
    }

    public void setDatePeriod(String from, String to) {
        LocalDate startDate = LocalDate.parse(from, DateTimeFormatter.ofPattern(PATTERN));
        LocalDate endDate = LocalDate.parse(to, DateTimeFormatter.ofPattern(PATTERN));
        this.fromDate = startDate;
        this.toDate = endDate;
    }

    public void setDate(String date) {
        this.fromDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(PATTERN));
    }

    public LocalDate getDate() {
        return fromDate;
    }

    public List<LocalDate> getTimePeriod() {
        if (fromDate == null || toDate == null) {
            return Arrays.asList(fromDate, fromDate);
        } else {
            return Arrays.asList(fromDate, toDate);
        }
    }

    @Override
    public String toString() {
        return "Date{" +
                "fromDate=" + fromDate +
                ", toDate=" + toDate +
                '}';
    }
}
