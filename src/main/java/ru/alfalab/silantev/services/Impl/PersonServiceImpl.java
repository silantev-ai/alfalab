package ru.alfalab.silantev.services.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alfalab.silantev.models.Person;
import ru.alfalab.silantev.repositories.PersonRepository;
import ru.alfalab.silantev.services.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAllByDocument(String documentNumber) {

        return personRepository.findAllByDocument(documentNumber);
    }
}
