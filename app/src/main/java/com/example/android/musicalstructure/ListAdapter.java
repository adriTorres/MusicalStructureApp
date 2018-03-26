package com.example.android.musicalstructure;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link ListAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Song} objects.
 */
public class ListAdapter extends ArrayAdapter<Song> {
    /**
     * if mListSelection = 0 -> artist layout
     * if mListSelection = 1 -> song layout
     */
    private int mListSelection;

    /**
     * List of Song passed in the constructor
     */
    private List<Song> songs;

    /**
     * Create a new {@link ListAdapter} object.
     *
     * @param context       is the current context (i.e. Activity) that the adapter is being created in.
     * @param source        is the activity to use as element list.
     * @param songs         is the list of {@link Song}s to be displayed.
     * @param listSelection is used to select type of layout, artists or songs
     */
    public ListAdapter(Context context, int source, ArrayList<Song> songs, int listSelection) {
        super(context, source, songs);
        this.songs = songs;
        mListSelection = listSelection;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tabs_layout, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = songs.get(position);

        //Find top and bottom TextView, and ImageView from tabs_layout.xml
        TextView listTopTextView = (TextView) listItemView.findViewById(R.id.top_name);
        TextView listBottomTextView = (TextView) listItemView.findViewById(R.id.bottom_name);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.artist_image);

        //Check if there is a song to add to the list
        if (currentSong != null && listTopTextView != null && listBottomTextView != null & imageView != null) {
            //Check if it has to bee shown an artists layout or songs layout
            if (mListSelection == 0) {
                //Show artist name and artist image
                listTopTextView.setText(currentSong.getArtist().getName());
                //Show artist image
                imageView.setImageResource(currentSong.getArtist().getImage());
                //Make sure the bottom text ios not visible
                listBottomTextView.setVisibility(View.INVISIBLE);
            } else {
                //Show name song
                listTopTextView.setText(currentSong.getName());
                //Show artist name
                listBottomTextView.setText(currentSong.getArtist().getName());
                //Show artist image
                imageView.setImageResource(currentSong.getArtist().getImage());
            }
        }

        //Return the whole list item layout
        return listItemView;
    }


}
