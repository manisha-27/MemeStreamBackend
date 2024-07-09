package com.project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.model.Meme;

public interface MemeRepository extends JpaRepository<Meme, Integer> {

//	@Query
//	List<Meme> findByNameOrCaption(String searchTerm);
	
	@Query
    public List<Meme> findByNameContainingIgnoreCase(String name);
	
	@Query
	public List<Meme> findAllByOrderByNameAsc();
	
	@Query
	public List<Meme> findAllByOrderByNameDesc();

}
