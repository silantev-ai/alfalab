package ru.alfalab.silantev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.alfalab.silantev.models.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT DISTINCT p FROM Person p " +
            "LEFT JOIN FETCH p.documents docs " +
            "WHERE docs.number like %:documentCode% and docs.active = true")
    List<Person> findAllByDocument(String documentCode);
}
