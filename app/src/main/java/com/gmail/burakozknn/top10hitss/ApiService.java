package com.gmail.burakozknn.top10hitss;

import retrofit.Callback;
import retrofit.http.GET;


public interface ApiService {

    // to pull up top rated movies from the movie database
    @GET("/movie/top_rated")
    void getTopMovies(Callback<Pelicula.MovieResult> cb);

}
