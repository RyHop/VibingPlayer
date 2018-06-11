package com.example.ryan.vibingplayer;

public class songs {
   private String songtitle;
   private String artist;
   private int albumCover;
    public songs(String title, String artistOfSong, int picture){
        songtitle = title;
        artist = artistOfSong;
        albumCover = picture;

    }
    public String getSongtitle(){
        return songtitle;
    }
    public String getArtist(){
        return artist;
    }
    public int getAlbumCover(){
        return albumCover;
    }
}
