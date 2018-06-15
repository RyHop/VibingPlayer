package com.example.ryan.vibingplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class custom_song_adapter extends ArrayAdapter<songs_class> {

    //Udacity tutorials is a huge resource for the code below.


    public custom_song_adapter(@NonNull Context context, ArrayList<songs_class> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.layout_listview_of_songs, parent, false);
        }

        // Get the Word object located at this position in the list
        songs_class currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView songTextView = (TextView) listItemView.findViewById(R.id.textView1);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        songTextView.setText(currentSong.getSongtitle());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.textView2);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        artistTextView.setText(currentSong.getArtist());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        //Figuring I could also cast an imageView within the viws. The Udacity link found in the classes provided reference.
        ImageView albumView = (ImageView) listItemView.findViewById(R.id.albumPicture);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        albumView.setImageResource(currentSong.getAlbumCover());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
