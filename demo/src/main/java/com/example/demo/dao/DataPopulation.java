package com.example.demo.dao;

import com.example.demo.model.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class DataPopulation {
    @Autowired
    private PersonDataAccessService personDataAccessService;

    // Get the current date
    LocalDate currentDate = LocalDate.now();

    // Get the current day of the week as an enum (e.g., DayOfWeek.MONDAY)
    DayOfWeek dayOfWeek = currentDate.getDayOfWeek();

    // Convert the DayOfWeek enum to a string representation
    String dayOfWeekString = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    public static String getCurrentUtcTime(){
        String utcTime;
        Instant instant = Instant.now();
        utcTime=instant.toString();
        return utcTime;
    }


    @PostConstruct
    public void populateData(){
        personDataAccessService.addPerson(new Person("Mercy A.",dayOfWeekString,getCurrentUtcTime(),));
    }
}
