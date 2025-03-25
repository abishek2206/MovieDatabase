package com.project.MovieDatabase.service;

import com.project.MovieDatabase.dto.request.CreateRatingRequestDTO;
import com.project.MovieDatabase.entity.Movie;
import com.project.MovieDatabase.entity.Rating;
import com.project.MovieDatabase.repository.MovieRepository;
import com.project.MovieDatabase.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Optional<Rating> getRatingById(int id) {
        return ratingRepository.findById(id);
    }

    public Rating saveRating(CreateRatingRequestDTO ratingBody) {
        Optional<Movie> optionalMovie = movieRepository.findById(ratingBody.getMovieId());
        if (optionalMovie.isEmpty()) {
            throw new RuntimeException("Movie not found");
        }

        Movie movie = optionalMovie.get();

        Rating rating = new Rating();
        rating.setMovie(movie);
        rating.setRating(ratingBody.getRating());
        rating.setTitle(ratingBody.getTitle());

        return ratingRepository.save(rating);
    }

    public String updateRating(int id, Rating rating) {
        if (ratingRepository.existsById(id)) {
            ratingRepository.save(rating);
            return "Success";
        }
        return "Not Success";
    }
}
