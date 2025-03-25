package com.project.MovieDatabase.service;

import com.project.MovieDatabase.dto.request.CreateActorRequestDTO;
import com.project.MovieDatabase.entity.Actor;
import com.project.MovieDatabase.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository repository;

    public List<Actor> getAllActors() {
        return repository.findAll();
    }

    public Optional<Actor> getActorById(int id) {
        return repository.findById(id);
    }

    public Actor saveActor(CreateActorRequestDTO actorBody) {
    	
    	Actor actor = new Actor();
    	
    	actor.setName(actorBody.getName());
    	actor.setBirthYear(actorBody.getBirthYear());
    	actor.setMovies(new ArrayList<>());
    	
        return repository.save(actor);
    }

    public String updateActor(int id, Actor actor) {
        if (repository.existsById(id)) {
            repository.save(actor);
            return "Success";
        }
        return "Not Success";
    }
}