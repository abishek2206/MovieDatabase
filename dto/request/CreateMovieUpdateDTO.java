package com.project.MovieDatabase.dto.request;

import lombok.Data;
import java.util.List;

@Data
public class CreateMovieUpdateDTO {
    private String title;
    private String genre;
    private int releaseYear;
    private int directorId;
    private List<Integer> actors;
}
