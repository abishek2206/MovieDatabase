package com.project.MovieDatabase.service;

import com.project.MovieDatabase.dto.request.CreateMovieRequestDTO;
import com.project.MovieDatabase.dto.request.CreateMovieUpdateDTO;
import com.project.MovieDatabase.dto.response.MovieDetails;
import com.project.MovieDatabase.entity.Actor;
import com.project.MovieDatabase.entity.Director;
import com.project.MovieDatabase.entity.Movie;
import com.project.MovieDatabase.entity.Rating;
import com.project.MovieDatabase.repository.ActorRepository;
import com.project.MovieDatabase.repository.DirectorRepository;
import com.project.MovieDatabase.repository.MovieRepository;
import com.project.MovieDatabase.repository.RatingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    
    @Autowired
    private ActorRepository actorRepository;
    
    @Autowired
    private DirectorRepository directorRepository;
    
    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public MovieDetails getMovieById(int id) {
    	MovieDetails movieDetails = new MovieDetails();
    	
    	Movie movie = repository.findById(id).get();
    	
    	movieDetails.setId(movie.getId());
    	movieDetails.setTitle(movie.getTitle());
    	movieDetails.setReleaseYear(movie.getReleaseYear());
    	movieDetails.setGenre(movie.getGenre());
  
    	movieDetails.setActors(movie.getActors().stream().map(actor->actor.getName()).toList());
    	
    	movieDetails.setDirector(movie.getDirector());
    	movieDetails.setRating(movie.getRatings());
    	
        return movieDetails;
    }

    public Movie saveMovie(CreateMovieRequestDTO movieBody) {
    	
    	Movie movie = new Movie();
    	movie.setTitle(movieBody.getTitle());
    	movie.setGenre(movieBody.getGenre());
    	movie.setReleaseYear(movieBody.getReleaseYear());
    	
    	Optional<Director> oDirector = directorRepository.findById(movieBody.getDirectorId());
    	
    	var director = oDirector.get();
    	
    	movie.setDirector(director);
    	
    	List<Actor> actors = new ArrayList<>();
    	movieBody.getActors().forEach(actorId->{
    		Actor actor = actorRepository.findById(actorId).get();
    		actors.add(actor);   	
    	});
    	movie.setActors(actors);

    	movie.setRatings(new ArrayList<>());
    	
        return repository.save(movie);
    }

    public String updateMovie(int id, CreateMovieUpdateDTO movieDTO) {
        Optional<Movie> optionalMovie = repository.findById(id);
        if (optionalMovie.isEmpty()) {
            return "Movie not found";
        }

        Movie movie = optionalMovie.get();
        
        movie.setTitle(movieDTO.getTitle());
        movie.setGenre(movieDTO.getGenre());
        movie.setReleaseYear(movieDTO.getReleaseYear());

        // Update Director
        Optional<Director> oDirector = directorRepository.findById(movieDTO.getDirectorId());
        oDirector.ifPresent(movie::setDirector);

        // Update Actors
        List<Actor> actors = actorRepository.findAllById(movieDTO.getActors());
        movie.setActors(actors);

        repository.save(movie);
        return "Movie updated successfully";
    }

}