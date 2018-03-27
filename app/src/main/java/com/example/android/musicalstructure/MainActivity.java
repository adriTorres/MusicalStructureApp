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

    //Constant extra intent keys
    public final static String SONG = "song";
    public final static String ARTIST = "artist";
    public final static String SONGARTIST = "songartist";

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
        Artist marshmello = new Artist(getString(R.string.marshmello), R.drawable.marshmello);
        Artist sia = new Artist(getString(R.string.sia), R.drawable.sia);
        Artist tsfh = new Artist(getString(R.string.tsfh), R.drawable.tsfh);

        //Create songs related to artists.
        marshSongs.add(new Song(getString(R.string.marsh_song1), marshmello));
        marshSongs.add(new Song(getString(R.string.marsh_song2), marshmello));
        marshSongs.add(new Song(getString(R.string.marsh_song3), marshmello));
        marshSongs.add(new Song(getString(R.string.marsh_song4), marshmello));
        marshSongs.add(new Song(getString(R.string.marsh_song5), marshmello));
        marshSongs.add(new Song(getString(R.string.marsh_song6), marshmello));
        marshSongs.add(new Song(getString(R.string.marsh_song7), marshmello));
        marshSongs.add(new Song(getString(R.string.marsh_song8), marshmello));
        marshSongs.add(new Song(getString(R.string.marsh_song9), marshmello));

        siaSongs.add(new Song(getString(R.string.sia_song1), sia));
        siaSongs.add(new Song(getString(R.string.sia_song2), sia));
        siaSongs.add(new Song(getString(R.string.sia_song3), sia));
        siaSongs.add(new Song(getString(R.string.sia_song4), sia));
        siaSongs.add(new Song(getString(R.string.sia_song5), sia));
        siaSongs.add(new Song(getString(R.string.sia_song6), sia));
        siaSongs.add(new Song(getString(R.string.sia_song7), sia));
        siaSongs.add(new Song(getString(R.string.sia_song8), sia));
        siaSongs.add(new Song(getString(R.string.sia_song9), sia));
        siaSongs.add(new Song(getString(R.string.sia_song10), sia));

        tsfhSongs.add(new Song(getString(R.string.tsfh_song1), tsfh));
        tsfhSongs.add(new Song(getString(R.string.tsfh_song2), tsfh));
        tsfhSongs.add(new Song(getString(R.string.tsfh_song3), tsfh));
        tsfhSongs.add(new Song(getString(R.string.tsfh_song4), tsfh));
        tsfhSongs.add(new Song(getString(R.string.tsfh_song5), tsfh));
        tsfhSongs.add(new Song(getString(R.string.tsfh_song6), tsfh));
        tsfhSongs.add(new Song(getString(R.string.tsfh_song7), tsfh));
        tsfhSongs.add(new Song(getString(R.string.tsfh_song8), tsfh));
        tsfhSongs.add(new Song(getString(R.string.tsfh_song9), tsfh));
        tsfhSongs.add(new Song(getString(R.string.tsfh_song10), tsfh));
        tsfhSongs.add(new Song(getString(R.string.tsfh_song11), tsfh));

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
