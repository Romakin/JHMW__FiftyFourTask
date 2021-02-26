package com.example.demo.service;

import com.example.demo.dao.Person;
import com.example.demo.dao.PersonPK;
import com.example.demo.repository.PersonsCrudRepository;
//import com.example.demo.repository.PersonsCrudRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonsService {

    @Autowired
    private PersonsCrudRepository personsCrudRepository;

//    private PersonsCrudRepositoryImpl personsCrudRepositoryImpl;
//
//    public PersonsService(PersonsCrudRepositoryImpl personsCrudRepositoryImpl) {
//        this.personsCrudRepositoryImpl = personsCrudRepositoryImpl;
//    }

    public List<Person> getPersonsByCity(String city) {
        return personsCrudRepository.findByCityOfLiving(city);
    }

    public List<Person> getPersonsAgeMoreThan(int age) {
        return personsCrudRepository.findByAgeLessThanEqualOrderByAge(age);
    }

    public Optional<Person> getPersonsByNameAndSurname(String name, String surname) {
        return personsCrudRepository.findByNameAndSurname(name, surname);
    }

    public boolean deletePerson(String name, String surname, int age) {
        PersonPK pk = new PersonPK(name, surname, age);
        if (personsCrudRepository.findById(pk).isPresent()) {
            personsCrudRepository.deleteById(pk);
            return true;
        }
        return false;
    }

    public boolean createOrUpdatePerson(String name,
                                        String surname,
                                        int age,
                                        String phoneNumber,
                                        String city,
                                        boolean createIfNotExists) {
        PersonPK pk = new PersonPK(name, surname, age);
        Optional<Person> op = personsCrudRepository.findById(pk);
        Person p = null;
        if (op.isPresent()) {
            p = op.get();
            if(!"".equals(city)) p.setCityOfLiving(city);
            if(!"".equals(phoneNumber)) p.setPhoneNumber(phoneNumber);
        } else if (createIfNotExists) {
            p = new Person(name, surname, age, phoneNumber, city);
        }
        if (p!= null) {
            personsCrudRepository.saveAndFlush(p);
            return true;
        }
        return false;
    }
}
