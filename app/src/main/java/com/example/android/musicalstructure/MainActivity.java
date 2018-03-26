package com.example.android.musicalstructure;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class MainActivity extends FragmentActivity {

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;

    //Main song storage structure using the artist name as key to the list of songs.
    private static LinkedHashMap<String, ArrayList<Song>> listSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        //Tabs adapter
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());

        //Make Song List
        ArrayList<Song> marshSongs = new ArrayList<Song>();
        ArrayList<Song> siaSongs = new ArrayList<Song>();
        ArrayList<Song> tsfhSongs = new ArrayList<Song>();
        listSongs = new LinkedHashMap<>();

        //Create artists
        Artist marshmello = new Artist("Marshmello", R.drawable.marshmello);
        Artist sia = new Artist("Sia", R.drawable.sia);
        Artist tsfh = new Artist("Two Steps From Hell", R.drawable.tsfh);

        //Create songs related to artists.
        marshSongs.add(new Song("Know me", marshmello));
        marshSongs.add(new Song("Summer", marshmello));
        marshSongs.add(new Song("Find me", marshmello));
        marshSongs.add(new Song("Take it Back", marshmello));
        marshSongs.add(new Song("Bounce", marshmello));
        marshSongs.add(new Song("Blocks", marshmello));
        marshSongs.add(new Song("Show you", marshmello));
        marshSongs.add(new Song("Want U 2", marshmello));
        marshSongs.add(new Song("Home ", marshmello));

        siaSongs.add(new Song("Bird Set Free", sia));
        siaSongs.add(new Song("Alive", sia));
        siaSongs.add(new Song("One Million Bullets", sia));
        siaSongs.add(new Song("Move Your Body", sia));
        siaSongs.add(new Song("Unstoppable", sia));
        siaSongs.add(new Song("Cheap Thrills", sia));
        siaSongs.add(new Song("Reaper", sia));
        siaSongs.add(new Song("House On Fire", sia));
        siaSongs.add(new Song("Footprints", sia));
        siaSongs.add(new Song("Sweet Design", sia));

        tsfhSongs.add(new Song("None Shall Live", tsfh));
        tsfhSongs.add(new Song("Stormkeeper", tsfh));
        tsfhSongs.add(new Song("Victory", tsfh));
        tsfhSongs.add(new Song("Wolf King", tsfh));
        tsfhSongs.add(new Song("Rise Above", tsfh));
        tsfhSongs.add(new Song("Spellcaster", tsfh));
        tsfhSongs.add(new Song("Never Back Down", tsfh));
        tsfhSongs.add(new Song("Red Tower", tsfh));
        tsfhSongs.add(new Song("Cannon In D Minor", tsfh));
        tsfhSongs.add(new Song("Blackout", tsfh));
        tsfhSongs.add(new Song("Stronger Faster Braver", tsfh));

        //Add list of songs to the hashmap using the artist name of the songs as key
        listSongs.put(marshmello.getName(), marshSongs);
        listSongs.put(sia.getName(), siaSongs);
        listSongs.put(tsfh.getName(), tsfhSongs);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    //Setup the tabs adapter
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new ArtistActivity(), "Artists");
        adapter.addFragment(new SongActivity(), "Songs");
        viewPager.setAdapter(adapter);
    }

    //Getter to obtain the songs
    public static LinkedHashMap<String, ArrayList<Song>> getListSongs() {
        return listSongs;
    }
}
