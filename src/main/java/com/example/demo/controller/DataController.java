package com.example.demo.controller;

import com.example.demo.dao.Person;
import com.example.demo.service.PersonsService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
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

    @GetMapping("/userDetails")
    @PostAuthorize("returnObject.username == 'user' or hasRole('DELETE')")
    public User userDetails() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @GetMapping("/set")
    @Secured("WRITE")
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
    @Secured("DELETE")
    public boolean deletePerson(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("age") int age
    ) {
        return personsService.deletePerson(name, surname, age);
    }

    @GetMapping("/get-by-city")
    @Secured("READ")
    public List<Person> getPersonsByCity(@RequestParam("city") String city) {
        return personsService.getPersonsByCity(city);
    }

    @GetMapping("/get-age-more-than")
    @PreAuthorize("hasRole('READ') or hasRole('WRITE')")
    public List<Person> getPersonsAgeMoreThan(@RequestParam("age") int age) {
        return personsService.getPersonsAgeMoreThan(age);
    }

    @GetMapping("/get-by-name-and-surname")
    @RolesAllowed({"READ", "WRITE", "DELETE"})
    public Optional<Person> getPersonsByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return personsService.getPersonsByNameAndSurname(name, surname);
    }

}
