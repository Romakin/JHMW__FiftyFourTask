package com.example.demo.controller;

import com.example.demo.dao.Person;
import com.example.demo.service.PersonsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class DataController {

    PersonsService personsService;

    public DataController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/by-city")
    @ResponseBody
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return personsService.getPersonsByCity(city);
    }

}
