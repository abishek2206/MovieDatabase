package com.project.MovieDatabase.dto.request;

import lombok.Data;

@Data
public class CreateRatingRequestDTO {
    private int rating;
    private String title;
    
    private int movieId;
}
