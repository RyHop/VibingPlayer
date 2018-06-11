package com.example.ryan.vibingplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class albumSongs extends AppCompatActivity {

    //Initializing all variables
    String message;
    ArrayList<String> songNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_songs);


        // The arrayList needed for the arrayAdapter for populating the views.
        final ArrayList<songs> songsList = new ArrayList<>();

        //The message variable lets us know which album is it. The following if-statments add the correct songs based on the choice.
        message = getIntent().getStringExtra("this");

        if (message.equals("It is J. Cole")) {
            songsList.add(new songs("intro", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("KOD", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("Photograph", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("The Cut Off", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("ATM", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("Motiv8", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("Kevin's Heart", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("BRACKETS", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("Once an Addict", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("FRIENDS", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("Window Pain", "J. Cole", R.drawable.kod_album_cover));
            songsList.add(new songs("1985", "J. Cole", R.drawable.kod_album_cover));

        }

        if (message.equals("It is Bruno Mars")) {
            songsList.add(new songs("Grenade", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsList.add(new songs("Just the Way You Are", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsList.add(new songs("Our First Time", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsList.add(new songs("Runaway Baby", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsList.add(new songs("The Lazy Song", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsList.add(new songs("Marry you", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsList.add(new songs("Talking to the Moon", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsList.add(new songs("Liquor Store Blues", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsList.add(new songs("Count on Me", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));
            songsList.add(new songs("The Other Side", "Bruno Mars", R.drawable.doowops_hooligans_album_cover));


        }
        if (message.equals("It is John Legend")) {
            songsList.add(new songs("Love In The Futurue (Intro)", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("The Beginning...", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Open Your Eyes", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Made to Love", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Who Do We Think We Are", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("All of Me", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Hold On Longer", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Save The Night", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Tomorrow", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("What If I Told You? (Interlude)", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Dreams", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Wanna Be Loved", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Angel", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("You & I", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Asylum", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Caught Up", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("So Gone", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("We Loved It", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("Aim High", "John Legend", R.drawable.love_in_the_future_album_cover));
            songsList.add(new songs("For the First Time", "John Legend", R.drawable.love_in_the_future_album_cover));


        }
        if (message.equals("It is Avicii")) {
            songsList.add(new songs("Waiting for Love", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("Talk to Myself", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("Touch Me", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("Ten More Days", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("For a Better Day", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("Broken Arrows", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("True Believer", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("City Lights", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("Pure Grinding", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("Sunset Jesus", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("Can't Catch Me", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("Somewhere in Stockholm", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("Trouble", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("Gonna Love Ya", "Avicii", R.drawable.stories_album_cover));
            songsList.add(new songs("The Nights", "Avicii", R.drawable.stories_album_cover));


        }

        // Since I can not pass songs objects over intents, I will just get the title of each song in the array for the Currently Playing activity.

        for (int i = 0; i < songsList.size(); i++) {
            songs currentSong = songsList.get(i);
            String songTitle = currentSong.getSongtitle();
            songNames.add(i, songTitle);


        }

        // Creating an OnClickListenerfor my AdapterView (ListView) Found this on the Android Website https://developer.android.com/reference/android/widget/AdapterView.OnItemClickListener.
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // Do something in response to the click

                // Get the current song. Getting it's data and passing it into the currently Playing activity. Because when the user clicks a song, info should show up.
                songs apple = songsList.get(position);
                String songTitle = apple.getSongtitle();
                String songArtist = apple.getArtist();
                int album_cover = apple.getAlbumCover();
                Intent intent = new Intent(albumSongs.this, Currently_Playing.class);
                intent.putExtra("songTitle", songTitle);
                intent.putExtra("songArtist", songArtist);
                intent.putExtra("picture", album_cover);
                intent.putExtra("allTheSongs", songNames);
                startActivity(intent);


            }

        };

        //Creating and setting the listView, custom SongAdapter

        SongAdapter itemsAdapter = new SongAdapter(this, songsList);
        ListView listView = (ListView) findViewById(R.id.default_listView);

        //Setting the adapter and the onClickListener
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(mMessageClickedHandler);


    }

}
