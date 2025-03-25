package com.project.MovieDatabase.controller;

import com.project.MovieDatabase.dto.request.CreateActorRequestDTO;
import com.project.MovieDatabase.entity.Actor;
import com.project.MovieDatabase.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService service;

    @GetMapping
    public List<Actor> getAllActors() {
        return service.getAllActors();
    }

    @GetMapping("/{id}")
    public Optional<Actor> getActorById(@PathVariable int id) {
        return service.getActorById(id);
    }

    @PostMapping
    public Actor saveActor(@RequestBody CreateActorRequestDTO actor) {
        return service.saveActor(actor);
    }

    @PutMapping("/{id}")
    public String updateActor(@PathVariable int id, @RequestBody Actor actor) {
        return service.updateActor(id, actor);
    }
}