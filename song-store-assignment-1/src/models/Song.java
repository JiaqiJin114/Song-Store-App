package models;

import java.util.Objects;

public class Song {

    //TODO The song id (int songId) is between 1000 to 9999(both inclusive).  Default is 9999.
    private int songId = 9999;

    //TODO The song name (String name).
    //     Default value is "".
    //     When creating the song, truncate the name to 20 characters.
    //     When updating an existing song, only update the name if it is 20 characters or less.
    private String name = "";

    //TODO The song's artist (Artist artist)
    //    You should have already written the Artist class
    //     When creating the song, you should have the artist object as a parameter
    private Artist artist;

    //TODO The length of the song in seconds (int length) is between 1 and 600. Default is 1.
    private int length = 1;


    //TODO Add the constructor, Song(int, String, Artist), that adheres to the above validation rules
    public Song(int songId, String name, Artist artist) {
        while (songId >= 1000 && songId <= 9999){
            this.songId = songId;
        }

        while (name.length() <= 20){
            this.name = name;
        }

        this.artist = artist;
    }

    public Song() {}


    //TODO Add a getter and setter for each field, that adheres to the above validation rules
    public void setSongId(int songId) {
        this.songId = songId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setLength(int length) {
        while (length > 1 && length < 600){
            this.length = length;
        }
    }

    public Artist getArtist() {
        return artist;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

    public int getSongId() {
        return songId;
    }


    //TODO Add a generated equals method.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return getSongId() == song.getSongId() && getLength() == song.getLength() && Objects.equals(getName(), song.getName()) && Objects.equals(getArtist(), song.getArtist());
    }


    @Override
    public String toString() {
        return "Song{" +
                "artist=" + artist +
                ", songId=" + songId +
                ", name='" + name + '\'' +
                ", length=" + length +
                '}';
    }
}