package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RequestMapping("/api")
@RestController
public class PersonController {
    private static List<Person> database = new ArrayList<Person>();
    LocalDate currentDate = LocalDate.now();
    DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
    String dayOfWeekString = dayOfWeek.getDisplayName(TextStyle.FULL,Locale.ENGLISH);
    public static String getCurrentUtcTime(){
        String utcTime;
        Instant instant = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        utcTime=instant.atZone(java.time.ZoneOffset.UTC).format(formatter);
        return utcTime;
    }
    @GetMapping
    public Optional<Person> getSlackNameAndTrack(@RequestParam(name = "slack_name") String slackName, @RequestParam(name = "track") String track){
        database.add(new Person("Mercy A.",dayOfWeekString,getCurrentUtcTime(),"backend","https://github.com/mercyy21/hng_stage_one/tree/master/demo/src/main/java/com/example/demo/controller","https://github.com/mercyy21/hng_stage_one",200));
        return database.stream()
                .filter(person -> person.getSlackName().equals(slackName)&&person.getTrack().equals(track))
                .findFirst();
    }




}
