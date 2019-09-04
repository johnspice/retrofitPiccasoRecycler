package com.gmail.burakozknn.top10hitss;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gmail.burakozknn.popularmovies.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter {

    public static class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder> {

        private int topLimit=10;
        private List<Pelicula> mPeliculaList;
        private LayoutInflater mInflater;
        private Context mContext;



        public PeliculaAdapter(Context context) {
            this.mContext = context;
            this.mInflater = LayoutInflater.from( context );
            this.mPeliculaList = new ArrayList<>();
        }


        @Override
        public PeliculaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate( R.layout.item_pelicula, parent, false );
            PeliculaViewHolder viewHolder = new PeliculaViewHolder( view );

            return viewHolder;
        }


        @Override
        public void onBindViewHolder(PeliculaViewHolder holder, int position) {
            Pelicula pelicula = mPeliculaList.get( position );


         
            Picasso.with( mContext )
                    .load( pelicula.getPoster() )
                    .placeholder( R.color.colorPrimary )
                    .into( holder.imageView );

            holder.textViewTitulo.setText(mPeliculaList.get(position).getTitle());
            holder.textViewCal.setText(mPeliculaList.get(position).getRating());


        }

        @Override
        public int getItemCount() {

            //return (mPeliculaList == null) ? 0 : mPeliculaList.size();

            if(mPeliculaList.size() > topLimit){
                return topLimit;
            }
            else
            {
                return mPeliculaList.size();
            }

        }

        public class PeliculaViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageView;
            public TextView textViewTitulo;
            public TextView textViewCal;


            public PeliculaViewHolder(final View itemView) {
                super( itemView );
                imageView = (ImageView) itemView.findViewById( R.id.imageView );
                textViewTitulo=(TextView) itemView.findViewById(R.id.tv_titulo);
                textViewCal=(TextView) itemView.findViewById(R.id.tv_cal);


                // item click

                itemView.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {


                            Toast.makeText( v.getContext(), ""+ mPeliculaList.get( position ).getTitle(), Toast.LENGTH_SHORT ).show();


                            Intent intent = new Intent( v.getContext(), SinopsisActivity.class );
                            intent.putExtra( "movie_title", mPeliculaList.get( position ).getTitle() );
                            intent.putExtra( "movie_image", mPeliculaList.get( position ).getPoster() );
                            intent.putExtra( "movie_overview", mPeliculaList.get( position ).getDescription() );
                            intent.putExtra( "movie_average", mPeliculaList.get( position ).getRating() );
                            intent.putExtra( "movie_release_date", mPeliculaList.get( position ).getReleaseDate() );

                            v.getContext().startActivity( intent );

                        }
                    }
                } );

            }

        }

        public void setMovieList(List<Pelicula> peliculaList) {
            this.mPeliculaList.clear();
            this.mPeliculaList.addAll(peliculaList);

            // The adapter needs to know that the data has changed. If we don't call this, app will crash.
            notifyDataSetChanged();
        }


    }
}
