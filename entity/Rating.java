package com.project.MovieDatabase.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int rating;
    private String title;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
