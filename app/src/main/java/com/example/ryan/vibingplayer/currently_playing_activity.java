package com.example.ryan.vibingplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class currently_playing_activity extends AppCompatActivity {
    // Initializing all variables to make it public throughout the class.
    Boolean whichImage;
    int albumCover;
    ImageView albumView;
    TextView songView;
    TextView artistView;
    ImageView backButton;
    ImageView forwardButton;
    ImageView playButton;
    public static String songToDisplay;
    int currentSong;
    ArrayList<String> allTheSongs;
    String whichAlbum;
    Boolean songPlaying;
    Boolean pickedAlbum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_currently__playing);
        whichAlbum = getIntent().getStringExtra("theMessage");

        //If the user gets to this screen, the user has to have an picked in the before screen. I need the app to know that, if the user wants to travel back.
        pickedAlbum = true;

        //Same concept as the pickedAlbum boolean, the app needs to know there is a song playing in the other activities for navigation
        songPlaying = true;

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
                    Toast.makeText(currently_playing_activity.this, "Can not go back any further",
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

        //The forward button for the user to change songs_class. Similar to the back button.
        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentSong == (allTheSongs.size() - 1)) {
                    //Do nothing but show the user that you can not go forward anymore.
                    Toast.makeText(currently_playing_activity.this, "Can not go forward any further",
                            Toast.LENGTH_LONG).show();
                } else {
                    //getting the nex song and displaying it. Also, making that the current song.
                    int forwardSong = currentSong + 1;
                    songView.setText(allTheSongs.get(forwardSong));
                    currentSong = forwardSong;

                }


            }
        });

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myChildToolbar);








    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the currently_playing_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.currently_playing_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            //So, the Extras are set up to be received by the albums_activity or album_songs_activity that notifies them if a song is playing or there is an album picked, so the menu buttons work without crashing.
            case R.id.menu_albums_button:
                Intent intent = new Intent(currently_playing_activity.this,albums_activity.class);
                intent.putExtra("weHaveASongPlaying",songPlaying);
                intent.putExtra("currently_playing_activity_picked_album_boolean",pickedAlbum);
                startActivity(intent);


                return true;
            case R.id.menu_song_list_button:
                Intent intent1 = new Intent(currently_playing_activity.this, album_songs_activity.class);
                intent1.putExtra("this", whichAlbum);
                intent1.putExtra("weHaveASongPlaying",songPlaying);
                startActivity(intent1);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }


}
