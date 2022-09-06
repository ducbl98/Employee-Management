package com.shinbae.mvc.employeemanagement.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
@Getter
@Setter
public class RandomBirthday {
    private static final int START_YEAR = 1970;
    private static final int END_YEAR = 2022;
    private Date date;

    public RandomBirthday() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randomYear(START_YEAR, END_YEAR);
        gc.set(Calendar.YEAR, year);
        int dayOfYear = randomYear(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
        this.date = gc.getTime();
        log.info("RandomBirthday() : {}", gc.getTime());
    }

    private static int randomYear(int startYear, int endYear) {
        return startYear + (int) Math.round(Math.random() * (endYear - startYear));
    }
}
