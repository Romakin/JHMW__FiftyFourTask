
package com.example.demo.repository;

import com.example.demo.dao.Person;
import com.example.demo.dao.PersonPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonsCrudRepository extends JpaRepository<Person, PersonPK> {

    @Query("select p from Person p where upper(p.name) like upper(:name) and upper(p.surname) like upper(:surname) ")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);

    @Query("select p from Person p where p.age < :age")
    List<Person> findByAgeLessThanEqualOrderByAge(@Param("age") int age);

    @Query(value = "select p.* from Person p where regexp_like(p.city_of_living, :city) ", nativeQuery = true)
    List<Person> findByCityOfLiving(@Param("city") String city);
}