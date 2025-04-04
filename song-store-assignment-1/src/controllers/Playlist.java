package controllers;

import models.Artist;
import models.Song;
import utils.ScannerInput;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {

    Scanner sc = new Scanner(System.in);

    //TODO Declare an array list of songs(songs). This should be empty at the start and does not need to be the constructor.
    private ArrayList<Song> Songs = new ArrayList<Song>();// should start empty

    //TODO playlist name (String playlistName) of the playlist in the system in the system is entered by the user.
    //     Default value is "".
    //     When creating the playlist, truncate the name to 20 characters.
    //     When updating an existing playlist, only update the name if it is 20 characters or less.
    private String playlistName = ""; // valid length is 20 - default to the first 20 characters of input.

    //TODO The playlist description (String description) of the playlist in the system is entered by the user.
    //     Default value is "".
    //     When creating the playlist, truncate the description to 30 characters.
    //     When updating an existing playlist, only update the description if it is 30 characters or less.
    private String description = ""; // valid length is 30 - default to the first 30 characters of input.

    //TODO The number of likes a playlist has (int likes)
    //    This should start at 0 and not be part of the constructor
    private int likes = 0;

    //TODO Add the constructor, Playlist(String, String), that adheres to the above validation rules.
    //     The order of the fields in the parameter list is the same as the order of fields above i.e. playlistName is
    //     first, then description.
    public Playlist(String playListName, String description) {
        this.playlistName = limit(playListName, 20);
        this.description = limit(description, 30);
    }

    private String limit(String string, int length){
        if(string == null){
            return "";
        }
        if(string.length() > length){
            return string.substring(0,length);
        }
        return string;
    }

    //TODO Add a getter and setter for each field, that adheres to the above validation rules
    public ArrayList<Song> getSongs() {
        return Songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        Songs = songs;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = limit(playlistName, 20);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = limit(description, 30);
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        while (likes >= 0){
            this.likes = likes;
        }
    }

    //-------------------------------------
    //  ARRAYLIST CRUD
    //-------------------------------------

    //TODO Add a method, addSong(Song). The return type is boolean.
    //     This method will add the song object, passed as a parameter to the arraylist of songs.
    //     If the add was successful, return true, otherwise, return false.
    public boolean addSong(Song song) {
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {

            int songID = ScannerInput.readNextInt("Enter song ID: ");
            String songName = ScannerInput.readNextLine("Enter song name: ");
            String artistName = ScannerInput.readNextLine("Enter artist name: ");
            char ans = ScannerInput.readNextChar("Is this song verified? (y/n): ");
            int lengthOfSong = ScannerInput.readNextInt("Enter length of Song ");

            boolean result = false;
            if ((ans == 'y') || (ans == 'Y')){
                result = true;
            }
            if (result == true){
                Songs.add(new Song(songID, songName, artistName, result, lengthOfSong));
                System.out.println("Song Added Successfully");
                return true;
            }

        }
        return "";
    }


    //TODO Add a method, updateSong(int, Song).  The return type is boolean.
    //     This method takes in, as the first parameter, the index of the songs object that you want to update.
    //     If the index is invalid (i.e. there is no song object at that location), return false.
    //     The other parameter is a  Song object - that is being updated
    //     i.e. it holds the new values of  id, name, length, and artist.
    //     If the update was successful, then return true.
    public boolean updateSong(int songId , Song song) {
        for (int i = 0; i < Songs.size(); i++) {
            if (Songs.get(i).getSongId() == songId) {
                Songs.set(i, song);
                return true;
            }
        }
        return false;
    }

    //TODO Add a method, deleteSong(int).  The return type is Song.
    //     This method takes in the index of the song object that you want to delete.
    //     If the index is invalid (i.e. there is no song object at that location), return null.
    //     If the index is valid, remove the object at that index location.  Return the object you just deleted.
    public Song deleteSong(int index) {
        if (Song.isEmpty()) {
            System.out.println("No Song in the list");
        }else {
            Scanner sc = new Scanner(System.in);
            System.out.print("How many Song do you want to remove?: ");
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                System.out.print("Enter the ID of the song which you want to remove: ");
                int songID = sc.nextInt();
                Song.remove(songID - 1);
            }
        }
        System.out.println("Song Removed Successfully");
        return "";
    }

    //TODO  Add a method  addLike() (no parameter) with return type void.
    //      This method simply adds 1 to the likes variable.
    public void addLike(){
        likes ++;
    }

    //-------------------------------------
    //  ARRAYLIST - Utility methods
    //-------------------------------------

    //TODO Add a method isValidIndex(int) which returns an boolean -
    //      - returns true if the index is valid for the songs arrayList (in range)
    //      - returns false otherwise
    //      As this method is used inside this class, it should be private
    private boolean isValidIndex(int index){
        return (index >= 0) && (index < Songs.size());
    }


    //TODO  Add a method  findSong(int) which returns a Song object:
    //       - if the supplied index is valid, the Song object at that location is returned
    //       - if the supplied index is invalid, null is returned
    //
    private Song findSong(int code) {
        if (Song.isEmpty()) {
            System.out.println("No Song in the list");
        }else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the code of the song you want to search : ");
            code = sc.nextInt();
            for (Song song : Song) {
                if (song.getSongId() == code) {
                    System.out.println(song);
                } else {
                    System.out.println("Song Not Found");
                    break;
                }
            }
        }
        return "";
    }

    //TODO  Add a method  findSong(String) which returns a Song object:
    //       - if the supplied string (songName) matches a song name in the songs list,   the Song object that matches that name  is returned
    //       - if the supplied string (songName) does not match a song name in the songs list, null is returned
    //       NOTE - if that name appears more than once, it is sufficient to return the first occurence.
    public Song findSong(String name) {
        if (Song.isEmpty()) {
            System.out.println("No Song in the list");
        }else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the song you want to search : ");
            String SongName = sc.nextLine();
            for (Song song : Song) {
                if (song.getName().equals(SongName)) {
                    System.out.println(song);
                } else {
                    System.out.println("Song Not Found");
                    break;
                }
            }
        }
        return "";
    }



    //-------------------------------------
    //  ARRAYLIST -  Verified Status Update
    //-------------------------------------

    //TODO Add a method,updateVerifiedStatus(int , boolean ).  The return type is Song.
    //     This method takes in the index of the song object whose artist's verified status
    //     you want to update.
    //     If the index is invalid (i.e. there is no song object at that location), return null.
    //     If the index is valid, retrieve the object and:
    //      set the verified status to the parameter value

    public Song updateVerifiedStatus(int index, boolean verified) {
        if (Song.isEmpty()) {
            System.out.println("No Song in the list");
        }else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the ID of the song which you want to update: ");
            int songID = sc.nextInt();
            for (Song song : Song) {
                if (song.getSongId() == songID) {
                    song.setVerified(verified);
                }
            }
        }
    }



    //-------------------------------------
    //  Counting Methods
    //-------------------------------------

    //TODO Add a method, numberOfSongs().  The return type is int.
    //     This method returns the number of song objects currently stored in the array list.
    public int numberOfSongs() {
        int numberOfSongs = 0;
        for (int i = 0; i < Song.size(); i++) {
            numberOfSongs++;
        }
        return numberOfSongs;
    }


    //TODO Add a method, numberOfShortSongs().  The return type is int.
    //     This method returns the number of song objects in the array list that have a length of <= 180.
    public int SearchShortTimeSong() {
        int numbers = 0 ;
        if (Song.isEmpty()) {
            System.out.println("No Song in the list");
        }else {
            for (Song song : Song) {
                if (song.getLength() <= 180) {
                    numbers++;
                }
            }
        }
        return numbers;
    }


    //TODO Add a method getTotalPlayListLength() which returns a integer value of
    //     the total time (in seconds) if the there are songs in the playlist
    //     -1 if playlist is empty.

    public int getTotalPlayListLength() {
        int totalLength = 0;
        if (Song.isEmpty()) {
            System.out.println("No Song in the list");
        }else {
            for (Song song : Song) {
                totalLength += song.getLength();
            }
        }
        return totalLength;
    }

    //TODO //Add a method getAverageSongLength() which returns a integer value of
    //      the average length of songs on the playlist
    //     -1 if playlist is empty.
    public int getAverageSongLength() {
        int totalLength = 0;
        if (Song.isEmpty()) {
            System.out.println("No Song in the list");
        }else {
            for (Song song : Song) {
                totalLength += song.getLength();
            }
        }
        return totalLength / Song.size();
    }
    

    //------------------------------------
    // LISTING METHODS - Basic and Advanced
    //------------------------------------

    //TODO Add a method, listAllSongs().  The return type is String.
    //     This method returns a list of the songs stored in the array list.
    //     Each song should be on a new line and should be preceded by the index number e.g.
    //        0: song 1 Details
    //        1: song 2 Details
    //    If there are no songs stored in the array list, return a string that contains "No songs in playlist.".
    public String listAllSongs() {
        if (Songs.isEmpty()) {
            System.out.println("No Song in the list");
        }
        for (int i = 0; i < Songs.size(); i++) {
            System.out.println(Songs.get(i));
        }

        return "";
    }


    //TODO Add a method, listSongsFromVerifiedArtists().  The return type is String.
    //     This method returns a list of the songs stored in the array list whose song artist is verified.
    //     Each matching song should be on a new line and should be preceded by the index number e.g.
    //        0: song 1 Details
    //        3: song 4 Details
    //    If there are no such  songs stored in the array list, the return string should
    //    have "No songs in playlist".
    //    If there are songs in the playlist but none with a verified artist, the return string should
    //    have "There are no songs from verified artists on this playlist".
    public String listVerifiedArtistSong() {
        if (Songs.isEmpty()) {
            System.out.println("No Song in the list");
        }else {
            for (Song song : Song) {
                if (song.getArtist().isVerified()) {
                    System.out.println(song);
                }
            }
        }

        return "";
    }



    //TODO Add a method, listSongsLongerThan(int).  The return type is String.
    //    This method returns a list of the songs that are equal or above the length supplied as a parameter.
    //     Each matching song should be on a new line and should be preceded by the index number e.g.
    //        1: song 2 Details
    //        4: song 5 Details
    //    If there are no songs stored in the array list, return a string that contains "No songs in playlist.".
    //    If there are songs in the playlist, but none with songs over (or equal to) this length, then
    //     "There are no songs on this playlist longer than   'length supplied' " should be returned.
    public int SearchLongTimeSong() {
        Scanner sc = new Scanner(System.in);
        int numbers = 0 ;
        if (Songs.isEmpty()) {
            System.out.println("No Song in the list");
        }else {
            System.out.println("Enter the limit of the song length : ");
            int limit = sc.nextInt();
            for (Song song : Songs) {
                if (song.getLength() <= limit) {
                    numbers++;
                }

        }
        return numbers;
    }



    //TODO Add a method, listOfSongsOfArtist(String).  The return type is String.
    //    This method returns a list of all the Songs of an artist (whose name you have supplied as parameter)  across all the song objects
    //    stored in the array list.
    //    Each song should be on a new line and should contain the song name and code too e.g.
    //        1: song 2 Details
    //        4: song 5 Details
    //    If there are no songs stored in the array list, return a string that contains "No songs in playlist".
    //     If there are songs in the playlist, but none by verified artists, then
    //     "There are no  songs on this playlist by   'artist supplied' " should be returned.
    public String listArtistSong() {
        if (Songs.size() == 0) {
            System.out.println("No Song in the list");
        }
        else {
            System.out.print("Enter the name of the Artist who you want to list his or her song : ");
            String ArtistName = sc.next();
            for (Song song : Songs) {
                if (song.getArtist().equals(ArtistName)) {
                    System.out.println(song);
                }
            }
            return "";
        }


    }





//------------------------------
    //  FINDING METHODS
    //-------------------------------

    //TODO Add a method, findSong(int).  The return type is Song.
    //    This method returns the song stored at the index that was passed as a parameter.
    //    However, if the index is not valid, null is returned.
    public String findSong(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the index of the song you want to search : ");
        int songID = sc.nextInt();
        return Song.get(songID-1).getName();
    }


    //TODO Add a method, findSongByCode(int).  The return type is Song.
    //    This method searches the array list for a song with a specific code (passed as a parameter).
    //    When a song is found for this code, it is returned back.
    //    If no song exists for that code, return null.
    // NOTE: the first song encountered is returned, even if more exist with that code.  For extra credit,
    //       you could add in validation to ensure that the code is unique when adding a Song.
    public Song findSongByCode(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the code of the song you want to search : ");
        int songID = sc.nextInt();
        for (int i = 0; i < Songs.size(); i++) {
            Song song = Songs.get(i);
            if(song.getSongId() == songID){
                return song;
            }
        }
        return null;
    }


    //------------------------------
    //  SEARCHING METHODS
    //-------------------------------

    //TODO Add a method, searchSongsByName(String).  The return type is String.
    //    This method returns a list of the songs whose name contains the string passed as a parameter.
    //    Each matching song should be on a new line and should be preceded by the index number e.g.
    //        1: song 2 Details
    //        4: song 5 Details
    //    If there are no songs stored in the array list, return a string that contains "No songs".
    //    If there are no songs whose name contains the supplied string, the return string should
    //    have "No songs found".
    public String searchSongByName(String SongName){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Name of the song you want to search : ");
        String songName = sc.next();
        for (int i = 0; i < Song.size(); i++) {
            Song song = Song.get(i);
            if(song.getName() == songName){
                return songName;
            }
        }
        return"";
    }


    //TODO Add a method, searchSongsByArtistName(String).  The return type is String.
    //    This method returns a list of songs whose artist name contains the string passed
    //    as a parameter.
    //    Each song should be on a new line and should contain the song name and code e.g.
    //        Flowers (45343)
    //        Wrecking Ball (65434)
    //    If there are no songs stored in the array list, return a string that contains "No songs".
    //    If there are no songs whose name contains the supplied string, the return string should
    //    have "No songs found for this artist.
    public String searchSongsByArtistName(String ArtistName) {

        System.out.print("Enter the ArtistName of the song you want to search : ");
        for (int i = 0; i < Songs.size(); i++) {
            if (SongS.get(i).getName() == ArtistName) {
                return Songs.get(i).toString();
                break;
            }
        }return"";
    }




    //-------------------------
    // HELPER METHODS
    //-------------------------

    //TODO Add a method, isValidIndex(int).  The return type is boolean.
    //    This method returns true if the value passed as a parameter is a valid index in the arraylist.
    //    However, if the index is not valid, false is returned.


        private boolean isValidIndex(int index) {
            if (index >= 0 && index < Songs.size()) {
                return true;
            } else {
                return false;
            }
        }

        private Song findSong(int code) {
            for (Song song : Songs) {
                if (song.getSongId() == code) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(String name) {
            for (Song song : Songs) {
                if (song.getName().equals(name)) {
                    return song;
                }
            }
            return null;
        }


        public String listSong() {
            if (Songs.isEmpty()) {
                return "No songs in the playlist";
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < Songs.size(); i++) {
                    sb.append(i + 1).append(": ").append(Songs.get(i).getName()).append("\n");
                }
                return sb.toString();
            }
        }
    }

}
