package com.project.MovieDatabase.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String genre;
    private int releaseYear;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "movie_actor",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private List<Rating> ratings;
}
