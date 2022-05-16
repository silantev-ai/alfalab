package ru.alfalab.silantev.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "PERSON", schema = "PUBLIC")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "EMAIL", unique = true, nullable = false, columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(255)")
    private String firstName;

    @Column(name = "SECOND_NAME", columnDefinition = "VARCHAR(255)")
    private String secondName;

    @Column(name = "LAST_NAME", columnDefinition = "VARCHAR(255)")
    private String lastName;

    @Column(name = "PHONE", columnDefinition = "VARCHAR(50)")
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Document> documents = new ArrayList<>();

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", documents=" + documents +
                '}';
    }
}
