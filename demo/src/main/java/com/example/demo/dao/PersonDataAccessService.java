package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonDataAccessService {
    private static List<Person> DB = new ArrayList<>();

    public void addPerson(Person person){
        DB.add(person);
    }

    public Optional<Person> getSlackNameAndTrack(String slackName, String track){
        return DB.stream()
                .filter(person -> person.getSlackName().equals(slackName)&&person.getTrack().equals(track))
                .findFirst();
    }

}
