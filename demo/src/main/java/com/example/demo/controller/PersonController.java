package com.example.demo.controller;

import com.example.demo.model.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

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
   public ResponseEntity<Map<String, Object>> getSlackNameAndTrack(
           @RequestParam(name = "slack_name") String slackName,
           @RequestParam(name = "track") String track
   ) {
        // Calculate the UTC time when a request is received
        String utcTime = getCurrentUtcTime();
        // For demonstration purposes, add a Person object to the database
        // Create a JSON response with the dynamic UTC time and other data
        Map<String, Object> response = new HashMap<>();
        response.put("slack_name", slackName);
        response.put("track", track);
        response.put("current_day",dayOfWeekString);
        response.put("utc_time", utcTime);
        response.put("github_file_url","https://github.com/mercyy21/hng_stage_one/tree/master/demo/src/main/java/com/example/demo/controller");
        response.put("github_repo_url", "https://github.com/mercyy21/hng_stage_one");
        response.put("status_code",200);
        // For demonstration purposes, add a Person object to the database
        database.add(new Person("Tolulope_Awopetu", dayOfWeekString, utcTime, "backend", "https://github.com/mercyy21/hng_stage_one/tree/master/demo/src/main/java/com/example/demo/controller", "https://github.com/mercyy21/hng_stage_one", 200));

        // You can return a ResponseEntity with the JSON response and an HTTP status code
        return ResponseEntity.ok(response);
    }






   }
