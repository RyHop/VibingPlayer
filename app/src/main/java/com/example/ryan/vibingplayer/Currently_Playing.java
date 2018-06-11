package com.example.ryan.vibingplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Currently_Playing extends AppCompatActivity {
    // Initializing all variables to make it public throughout the class.
    Boolean whichImage;
    int albumCover;
    ImageView albumView;
    TextView songView;
    TextView artistView;
    ImageView backButton;
    ImageView forwardButton;
    ImageView playButton;
    String songToDisplay;
    int currentSong;
    ArrayList<String> allTheSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently__playing);

        // Casting all Views to dynamically change them in this file
        albumView = (ImageView) findViewById(R.id.albumCover);
        songView = (TextView) findViewById(R.id.songName);
        artistView = (TextView) findViewById(R.id.artistName);
        backButton = (ImageView) findViewById(R.id.backImageView);
        playButton = (ImageView) findViewById(R.id.playImageView);
        forwardButton = (ImageView) findViewById(R.id.forwardImageView);

        // Accounting for the current song in the list for Currently Playing.
        songToDisplay = getIntent().getStringExtra("songTitle");

        // For the picked song, display info about it while playing
        albumView.setImageResource(getIntent().getIntExtra("picture", 4));
        songView.setText(getIntent().getStringExtra("songTitle"));
        artistView.setText(getIntent().getStringExtra("songArtist"));
        allTheSongs = getIntent().getStringArrayListExtra("allTheSongs");

        // The index of the current song within the array.
        currentSong = allTheSongs.indexOf(songToDisplay);

        //If the back button is pressed, play the previous song in the array.
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getting the song name of the one before
                if (currentSong == 0) {
                    //Do nothing but show the user that we can't do anything.
                    Toast.makeText(Currently_Playing.this, "Can not go back any further",
                            Toast.LENGTH_LONG).show();
                } else {
                    //Show the song title that is before the Currently Playing song
                    int beforeSong = currentSong - 1;
                    songView.setText(allTheSongs.get(beforeSong));
                    currentSong = beforeSong;

                }


            }
        });

        //This boolean variable keeps track on the user's decision of playing the song or pausing the song.
        whichImage = true;

        // Switch the image resource depending on the boolean variable.
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (whichImage) {
                    playButton.setImageResource(R.drawable.pause_button);
                    whichImage = false;
                } else {
                    playButton.setImageResource(R.drawable.play);
                    whichImage = true;
                }

            }
        });

        //The forward button for the user to change songs. Similar to the back button.
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSong == (allTheSongs.size() - 1)) {
                    //Do nothing but show the user that you can not go forward anymore.
                    Toast.makeText(Currently_Playing.this, "Can not go forward any further",
                            Toast.LENGTH_LONG).show();
                } else {
                    //getting the nex song and displaying it. Also, making that the current song.
                    int forwardSong = currentSong + 1;
                    songView.setText(allTheSongs.get(forwardSong));
                    currentSong = forwardSong;

                }


            }
        });


    }


}
