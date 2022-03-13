package com.cameron.model;

public class Movie {
    private int id;
    private int imdb_id;
    private String title;
    private String director;
    private int year;
    private int rating;
    private String genres;
    private int runtime;
    private String country;
    private String language;
    private int imdb_score;
    private int imdb_votes;
    private Number metacritic_score;

    public Movie() {

    }

    public Movie(int id, int imdb_id, String title, String director, int year, int rating, String genres, int runtime, String country, String language, int imdb_score, int imdb_votes, Number metacritic_score) {
        this.id = id;
        this.imdb_id = imdb_id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.genres = genres;
        this.runtime = runtime;
        this.country = country;
        this.language = language;
        this.imdb_score = imdb_score;
        this.imdb_votes = imdb_votes;
        this.metacritic_score = metacritic_score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(int imdb_id) {
        this.imdb_id = imdb_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getImdb_score() {
        return imdb_score;
    }

    public void setImdb_score(int imdb_score) {
        this.imdb_score = imdb_score;
    }

    public int getImdb_votes() {
        return imdb_votes;
    }

    public void setImdb_votes(int imdb_votes) {
        this.imdb_votes = imdb_votes;
    }

    public Number getMetacritic_score() {
        return metacritic_score;
    }

    public void setMetacritic_score(Number metacritic_score) {
        this.metacritic_score = metacritic_score;
    }
}
