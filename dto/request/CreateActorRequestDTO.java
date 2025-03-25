package com.project.MovieDatabase.dto.request;

import lombok.Data;

@Data
public class CreateActorRequestDTO {
	private String name;
    private int birthYear;
}
