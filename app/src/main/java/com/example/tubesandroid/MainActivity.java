package com.example.tubesandroid;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    static boolean isTwoPane = false;

    private FrameLayout mFrameLayout;
    FragmentTransaction mfragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFrameLayout = findViewById(R.id.frameLayout);
        moveFragment(new MovieFragment());

        if (findViewById(R.id.frameLayout_land) != null){
            isTwoPane = true;
        }else {
            isTwoPane = false;
        }
    }

    private void moveFragment(Fragment fragment){
        getSupportFragmentManager().popBackStackImmediate();
        mfragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout,fragment);
        mfragmentTransaction.commit();
    }
}
