package com.project.MovieDatabase.controller;

import com.project.MovieDatabase.dto.request.CreateMovieRequestDTO;
import com.project.MovieDatabase.dto.request.CreateMovieUpdateDTO;
import com.project.MovieDatabase.dto.response.MovieDetails;
import com.project.MovieDatabase.entity.Movie;
import com.project.MovieDatabase.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public List<Movie> getAllMovies() {
        return service.getAllMovies();
    }

    @GetMapping("/{id}")
    public MovieDetails getMovieById(@PathVariable int id) {
        return service.getMovieById(id);
    }

    @PostMapping
    public Movie saveMovie(@RequestBody CreateMovieRequestDTO movie) {
        return service.saveMovie(movie);
    }

    @PutMapping("/{id}")
    public String updateMovie(@PathVariable int id, @RequestBody CreateMovieUpdateDTO movieDTO) {
        return service.updateMovie(id, movieDTO);
    }

}