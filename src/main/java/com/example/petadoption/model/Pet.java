package com.example.petadoption.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer petId;
    private String name;
    private String breed;
    private Integer age;
    private String sex;
    private String size;
    private String status;
    private LocalDate admissionDate;
    private Integer speciesId;
    private Integer shelterId;

}
