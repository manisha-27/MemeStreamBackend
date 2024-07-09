package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Meme;
import com.project.service.MemeService;

// https://localhost:4002/meme/findAll

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequestMapping("/meme")
public class MemeController {
	
	@Autowired
	private final MemeService service;
	
	public MemeController(MemeService memeservice) {
		this.service=memeservice;
	}
	
	@PostMapping("/save")
	public String registerMeme(@RequestBody Meme meme) {
		return service.saveMeme(meme);
	}
	
	@GetMapping("/findAll")
	public List<Meme> findAll(){
		System.out.println("In findAll Controller GET Request");
		return service.findAll();
	}
	
	@GetMapping("/search/{value}")
	public List<Meme> findByNameOrCaption(@PathVariable String value){
		return service.findByNameOrCaption(value);
	}
	
	@GetMapping("/{id}")
	public Optional<Meme> findById(@PathVariable int id){
		Optional<Meme> opt=service.findById(id);
//		if(opt.isPresent()) {
			return Optional.of(opt.get());
//		}else {
//			System.out.println("Throw Exception");
//			throw new MemeNotFoundException("Id : "+id+" not found");
//		}
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public String UpdateById(@RequestBody Meme meme ,@PathVariable int id) {
		return service.UpdateById(meme, id);
	}
}
