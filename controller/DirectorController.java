package com.project.MovieDatabase.controller;

import com.project.MovieDatabase.dto.request.CreateDirectorRequestDTO;
import com.project.MovieDatabase.entity.Director;
import com.project.MovieDatabase.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectorService service;

    @GetMapping
    public List<Director> getAllDirectors() {
        return service.getAllDirectors();
    }

    @GetMapping("/{id}")
    public Optional<Director> getDirectorById(@PathVariable int id) {
        return service.getDirectorById(id);
    }

    @PostMapping
    public Director saveDirector(@RequestBody CreateDirectorRequestDTO director) {
        return service.saveDirector(director);
    }

    @PutMapping("/{id}")
    public String updateDirector(@PathVariable int id, @RequestBody Director director) {
        return service.updateDirector(id, director);
    }
}