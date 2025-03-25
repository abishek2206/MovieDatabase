package com.project.MovieDatabase.controller;

import com.project.MovieDatabase.dto.request.CreateRatingRequestDTO;
import com.project.MovieDatabase.entity.Rating;
import com.project.MovieDatabase.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService service;

    @GetMapping
    public List<Rating> getAllRatings() {
        return service.getAllRatings();
    }

    @GetMapping("/{id}")
    public Optional<Rating> getRatingById(@PathVariable int id) {
        return service.getRatingById(id);
    }

    @PostMapping
    public Rating saveRating(@RequestBody CreateRatingRequestDTO rating) {
        return service.saveRating(rating);
    }

    @PutMapping("/{id}")
    public String updateRating(@PathVariable int id, @RequestBody Rating rating) {
        return service.updateRating(id, rating);
    }
} 
