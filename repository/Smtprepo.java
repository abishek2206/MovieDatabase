package com.project.MovieDatabase.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.MovieDatabase.entity.SmtpEntity;



@Repository
public interface Smtprepo extends JpaRepository<SmtpEntity, Integer> {

}
