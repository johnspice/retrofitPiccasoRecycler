package com.gmail.burakozknn.top10hitss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.gmail.burakozknn.popularmovies.R;
import com.squareup.picasso.Picasso;


import butterknife.BindView;
import butterknife.ButterKnife;

public class SinopsisActivity extends AppCompatActivity {

    @BindView(R.id.mImageUrl)
    ImageView imvPoster;

    @BindView(R.id.mTitle)
    TextView tvTitle;
    @BindView(R.id.mOverview)
    TextView tvSinopsis;
    @BindView(R.id.mRating)
    TextView tvCal;
    @BindView(R.id.mReleaseDate)
    TextView tvEstreno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sinopsis);
        ButterKnife.bind(this);








        // getdata an show de anterior activity
        String overview = getIntent().getExtras().getString("movie_overview");
        tvSinopsis.setText( overview );
        String vote_average = getIntent().getExtras().getString("movie_average");
        tvCal.setText( vote_average );
        String release_date = getIntent().getExtras().getString("movie_release_date");
        tvEstreno.setText( release_date );
        String title = getIntent().getExtras().getString("movie_title");
        tvTitle.setText( title );

        // Pelicula poster
        String image = getIntent().getExtras().getString("movie_image");
        Picasso.with(this).load( image ).into(imvPoster);


    }
}
