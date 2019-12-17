package com.example.tubesandroid;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    MovieModel movieModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        movieModel = getIntent().getParcelableExtra("movie");

        getSupportFragmentManager().beginTransaction().replace(R.id.fragrament_detail, DetailFragment.newInstance(movieModel)).commit();
    }
}
