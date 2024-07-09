package com.project.service;

import java.util.List;
import java.util.Optional;
import com.project.model.Meme;


public interface IService {
	public String saveMeme(Meme meme);
	public List<Meme> findAll();
	public Optional<Meme> findById(int id);
	public String UpdateById(Meme meme, int id);
	public String deleteById(int id);
	public List<Meme> findByNameOrCaption(String value);
}
