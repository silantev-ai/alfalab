package ru.alfalab.silantev.models;

import ru.alfalab.silantev.enums.DocumentType;

import javax.persistence.*;

@Entity
@Table(name = "DOCUMENT", schema = "PUBLIC")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, targetEntity = Person.class)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @Column(name = "DOCUMENT_TYPE")
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name = "NUMBER", nullable = false, columnDefinition = "VARCHAR(50)")
    private String number;

    @Column(name = "ACTIVE")
    private Boolean active = true;

    @Override
    public String toString() {
        return "Document{" +
                "documentType=" + documentType +
                ", number='" + number + '\'' +
                '}';
    }
}
