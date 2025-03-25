package com.project.MovieDatabase.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int birthYear;

    @OneToMany(mappedBy = "director")
    @JsonIgnore
    private List<Movie> movies;
}
