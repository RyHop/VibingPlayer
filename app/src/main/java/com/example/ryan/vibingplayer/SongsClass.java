package com.example.ryan.vibingplayer;

public class SongsClass {
    //Initializing all variables

    private String songtitle;
    private String artist;
    private int albumCover;

    //the SongsClass class is needed because SongsClass are better represented if it was an object.
    public SongsClass(String title, String artistOfSong, int picture) {
        //The constructor for SongsClass class. Needs three attributes to be classified as a song.
        songtitle = title;
        artist = artistOfSong;
        albumCover = picture;

    }

    // The below getter methods are there because some functions need to get information from SongsClass.
    public String getSongtitle() {
        return songtitle;
    }

    public String getArtist() {
        return artist;
    }

    public int getAlbumCover() {
        return albumCover;
    }
}
