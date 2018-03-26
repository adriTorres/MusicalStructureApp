package com.example.android.musicalstructure;

/**
 * {@link Artist} represents an Artist fromm a song.
 * It contains an artist's name and an image related to them.
 */

public class Artist {
    //Artist name
    private String name;
    //Artist image
    private int image;

    /**
     * Create a new Artist object.
     *
     * @param name artist name
     * @param image artist picture
     */
    public Artist(String name, int image) {
        this.name = name;
        this.image = image;
    }

    //Get artist name
    public String getName() {
        return name;
    }

    //Get artist picture
    public int getImage() {
        return image;
    }
}
