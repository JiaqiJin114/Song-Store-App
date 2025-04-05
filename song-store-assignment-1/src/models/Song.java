package models;

import java.util.Objects;

public class Song {

    //TODO The song id (int songId) is between 1000 to 9999(both inclusive).  Default is 9999.
    private int songId = 9999;

    //TODO The song name (String name).
    //     Default value is "".
    //     When creating the song, truncate the name to 20 characters.
    //     When updating an existing song, only update the name if it is 20 characters or less.
    private static String name = "";

    //TODO The song's artist (Artist artist)
    //    You should have already written the Artist class
    //     When creating the song, you should have the artist object as a parameter
    private Artist artist = new Artist("", false);

    //TODO The length of the song in seconds (int length) is between 1 and 600. Default is 1.
    private int length = 1;

    //TODO Add the constructor, Song(int, String, Artist), that adheres to the above validation rules
    public Song(int songId, String name, String artistName, boolean verified, int length) {
        this.songId = validateSongId(songId);
        this.name = limitString(name, 20);
        this.artist = new Artist(artistName, verified);
        this.length = validateLength(length);
    }

    private int validateSongId(int songId) {
        if (songId < 1000 || songId > 9999) {
            return 9999;
        }
        return songId;
    }

    private int validateLength(int length) {
        if (length < 1 || length > 600) {
            return 1;
        }
        return length;
    }

    private String limitString(String string, int length){
        if(string == null){
            return "";
        }
        if(string.length() > length){
            return string.substring(0,length);
        }
        return string;
    }

    //TODO Add a getter and setter for each field, that adheres to the above validation rules
    public void setSongId(int songId) {
        this.songId = validateSongId(songId);
    }

    public void setName(String name) {
        this.name = limitString(name, 20);
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setLength(int length) {
        this.length = validateLength(length);
    }

    public Artist getArtist() {
        return artist;
    }

    public int getLength() {
        return length;
    }

    public static String getName() {
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