package com.example.demo.controller;

import com.example.demo.dao.Person;
import com.example.demo.service.PersonsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
@ResponseBody
public class DataController {

    PersonsService personsService;

    public DataController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hi, guest!";
    }

    @GetMapping("/set")
    public boolean createOrUpdatePerson(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("age") int age,
            @RequestParam(name = "phoneNumber", required = false, defaultValue = "") String phoneNumber,
            @RequestParam(name = "city", required = false, defaultValue = "") String city,
            @RequestParam(name = "createIfNotExists", required = false, defaultValue = "false") boolean createIfNotExists
    ) {
        return personsService.createOrUpdatePerson(
                name, surname,  age, phoneNumber, city, createIfNotExists
        );
    }

    @GetMapping("/delete")
    public boolean deletePerson(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("age") int age
    ) {
        return personsService.deletePerson(name, surname, age);
    }

    @GetMapping("/get-by-city")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return personsService.getPersonsByCity(city);
    }

    @GetMapping("/get-age-more-than")
    @ResponseBody
    public List<Person> getPersonsAgeMoreThan(@RequestParam("age") int age) {
        return personsService.getPersonsAgeMoreThan(age);
    }

    @GetMapping("/get-by-name-and-surname")
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return personsService.getPersonsByNameAndSurname(name, surname);
    }

}
