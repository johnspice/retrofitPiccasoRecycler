package com.gmail.burakozknn.top10hitss;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pelicula {

    public static final String URLImage = "http://image.tmdb.org/t/p/w500";

    private String title, vote_average,release_date ;


    @SerializedName("poster_path")
    private String poster;

    @SerializedName("overview")
    private String description;

    @SerializedName("backdrop_path")
    private String backdrop;

    public Pelicula() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return URLImage + poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(String release_date) {
        this.release_date = release_date;
    }


    public String getRating() {
        return vote_average;
    }

    public void setRating(String vote_average) {
        this.vote_average = vote_average;
    }


    public String getBackdrop() {
        return URLImage  + backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public static class MovieResult {
        private List<Pelicula> results;

        public List<Pelicula> getResults() {
            return results;
        }
    }
}
