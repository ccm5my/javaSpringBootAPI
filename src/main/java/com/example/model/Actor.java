package com.example.model;

public class Actor {

	private int id;
	private int movie_id;
	private int imdb_id;
	private String name;

	public Actor(int id, int movie_id, int imdb_id, String name) {
		this.id = id;
		this.movie_id = movie_id;
		this.imdb_id = imdb_id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	public int getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(int imdb_id) {
		this.imdb_id = imdb_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
