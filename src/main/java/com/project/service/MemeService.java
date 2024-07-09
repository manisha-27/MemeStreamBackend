package com.project.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.MemeRepository;
import com.project.model.Meme;

@Service
//@Transactional
public class MemeService implements IService {
	
	@Autowired
	MemeRepository memeRepo;
	
	@Override
	public String saveMeme(Meme meme) {
		memeRepo.save(meme);
		return "Meme Saved";
	}

	@Override
	public List<Meme> findAll() {
//		System.out.println("In findAll Service GET Request");
		return memeRepo.findAll();
	}

	@Override
	public Optional<Meme> findById(int id) {
		return memeRepo.findById(id);
	}

	@Override
	public String UpdateById(Meme meme, int id) {
		Optional<Meme> existingmeme=memeRepo.findById(id);
		if(existingmeme.isPresent()) {
			Meme result=existingmeme.get();
			result.setName(meme.getName());
			result.setCaption(meme.getCaption());
			result.setURL(meme.getURL());
			memeRepo.save(result);
			return "Updated "+id;
		}else {
			return "User not found";
		}
	}

	@Override
	public String deleteById(int id) {
		Optional<Meme> existingmeme=memeRepo.findById(id);
		if(existingmeme.isPresent()) {
			memeRepo.deleteById(id);
			return "Deleted "+id;
		}else {
			return "User not found";
		}
	}

	@Override
	public List<Meme> findByNameOrCaption(String name){
		return memeRepo.findByNameContainingIgnoreCase(name);
	}
}
