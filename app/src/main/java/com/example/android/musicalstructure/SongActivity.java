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

/**
 * Modify Songs Layout using tabs_layout and list
 * Layout where you can see all the songs in your system.
 */

public class SongActivity extends Fragment  {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list, container, false);

        /* List of songs needed as param in the adapter */
        ArrayList<Song> songs = new ArrayList<Song>();

        /* Add all the songs of all artists into the songs list. */
        for (ArrayList<Song> value : MainActivity.getListSongs().values()) {
            songs.addAll(value);
        }

        /* Find the {@link ListView} object in the view hierarchy of the view activity */
        ListView listView = (ListView) view.findViewById(R.id.list);

        /* Create an {@link ListAdapter}, whose data source is a list of {@link Song}s.
         * The adapter knows how to create list items for each item in the list.
         * Using 1 as listSelection param because we want a list of {@link Song}, not {@link Artist}.
         */
        ListAdapter adapter = new ListAdapter(getActivity(), R.layout.tabs_layout, songs, 1);

        /* Make the {@link ListView} use the {@link ListAdapter} */
        listView.setAdapter(adapter);

        /* Set a click item listener on the list view */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /* Getting the TextViews with the song and artist name */
                TextView listTopTextView = (TextView) view.findViewById(R.id.top_name);
                TextView listBottomTextView = (TextView) view.findViewById(R.id.bottom_name);

                /* Getting the Strings of the song and artist name */
                String extraIntent = listTopTextView.getText().toString();
                String extraIntent2 = listBottomTextView.getText().toString();

                /* Explicit intent */
                Intent artistIntent = new Intent(getActivity(), PlayingActivity.class);

                /* Extra intent to know which song we want to listen */
                artistIntent.putExtra("song", extraIntent);
                artistIntent.putExtra("songArtist", extraIntent2);
                startActivity(artistIntent);
            }
        });

        return view;
    }
}
