package com.example.ryan.vibingplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Albums extends AppCompatActivity {

    // Initializing all variables.
    String message;
    ImageView jColeAlbumView;
    ImageView dooWopsAlbumView;
    ImageView loveInTheFutureAlbumView;
    ImageView storiesAlbumView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        // Getting views from the XML
        jColeAlbumView = (ImageView) findViewById(R.id.jColeImageView);
        dooWopsAlbumView = (ImageView) findViewById(R.id.brunoMarsImageView);
        loveInTheFutureAlbumView = (ImageView) findViewById(R.id.johnLegendImageView);
        storiesAlbumView = (ImageView) findViewById(R.id.aviciiImageView);

        // Setting an onClick listener. Also, sending a message of what album was chose to the other activity. At the moment, I did not know how to send an ArrayList<songs> over intents.
        jColeAlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Use the songs in the J Cole Album

                message = "It is J. Cole";

                Intent intent = new Intent(Albums.this, albumSongs.class);
                intent.putExtra("this", message);
                startActivity(intent);


            }
        });

        // Setting an onClick listener for the Bruno Mars
        dooWopsAlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Use the songs in the doo Wops Album

                message = "It is Bruno Mars";

                Intent intent = new Intent(Albums.this, albumSongs.class);
                intent.putExtra("this", message);
                startActivity(intent);


            }
        });

        // Setting an onClick listener for the John Legend Album
        loveInTheFutureAlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Use the songs in the John Legend Album

                message = "It is John Legend";

                Intent intent = new Intent(Albums.this, albumSongs.class);
                intent.putExtra("this", message);
                startActivity(intent);


            }
        });

        // Setting an onClick listener for the Avicii Album.
        storiesAlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Use the songs in the Avicii Album.
                message = "It is Avicii";

                Intent intent = new Intent(Albums.this, albumSongs.class);
                intent.putExtra("this", message);
                startActivity(intent);

            }
        });
    }
}
