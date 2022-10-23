package com.dojo.sessionattributes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persons")
@Data
@NoArgsConstructor
public class Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    @Column(name = "last_name")
    private String lastName;

    public Person(String code, String name, String lastName) {
        this.code = code;
        this.name = name;
        this.lastName = lastName;
    }
}
