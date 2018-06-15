package com.example.ryan.vibingplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AlbumSongsActivity extends AppCompatActivity {

    //Initializing all variables
    public String message;
    boolean checkPlayingSong;
    boolean checkPlayingSong2;
    boolean checkPlayingSong3;
    boolean pickedAnAlbum;
    ArrayList<String> songNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_album_songs);

        //This screen ensures the an album is picked. SO, the user can navigate the app, and the app knows where the user left out.
        pickedAnAlbum = true;



        // The arrayList needed for the arrayAdapter for populating the views.
        final ArrayList<SongsClass> songsClassList = new ArrayList<>();

        //The message variable lets us know which album is it. The following if-statments add the correct SongsClass based on the choice.
        message = getIntent().getStringExtra("this");

        //From the album_class that originates in the CurrentlyPlayingActivity
        checkPlayingSong = getIntent().getBooleanExtra("weHaveASongPlaying",false);

        //From album_activity class
        checkPlayingSong2 = getIntent().getBooleanExtra("theSongIsPlaying",false);
        //From the CurrentlyPlayingActivity class
        checkPlayingSong3 = getIntent().getBooleanExtra("currently_playing_activity_picked_album_boolean",false);


        if (message.equals("It is J. Cole")) {
            songsClassList.add(new SongsClass("intro", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("KOD", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("Photograph", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("The Cut Off", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("ATM", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("Motiv8", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("Kevin's Heart", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("BRACKETS", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("Once an Addict", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("FRIENDS", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("Window Pain", "J. Cole", R.drawable.kod_album_cover));
            songsClassList.add(new SongsClass("1985", "J. Cole", R.drawable.kod_album_cover));

        }

        if (message.equals("It is Bruno Mars")) {
            songsClassList.add(new SongsClass("Grenade", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsClassList.add(new SongsClass("Just the Way You Are", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsClassList.add(new SongsClass("Our First Time", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsClassList.add(new SongsClass("Runaway Baby", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsClassList.add(new SongsClass("The Lazy Song", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsClassList.add(new SongsClass("Marry you", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsClassList.add(new SongsClass("Talking to the Moon", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsClassList.add(new SongsClass("Liquor Store Blues", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsClassList.add(new SongsClass("Count on Me", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsClassList.add(new SongsClass("The Other Side", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));


        }
        if (message.equals("It is John Legend")) {
            songsClassList.add(new SongsClass("Love In The Futurue (Intro)", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("The Beginning...", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Open Your Eyes", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Made to Love", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Who Do We Think We Are", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("All of Me", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Hold On Longer", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Save The Night", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Tomorrow", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("What If I Told You? (Interlude)", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Dreams", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Wanna Be Loved", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Angel", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("You & I", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Asylum", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Caught Up", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("So Gone", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("We Loved It", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("Aim High", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsClassList.add(new SongsClass("For the First Time", "John Legend", R.drawable.love_in_the_future_album_cover));


        }
        if (message.equals("It is Avicii")) {
            songsClassList.add(new SongsClass("Waiting for Love", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("Talk to Myself", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("Touch Me", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("Ten More Days", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("For a Better Day", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("Broken Arrows", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("True Believer", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("City Lights", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("Pure Grinding", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("Sunset Jesus", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("Can't Catch Me", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("Somewhere in Stockholm", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("Trouble", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("Gonna Love Ya", "Avicii", R.drawable.stories_album_cover));
            songsClassList.add(new SongsClass("The Nights", "Avicii", R.drawable.stories_album_cover));


        }

        // Since I can not pass SongsClass objects over intents, I will just get the title of each song in the array for the Currently Playing activity.

        for (int i = 0; i < songsClassList.size(); i++) {
            SongsClass currentSong = songsClassList.get(i);
            String songTitle = currentSong.getSongtitle();
            songNames.add(i, songTitle);


        }

        // Creating an OnClickListenerfor my AdapterView (ListView) Found this on the Android Website https://developer.android.com/reference/android/widget/AdapterView.OnItemClickListener.
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Do something in response to the click

                // Get the current song. Getting it's data and passing it into the currently Playing activity. Because when the user clicks a song, info should show up. Also, the boolean pickedAnAlbum allows the users to use the menu buttons to navigate the app after the user picks an album (so the app won't crash).
                SongsClass apple = songsClassList.get(position);
                String songTitle = apple.getSongtitle();
                String songArtist = apple.getArtist();
                int album_cover = apple.getAlbumCover();
                Intent intent = new Intent(AlbumSongsActivity.this, CurrentlyPlayingActivity.class);
                intent.putExtra("songTitle", songTitle);
                intent.putExtra("songArtist", songArtist);
                intent.putExtra("picture", album_cover);
                intent.putExtra("allTheSongs", songNames);
                intent.putExtra("theMessage",message);
                intent.putExtra("album_songs_picked_album_boolean",pickedAnAlbum);
                startActivity(intent);


            }

        };

        //Creating and setting the listView, custom CustomSongAdapter

        CustomSongAdapter itemsAdapter = new CustomSongAdapter(this, songsClassList);
        ListView listView = (ListView) findViewById(R.id.default_listView);

        //Setting the adapter and the onClickListener
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(mMessageClickedHandler);

        // my_child_toolbar is defined in the layout file
        Toolbar myChildToolbar =
                (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myChildToolbar);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the currently_playing_menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_view_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_albums_button:

                //So, the Extras are set up to be received by the CurrentlyPlayingActivity or AlbumSongsActivity that notifies them if a song is playing or there is an album picked, so the menu buttons work without crashing.
                Intent intent = new Intent(AlbumSongsActivity.this,AlbumsActivity.class);
                intent.putExtra("album_songs_activity_song_boolean",checkPlayingSong2);
                intent.putExtra("album_songs_picked_album_boolean",pickedAnAlbum);
                startActivity(intent);


                return true;
            // Respond when the user wants to go to the currently playing song. Did not know about Intent.Flag_Activity_reorder_to_front until this stackOverflowPost : https://stackoverflow.com/questions/12408719/resume-activity-in-android by kingraam
            case R.id.menu_currently_playing_button:

                if(!checkPlayingSong && !checkPlayingSong2 && !checkPlayingSong3){
                    Toast.makeText(getApplicationContext(),"No song has been chosen",Toast.LENGTH_SHORT).show();
                    return true;
                }else{
                    Intent openActivity= new Intent(AlbumSongsActivity.this, CurrentlyPlayingActivity.class);
                    openActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivityIfNeeded(openActivity, 0);
                    return true;


                }




        }
        return super.onOptionsItemSelected(item);
    }

}
