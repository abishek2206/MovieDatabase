package com.project.MovieDatabase.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int birthYear;

    @ManyToMany(mappedBy = "actors")
    private List<Movie> movies;
}
