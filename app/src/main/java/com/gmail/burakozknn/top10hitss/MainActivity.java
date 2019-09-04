package com.gmail.burakozknn.top10hitss;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;


import com.gmail.burakozknn.popularmovies.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {

    //private RecyclerView mRecyclerView;
    private Adapter.PeliculaAdapter mAdapter;


    public static final String KEY = "d0d1227c0be3634f814b1578b672c8ea";
    public static final String URLDominio="http://api.themoviedb.org/3";

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        ButterKnife.bind(this);

        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);


        mRecyclerView.setLayoutManager(horizontalLayoutManagaer);
        mAdapter = new Adapter.PeliculaAdapter(this);
        mRecyclerView.setAdapter(mAdapter);


        List<Pelicula> peliculas = new ArrayList<>();

        for (int i = 0; i < peliculas.size(); i++) {
            peliculas.add(new Pelicula());        }


        mAdapter.setMovieList(peliculas);



        ShowTopTen();
    }


    private void ShowTopTen() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(URLDominio)
                .setRequestInterceptor(new RequestInterceptor() {
                    @Override
                    public void intercept(RequestFacade request) {
                        request.addEncodedQueryParam("api_key", KEY);
                    }
                })
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        ApiService service = restAdapter.create(ApiService.class);

        service.getTopMovies(new Callback<Pelicula.MovieResult>() {
            @Override
            public void success(Pelicula.MovieResult movieResult, Response response) {
                mAdapter.setMovieList(movieResult.getResults());
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }

        });
    }



}
