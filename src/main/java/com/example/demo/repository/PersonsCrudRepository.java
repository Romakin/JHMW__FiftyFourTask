package com.example.demo.repository;

import com.example.demo.dao.Person;
import com.example.demo.dao.PersonPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsCrudRepository extends JpaRepository<Person, PersonPK> {

    Optional<Person> findByNameAndSurname(String name, String surname);

    List<Person> findByAgeLessThanEqualOrderByAge(int age);

    List<Person> findByCityOfLiving(String city);
}
