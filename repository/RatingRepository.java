package com.project.MovieDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.MovieDatabase.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
