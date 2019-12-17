package com.example.tubesandroid;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment implements OnMovieClick {

    private RecyclerView movieListView;
    private MovieAdapter movieAdapter;
    private List<MovieModel> listMovieModel = new ArrayList<>();
    private Context mContext;
    private OnMovieClick listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dummyData(listMovieModel);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View mView, @Nullable Bundle
            savedInstanceState) {
        super.onViewCreated(mView, savedInstanceState);
        movieListView = mView.findViewById(R.id.listMovie);
        movieListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mContext = getActivity().getApplicationContext();

        listener = this;

        movieAdapter = new MovieAdapter(listMovieModel,getActivity().getSupportFragmentManager(),mContext,listener);
        movieListView.setAdapter(movieAdapter);
        movieAdapter.SetListModel(listMovieModel);
    }
    @Override
    public void onItemClick(MovieModel movieModel, int position) {
        if (!MainActivity.isTwoPane){
            Intent intent = new Intent(getContext(),DetailActivity.class);
            final Intent movie = intent.putExtra("movie", movieModel);
            startActivity(intent);
        }else {
            getFragmentManager().beginTransaction().replace(R.id.frameLayout_land,DetailFragment.newInstance(movieModel)).commit();
        }
    }
    private void dummyData(List<MovieModel> listMovieModel) {
        listMovieModel.add(new MovieModel("Spider-Man: Far from Home",R.drawable.spiderman,"Action","7,8","Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent."));
        listMovieModel.add(new MovieModel("The Lion King",R.drawable.lion_king,"Animation","6,7","Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his."));
        listMovieModel.add(new MovieModel("Toy Story4",R.drawable.toy_story_4,"Animation","7,7","Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called Forky to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy."));
        listMovieModel.add(new MovieModel("Avengers: Endgame",R.drawable.end_game,"Animation","8,4","After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store."));
        listMovieModel.add(new MovieModel("Crawl",R.drawable.crawl,"Action","6,0","While struggling to save her father during a Category 5 hurricane, a young woman finds herself trapped inside a flooding house and fighting for her life against Florida’s most savage and feared predators."));
        listMovieModel.add(new MovieModel("Annabelle Comes Home",R.drawable.anabelle,"Horror","6,0","Determined to keep Annabelle from wreaking more havoc, demonologists Ed and Lorraine Warren bring the possessed doll to the locked artifacts room in their home, placing her “safely” behind sacred glass and enlisting a priest’s holy blessing. But an unholy night of horror awaits as Annabelle awakens the evil spirits in the room, who all set their sights on a new target—the Warrens' ten-year-old daughter, Judy, and her friends."));
        listMovieModel.add(new MovieModel("Men in Black: Internationa",R.drawable.mib,"Action","6,00","The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization."));
        listMovieModel.add(new MovieModel("Shaft ",R.drawable.shaft,"Action","6,4","JJ, aka John Shaft Jr., may be a cyber security expert with a degree from MIT, but to uncover the truth behind his best friend’s untimely death, he needs an education only his dad can provide. Absent throughout JJ’s youth, the legendary locked-andloaded John Shaft agrees to help his progeny navigate Harlem’s heroin-infested underbelly."));
        listMovieModel.add(new MovieModel("Yesterday",R.drawable.yesterday,"Drama","6,6","Jack Malik is a struggling singer-songwriter in an English seaside town whose dreams of fame are rapidly fading, despite the fierce devotion and support of his childhood best friend, Ellie. After a freak bus accident during a mysterious global blackout, Jack wakes up to discover that he's the only person on Earth who can remember The Beatles."));
        listMovieModel.add(new MovieModel("Stuber",R.drawable.stuber,"Action","6,4","After crashing his car, a cop who's recovering from eye surgery recruits an Uber driver to help him catch a heroin dealer. The mismatched pair soon find themselves in for a wild day of stakeouts and shootouts as they encounter the city's seedy side."));
        listMovieModel.add(new MovieModel("Anna",R.drawable.anna,"Action","6,0","Beneath Anna Poliatova's striking beauty lies a secret that will unleash her indelible strength and skill to become one of the world's most feared government assassins."));
    }
}
