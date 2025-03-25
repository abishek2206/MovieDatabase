package com.project.MovieDatabase.dto.request;

import lombok.Data;

@Data
public class CreateDirectorRequestDTO {
    private String name;
    private int birthYear;
}
