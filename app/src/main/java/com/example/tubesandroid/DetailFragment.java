package com.example.tubesandroid;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class DetailFragment extends Fragment {
    MovieModel movieModel;
    public static DetailFragment newInstance(MovieModel movieModel) {
        DetailFragment myFragment = new DetailFragment();

        Bundle args = new Bundle();
        args.putParcelable("movie",movieModel);
        myFragment.setArguments(args);
        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_fragment,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            movieModel = getArguments().getParcelable("movie");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView imageViewDetail = view.findViewById(R.id.imageViewDetail);
        TextView textViewJudul = view.findViewById(R.id.tvJudul);
        TextView textViewReview = view.findViewById(R.id.tvSinopsis2);
        TextView textViewRating = view.findViewById(R.id.tvRating);

        textViewJudul.setText(movieModel.judul);
        textViewReview.setText(movieModel.sinopsis);
        textViewRating.setText(movieModel.ratingScore);
    }
}
