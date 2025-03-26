package com.project.MovieDatabase.repository;



import com.project.MovieDatabase.entity.Actor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
	
public List<Actor> findByNameContains(String name);

public List<Actor> findByNameContaining(String name);

public List<Actor> findByNameNotContaining(String name);

public List<Actor> findByNameStartsWith(String name);

public List<Actor> findByNameEndsWith(String name);

public Page<Actor> findAll(Pageable page);

}