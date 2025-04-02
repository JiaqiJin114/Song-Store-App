package models;

public class Song {

    //TODO The song id (int songId) is between 1000 to 9999(both inclusive).  Default is 9999.

    //TODO The song name (String name).
    //     Default value is "".
    //     When creating the song, truncate the name to 20 characters.
    //     When updating an existing song, only update the name if it is 20 characters or less.

    //TODO The song's artist (Artist artist)
    //    You should have already written the Artist class
    //     When creating the song, you should have the artist object as a parameter

    //TODO The length of the song in seconds (int length) is between 1 and 600. Default is 1.
    private int songId = 9999;
    private String name = "";
    private Artist artist;
    private int length = 1;

    //TODO Add the constructor, Song(int, String, Artist), that adheres to the above validation rules
    public Song(int songId, String name, Artist artist) {
        this.artist = artist;
        this.name = name;
        this.songId = songId;
    }

    //TODO Add a getter and setter for each field, that adheres to the above validation rules
    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    //TODO Add a generated equals method.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Song song = (Song) o;
        return getSongId() == song.getSongId() && getLength() == song.getLength() && getName().equals(song.getName()) && getArtist().equals(song.getArtist());
    }

    //TODO The toString should return the string containing each of the field values including the use of the artist's toString()
    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", name='" + name + '\'' +
                ", artist=" + artist +
                ", length=" + length +
                '}';
    }
}