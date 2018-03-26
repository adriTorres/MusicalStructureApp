package com.example.android.musicalstructure;

/**
 * {@link Song} represents a song to listen.
 * It contains the song's name and an Artist Object.
 */

public class Song {
    //Song name
    private String name;
    //Artist object
    private Artist artist;

    /**
     * Create a new Song object.
     *
     * @param name song name
     * @param artist artist object who made the song
     */
    public Song(String name, Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    //Get name
    public String getName() {
        return name;
    }

    //Get artist
    public Artist getArtist() {
        return artist;
    }
}
