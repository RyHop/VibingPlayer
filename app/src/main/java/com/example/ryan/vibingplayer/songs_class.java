package com.example.ryan.vibingplayer;

public class songs_class {
    //Initializing all variables

    private String songtitle;
    private String artist;
    private int albumCover;

    //the songs_class class is needed because songs_class are better represented if it was an object.
    public songs_class(String title, String artistOfSong, int picture) {
        //The constructor for songs_class class. Needs three attributes to be classified as a song.
        songtitle = title;
        artist = artistOfSong;
        albumCover = picture;

    }

    // The below getter methods are there because some functions need to get information from songs_class.
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
