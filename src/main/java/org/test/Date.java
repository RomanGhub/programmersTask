package org.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Date {

//    private LocalDate date;
//    private Period timePeriod;

    private LocalDate fromDate;
    private LocalDate toDate;

    private static final String pattern = "dd.MM.yyyy";


    public Date(String date) throws Exception {
//        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        setDateFromString(date);
    }

    public void setDateFromString(String period) throws Exception {
        String[] segments = period.split("-");

        if (segments.length > 2 || segments.length == 0) {
            throw new Exception("Invalid question id's number: " + segments.length);
        } else if(segments.length == 1){
            setDate(segments[0]);
        } else { //if(segments.length == 2){
            setDatePeriod(segments[0], segments[1]);
        }
    }

    public void setDatePeriod(String from, String to){
        LocalDate startDate = LocalDate.parse(from, DateTimeFormatter.ofPattern(pattern));
        LocalDate endDate = LocalDate.parse(to, DateTimeFormatter.ofPattern(pattern));
//        this.timePeriod = Period.between(startDate, endDate);
        this.fromDate = startDate;
        this.toDate = endDate;
    }

    public void setDate(String date){
        this.fromDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    public LocalDate getDate() {
        return fromDate;
    }

    public List<LocalDate> getTimePeriod() {
        if (fromDate == null || toDate==null) {
//            throw new RuntimeException("This is waiting timeline, it has no period");
            return Arrays.asList(fromDate, fromDate);
        } else {
            return Arrays.asList(fromDate, toDate);
        }
    }
}
