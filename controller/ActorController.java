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
    
    
    
  //SMTP
	
  	@PostMapping("/smtp")
  	public String smtphandle(@RequestParam String reciever,@RequestParam String subject,@RequestParam String content) {
  		return service.smtphandler(reciever,subject,content);
  	}
  	
  	//
  	@GetMapping("/Contains")
	public List<Actor> checkContians(@RequestParam String name) {
		return service.checkContians(name);
	}
	
	@GetMapping("/Containing")
	public List<Actor> checkContaining(@RequestParam String name) {
		return service.checkContaining(name);
	}

	@GetMapping("/notcontaining")
	public List<Actor> fetchnotcontaining(@RequestParam String name)
	{
		return service.getnotcontaining(name);	
	}
	@GetMapping("/startswith")
	public List<Actor> fetchstarts(@RequestParam String name)
	{
		return service.getstartswith(name);
	}
	
	@GetMapping("/endswith")
	public List<Actor> fetchends(@RequestParam String name)
	{
		return service.getendswith(name);
	}
	@GetMapping("/get")
	public List<Actor> paginationfetch(@RequestParam int pageno,@RequestParam int pagesize,@RequestParam String name){
		return service.getsortedrecord(pageno,pagesize,name);
	}
 }