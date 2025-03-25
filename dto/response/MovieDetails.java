package com.project.MovieDatabase.dto.response;

import java.util.List;

import com.project.MovieDatabase.entity.Director;
import com.project.MovieDatabase.entity.Rating;

import lombok.Data;

@Data
public class MovieDetails {
    private int id;

    private String title;
    private String genre;
    private int releaseYear;
	
    private List<String> actors;
    private Director director;
    private List<Rating> rating;
}
