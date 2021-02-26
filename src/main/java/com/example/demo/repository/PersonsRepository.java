package com.example.demo.repository;

import com.example.demo.dao.Person;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonsRepository {

    private static final String QUERY_SCRIPT_NAME = "sql/personsByCity.sql";
    private static final String QUERY_PARAM_NAME = "city";

    @PersistenceContext
    private EntityManager manager;

    public List<Person> getPersonByCity(String city) {
        String sqlQuery = read(QUERY_SCRIPT_NAME);
        return manager.createQuery(sqlQuery).setParameter(QUERY_PARAM_NAME, city).getResultList();
    }

    public static String read(String scriptName) {
        try(InputStream is = new ClassPathResource(scriptName).getInputStream()) {
            return String.join("\n", readLines(is));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static List<String> readLines(InputStream is) {
        return new BufferedReader(new InputStreamReader(is)).lines().collect(Collectors.toList());
    }
}
