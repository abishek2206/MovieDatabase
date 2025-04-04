package com.project.MovieDatabase.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="smtp")
public class SmtpEntity {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String subject;
	private String content;
	private String reciver;
}
