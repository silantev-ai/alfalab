package ru.alfalab.silantev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.alfalab.silantev.services.PersonService;

@Component
public class ApplicationAdapter implements CommandLineRunner {

    private final PersonService personService;

    public ApplicationAdapter(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run(String... args) {
        System.out.println(
                personService.findAllByDocument("777")
        );
    }
}
