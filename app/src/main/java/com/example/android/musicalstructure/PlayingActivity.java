package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Modify playing_layout.xml
 * Layout where you can see the song which is playing.
 * The play button doesn't work, as well as the next song, back song and the seekbar
 */

public class PlayingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playing_layout);

        /* Getting the intent that called this activity */
        Intent myIntent = getIntent();

        /* Setting the String that contains the song we want to listen. */
        String song = myIntent.getStringExtra(MainActivity.SONG);
        String artist = myIntent.getStringExtra(MainActivity.SONGARTIST);

        /* Views we want to modify */
        TextView songName = (TextView) findViewById(R.id.song_name);
        TextView songArtist = (TextView) findViewById(R.id.song_artist);
        ImageView songImg = (ImageView) findViewById(R.id.song_img);

        /* Setting the views using the info obtained from the extra intents */
        songName.setText(song);
        songArtist.setText(artist);
        songImg.setImageResource(MainActivity.getListSongs().get(artist).get(0).getArtist().getImage());
    }
}
