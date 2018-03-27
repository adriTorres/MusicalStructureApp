package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Modify layout of list of songs associate with an artist.
 * Layout where you can see all the songs of the artist you have chosen.
 */

public class ArtistSongs extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        /* Getting the intent */
        Intent myIntent = getIntent();
        /* Getting the extra intent String to know which artist list song we want to see. */
        String artist = myIntent.getStringExtra(MainActivity.ARTIST);

        /* Setting the label toolbar to the name of the artist which list of song we are seeing */
        this.setTitle(artist);

        /* List song of the artist */
        ArrayList<Song> songs = MainActivity.getListSongs().get(artist);

        /* Setting the adapter (Same as {@link SongActivity} adapter*/
        ListView listView = (ListView) findViewById(R.id.list);
        ListAdapter adapter = new ListAdapter(this, R.layout.tabs_layout, songs, 1);
        listView.setAdapter(adapter);

        /* Setting the item click listener (Same as {@link SongActivity} listener */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView listTopTextView = (TextView) view.findViewById(R.id.top_name);
                TextView listBottomTextView = (TextView) view.findViewById(R.id.bottom_name);
                String extraIntent = listTopTextView.getText().toString();
                String extraIntent2 = listBottomTextView.getText().toString();

                Intent artistIntent = new Intent(ArtistSongs.this, PlayingActivity.class);
                artistIntent.putExtra(MainActivity.SONG, extraIntent);
                artistIntent.putExtra(MainActivity.SONGARTIST, extraIntent2);
                startActivity(artistIntent);
            }
        });

    }
}
