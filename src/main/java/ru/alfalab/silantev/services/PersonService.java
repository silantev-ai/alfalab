package ru.alfalab.silantev.services;

import ru.alfalab.silantev.models.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAllByDocument(String documentNumber);
}
