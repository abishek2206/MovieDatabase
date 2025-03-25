package com.project.MovieDatabase.service;

import com.project.MovieDatabase.dto.request.CreateDirectorRequestDTO;
import com.project.MovieDatabase.entity.Director;
import com.project.MovieDatabase.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository repository;

    public List<Director> getAllDirectors() {
        return repository.findAll();
    }

    public Optional<Director> getDirectorById(int id) {
        return repository.findById(id);
    }

    public Director saveDirector(CreateDirectorRequestDTO directorBody) {
    	Director director = new Director();
    	
    	director.setName(directorBody.getName());
    	director.setBirthYear(directorBody.getBirthYear());

    	director.setMovies(new ArrayList<>());
    	
        return repository.save(director);
    }

    public String updateDirector(int id, Director director) {
        if (repository.existsById(id)) {
            repository.save(director);
            return "Success";
        }
        return "Not Success";
    }
}