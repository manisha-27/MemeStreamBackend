package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="meme")
public class Meme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String caption;
	private String url;
	public Meme() {
		super();
	}
	public Meme(String name, String caption, String url) {
		super();
		this.name = name;
		this.caption = caption;
		this.url = url;
	}
	public int getId() {
		return id;
	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getURL() {
		return url;
	}
	public void setURL(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Meme [id=" + id + ", Name=" + name + ", Caption=" + caption + ", URL=" + url + "]";
	}
	
}
