package com.example.ryan.vibingplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Currently_Playing extends AppCompatActivity {
    Boolean whichImage;
    String artist;
    String song;
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
        albumView = (ImageView)findViewById(R.id.albumCover);
        songView = (TextView) findViewById(R.id.songName);
        artistView = (TextView)findViewById(R.id.artistName);
        backButton = (ImageView)findViewById(R.id.backImageView);
        playButton = (ImageView)findViewById(R.id.playImageView);
        forwardButton = (ImageView)findViewById(R.id.forwardImageView);
        songToDisplay = getIntent().getStringExtra("songTitle");

        albumView.setImageResource(getIntent().getIntExtra("picture",4));
        songView.setText(getIntent().getStringExtra("songTitle"));
        artistView.setText(getIntent().getStringExtra("songArtist"));
        allTheSongs = getIntent().getStringArrayListExtra("allTheSongs");

        currentSong = allTheSongs.indexOf(songToDisplay);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getting the song name of the one before
                if(currentSong == 0){
                    //Do nothing
                    Toast.makeText(Currently_Playing.this, "Can not go back any further",
                            Toast.LENGTH_LONG).show();
                }else{
                    int beforeSong = currentSong - 1;
                    songView.setText(allTheSongs.get(beforeSong));
                    currentSong = beforeSong;

                }



            }
        });

        whichImage = true;

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(whichImage){
                    playButton.setImageResource(R.drawable.pause_button);
                    whichImage = false;
                }else{
                    playButton.setImageResource(R.drawable.play);
                    whichImage = true;
                }

            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentSong == (allTheSongs.size()-1)){
                    //Do nothing
                    Toast.makeText(Currently_Playing.this, "Can not go forward any further",
                            Toast.LENGTH_LONG).show();
                }else{
                    //getting the song name of the one before
                    int forwardSong = currentSong + 1;
                    songView.setText(allTheSongs.get(forwardSong));
                    currentSong = forwardSong;

                }


            }
        });




    }



}
