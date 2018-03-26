package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Modify the Artist Layout using tabs_layout and list
 * Layout where you can see all the artist in your system.
 */

public class ArtistActivity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list, container, false);

        /* List of songs needed as param in the adapter */
        ArrayList<Song> songs = new ArrayList<Song>();
        /* List of artists names in the system */
        ArrayList<String> artists = new ArrayList<>(MainActivity.getListSongs().keySet());
        /* Sort artists */
        Collections.sort(artists);
        /* Add the first song of each artist to {@link songs} to be able to call the adapter. */
        Iterator<String> it = artists.iterator();
        while(it.hasNext()){
            String el = it.next();
            songs.add(MainActivity.getListSongs().get(el).get(0));
        }

        /* Find the {@link ListView} object in the view hierarchy of the view activity */
        ListView listView = (ListView) view.findViewById(R.id.list);

        /* Create an {@link ListAdapter}, whose data source is a list of {@link Song}s.
         * The adapter knows how to create list items for each item in the list.
         * Using 0 as listSelection param because we want a list of {@link Artist}, not {@link Song}.
         */
        ListAdapter adapter = new ListAdapter(getActivity(), R.layout.tabs_layout, songs, 0);

        /* Make the {@link ListView} use the {@link ListAdapter} */
        listView.setAdapter(adapter);

        /* Set a click item listener on the list view */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Getting the TextView with the artist name */
                TextView listTopTextView = (TextView) view.findViewById(R.id.top_name);
                /* Getting the String of the artist name */
                String extraIntent = listTopTextView.getText().toString();

                /* Explicit intent */
                Intent artistIntent = new Intent(getActivity(), ArtistSongs.class);
                /* Extra intent to know which artist's list of songs we want to see. */
                artistIntent.putExtra("artist", extraIntent);
                startActivity(artistIntent);
            }
        });

        return view;
    }
}
