package com.example.ryan.vibingplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AlbumsActivity extends AppCompatActivity {

    // Initializing all variables.
    String message;
    ImageView jColeAlbumView;
    ImageView dooWopsAlbumView;
    ImageView loveInTheFutureAlbumView;
    ImageView storiesAlbumView;
    Boolean isSongPlaying;
    Boolean isSongPlaying2;
    Boolean pickedAlbumyet;
    Boolean pickedAlbumyet2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_albums);


        //The boolean from the CurrentlyPlayingActivity that signifies if a song is currently playing, so the user can press the currently playing button on the menu.
        isSongPlaying = getIntent().getBooleanExtra("weHaveASongPlaying",false);
        //The boolean form From album_songs_list activity that may have a currently playing song when the AlbumSongsActivity calls this activity(still knowing their is a now playing song.)
        isSongPlaying2 = getIntent().getBooleanExtra("album_songs_activity_song_boolean",false);

        //knowing which album the user is currently looking on, so if the user is trying to return to the AlbumSongsActivity, the button can take them back to the exact album. This is from the AlbumSongsActivity class.
        pickedAlbumyet = getIntent().getBooleanExtra("album_songs_picked_album_boolean",false);

        //Same concept in the above varabile, just this is the curretnly_playing_activity. Again, just to be sure the user can come back to the AlbumSongsActivity to look at songs if they skip over activites..i.e...if a user clicks the menu buttons albums to currently playing, and then back to albums.

        //Essentially, all the booleans allow the three activites to communicate if the user has a currently playing song and navigating the application.
        pickedAlbumyet2 = getIntent().getBooleanExtra("currently_playing_activity_picked_album_boolean",false);



        // Getting views from the XML
        jColeAlbumView = (ImageView) findViewById(R.id.jColeImageView);
        dooWopsAlbumView = (ImageView) findViewById(R.id.brunoMarsImageView);
        loveInTheFutureAlbumView = (ImageView) findViewById(R.id.johnLegendImageView);
        storiesAlbumView = (ImageView) findViewById(R.id.aviciiImageView);

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myChildToolbar);

        // Setting an onClick listener. Also, sending a message of what album was chose to the other activity. At the moment, I did not know how to send an ArrayList<SongsClass> over intents.
        jColeAlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Use the SongsClass in the J Cole Album

                message = "It is J. Cole";

                Intent intent = new Intent(AlbumsActivity.this, AlbumSongsActivity.class);
                intent.putExtra("this", message);
                intent.putExtra("theSongIsPlaying",isSongPlaying);
                intent.putExtra("album_songs_activity_song_boolean",isSongPlaying2);
                startActivity(intent);


            }
        });

        // Setting an onClick listener for the Bruno Mars
        dooWopsAlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Use the SongsClass in the doo Wops Album

                message = "It is Bruno Mars";


                //The putExtras allow the three activities to communicate if a song is currently playing or which album songs are being viewed.
                Intent intent = new Intent(AlbumsActivity.this, AlbumSongsActivity.class);
                intent.putExtra("this", message);
                intent.putExtra("theSongIsPlaying",isSongPlaying);
                intent.putExtra("album_songs_activity_song_boolean",isSongPlaying2);
                startActivity(intent);


            }
        });

        // Setting an onClick listener for the John Legend Album
        loveInTheFutureAlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Use the SongsClass in the John Legend Album

                message = "It is John Legend";

                Intent intent = new Intent(AlbumsActivity.this, AlbumSongsActivity.class);
                intent.putExtra("this", message);
                intent.putExtra("theSongIsPlaying",isSongPlaying);
                intent.putExtra("album_songs_activity_song_boolean",isSongPlaying2);
                startActivity(intent);


            }
        });

        // Setting an onClick listener for the Avicii Album.
        storiesAlbumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Use the SongsClass in the Avicii Album.
                message = "It is Avicii";

                Intent intent = new Intent(AlbumsActivity.this, AlbumSongsActivity.class);
                intent.putExtra("this", message);
                intent.putExtra("theSongIsPlaying",isSongPlaying);
                intent.putExtra("album_songs_activity_song_boolean",isSongPlaying2);
                startActivity(intent);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the currently_playing_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.albums_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            //So, the Extras are set up to be received by the CurrentlyPlayingActivity or AlbumSongsActivity that notifies them if a song is playing or there is an album picked, so the menu buttons work without crashing.
            // Respond when the user wants to go to the currently playing song or album picked song. Did not know about Intent.Flag_Activity_reorder_to_front until this stackOverflowPost : https://stackoverflow.com/questions/12408719/resume-activity-in-android by kingraam
            case R.id.menu_album_activity_layout_album_songs_button:

                //You will see the same concept in the other activites but, if the booleans are false, meaning there isn't a playing song or in this cased an album picked, the user can not brake the app. Otherwise, go to the designated screen.
                if(!pickedAlbumyet2 && !pickedAlbumyet){
                    Toast.makeText(getApplicationContext(),"No album has been chosen",Toast.LENGTH_SHORT).show();
                    return true;
                }else{
                    Intent openActivity= new Intent(AlbumsActivity.this, AlbumSongsActivity.class);
                    getIntent().putExtra("currently_playing_activity_picked_album_boolean",pickedAlbumyet2);
                    openActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivityIfNeeded(openActivity, 0);
                    return true;


                }
            case R.id.menu_albums_activity_layout_currently_playing_button:
                if(!isSongPlaying && !isSongPlaying2){
                    Toast.makeText(getApplicationContext(),"No song has been chosen",Toast.LENGTH_SHORT).show();
                    return true;
                }else{
                    Intent openActivity= new Intent(AlbumsActivity.this, CurrentlyPlayingActivity.class);

                    openActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivityIfNeeded(openActivity, 0);
                    return true;


                }


        }
        return super.onOptionsItemSelected(item);
    }
}
