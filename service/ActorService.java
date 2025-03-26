package com.project.MovieDatabase.service;

import com.project.MovieDatabase.dto.request.CreateActorRequestDTO;
import com.project.MovieDatabase.entity.Actor;
import com.project.MovieDatabase.entity.SmtpEntity;
import com.project.MovieDatabase.repository.ActorRepository;
import com.project.MovieDatabase.repository.Smtprepo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
    
    
    
    
    
    
    //SMTP SERVICE
    @Autowired
    JavaMailSender sender;

    @Autowired
    private  Smtprepo smtprepo;
    public String smtphandler(String reciever, String subject, String content) {
    	// TODO Auto-generated method stub
    	try {
    		MimeMessage msg = sender.createMimeMessage();
    		MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
    		
    		msgHelper.setTo(reciever);
    	
    		msgHelper.setSubject(subject);
    		
    		msgHelper.setText(content);
    		
    		sender.send(msg);
    		
    		SmtpEntity entity = new SmtpEntity();
    		entity.setReciver(reciever);
    		entity.setSubject(subject);
    		entity.setContent(content);
    		smtprepo.save(entity);
    		
    		return "Mail sent Successfully";
    	}
    	catch(MessagingException e) {
    		return "Mail not Sent"+ e.getMessage();
    	}
    }
    
    //
    public List<Actor> checkContians(String name) {
    	// TODO Auto-generated method stub
    	return repository.findByNameContains(name);
    }
    public List<Actor> checkContaining(String name) {
    	// TODO Auto-generated method stub
    	return repository.findByNameContaining(name);
    }

    public List<Actor> getnotcontaining(String name) {
    	return repository.findByNameNotContaining(name);
    }
    public List<Actor> getstartswith(String name) {
		return repository.findByNameStartsWith(name);
	}
	
	public List<Actor> getendswith(String name) {
		return repository.findByNameEndsWith(name);
	}
	
	public List<Actor> getsortedrecord(int pageno, int pagesize, String name) {
	    Pageable page = PageRequest.of(pageno, pagesize, Sort.by(name).ascending());
		return repository.findAll(page).getContent();
	}


}