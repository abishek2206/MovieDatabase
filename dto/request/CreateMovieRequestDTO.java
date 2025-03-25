package com.project.MovieDatabase.dto.request;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class CreateMovieRequestDTO {
    private String title;
    private String genre;
    private int releaseYear;
    private int directorId;
    private List<Integer> actors = new ArrayList<>();
}
