package controllers;

import models.Artist;
import models.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class Playlist {
    private String playlistName; // valid length is 20 - default to the first 20 characters of input.
    private ArrayList<Song> songs = new ArrayList<Song>();// should start empty
    private String description; // valid length is 30 - default to the first 30 characters of input.

    private int likes = 0;

    //TODO Declare an array list of songs(songs). This should be empty at the start and does not need to be the constructor.
    static ArrayList<Song> Song = new ArrayList<>();

    //TODO playlist name (String playlistName) of the playlist in the system in the system is entered by the user.
    //     Default value is "".
    //     When creating the playlist, truncate the name to 20 characters.
    //     When updating an existing playlist, only update the name if it is 20 characters or less.




    //TODO The playlist description (String description) of the playlist in the system is entered by the user.
    //     Default value is "".
    //     When creating the playlist, truncate the description to 30 characters.
    //     When updating an existing playlist, only update the description if it is 30 characters or less.

    //TODO The number of likes a playlist has (int likes)
    //    This should start at 0 and not be part of the constructor



    //TODO Add the constructor, Playlist(String, String), that adheres to the above validation rules.
    //     The order of the fields in the parameter list is the same as the order of fields above i.e. playlistName is
    //     first, then description.

    //TODO Add a getter and setter for each field, that adheres to the above validation rules

    //-------------------------------------
    //  ARRAYLIST CRUD
    //-------------------------------------

    //TODO Add a method, addSong(Song). The return type is boolean.
    //     This method will add the song object, passed as a parameter to the arraylist of songs.
    //     If the add was successful, return true, otherwise, return false.
    public static String addSong() {

        Scanner sc = new Scanner(System.in);
        System.out.print("How many Song do you want to add?: ");
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            System.out.print("Enter Song ID: ");
            int songID = sc.nextInt();
            System.out.print("Enter Song Name: ");
            String SongName = sc.next();
            System.out.print("Enter Artist Name: ");
            String ArtistName = sc.next();
            System.out.print("Is this Song Verified? (y/n): ");
            char ans = sc.next().charAt(0);
            boolean result = false;
            if ((ans == 'y') || (ans == 'Y'))
                result = true;
            boolean VerifiedArtist = result;
            ArrayList<Artist> artists = new ArrayList<>();
            Artist artist = new Artist(ArtistName,VerifiedArtist);
            artists.add(artist);
            System.out.print("Enter length of Song ");
            int lengthOfSong = sc.nextInt();
            Song s =new Song(songID,SongName,artist);
            Song.add(s);
            System.out.println("Song Added Successfully");
        }
        return "";
    }


    //TODO Add a method, updateSong(int, Song).  The return type is boolean.
    //     This method takes in, as the first parameter, the index of the songs object that you want to update.
    //     If the index is invalid (i.e. there is no song object at that location), return false.
    //     The other parameter is a  Song object - that is being updated
    //     i.e. it holds the new values of  id, name, length, and artist.
    //     If the update was successful, then return true.
    public static  boolean updateSong(int songId , Song song) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the index of song you want to update?: ");
        int songIndex = sc.nextInt();
        for (int i = 0; i < Song.size(); i++) {
            if (Song.get(i).getSongId() == songId) {
                Song.set(i, song);
                return true;
            }
        }
        return false;
    }



    //TODO Add a method, deleteSong(int).  The return type is Song.
    //     This method takes in the index of the song object that you want to delete.
    //     If the index is invalid (i.e. there is no song object at that location), return null.
    //     If the index is valid, remove the object at that index location.  Return the object you just deleted.
    public static String removeSong() {
        if (Song.size() == 0) {
            System.out.println("No Song in the list");
        }
        if (Song.size() != 0) {
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

    //-------------------------------------
    //  ARRAYLIST - Utility methods
    //-------------------------------------

    //TODO Add a method isValidIndex(int) which returns an boolean -
    //      - returns true if the index is valid for the songs arrayList (in range)
    //      - returns false otherwise
    //      As this method is used inside this class, it should be private


    //TODO  Add a method  findSong(int) which returns a Song object:
    //       - if the supplied index is valid, the Song object at that location is returned
    //       - if the supplied index is invalid, null is returned
    //
    public static String findSongint() {
        if (Song.size() == 0) {
            System.out.println("No Song in the list");
        }
        if (Song.size() != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the song you want to search : ");
            String SongName = sc.nextLine();
            for (int i = 0; i < Song.size(); i++) {
                if (Song.get(i).getName().equals(SongName)) {
                    System.out.println(Song.get(i));
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
    public static String searchSong() {
        if (Song.size() == 0) {
            System.out.println("No Song in the list");
        }
        if (Song.size() != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the song you want to search : ");
            String SongName = sc.nextLine();
            for (int i = 0; i < Song.size(); i++) {
                if (Song.get(i).getName().equals(SongName)) {
                    System.out.println(Song.get(i));
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



    //-------------------------------------
    //  Counting Methods
    //-------------------------------------

    //TODO Add a method, numberOfSongs().  The return type is int.
    //     This method returns the number of song objects currently stored in the array list.
    public static int numberOfSongs() {
        int numberOfSongs = 0;
        for (int i = 0; i < Song.size(); i++) {
            numberOfSongs++;
        }
        return numberOfSongs;
    }


    //TODO Add a method, numberOfShortSongs().  The return type is int.
    //     This method returns the number of song objects in the array list that have a length of <= 180.
    public static int SearchShortTimeSong() {
        int numbers = 0 ;
        if (Song.size() == 0) {
            System.out.println("No Song in the list");
        }
        if (Song.size() != 0) {
            for (int i = 0; i < Song.size(); i++) {
                Song song = Song.get(i);
                if (song.getLength() <= 180 ) {
                   numbers++;
                }
            }
        }
        return numbers;
    }


    //TODO Add a method getTotalPlayListLength() which returns a integer value of
    //     the total time (in seconds) if the there are songs in the playlist
    //     -1 if playlist is empty.

    //TODO Add a method getAverageSongLength() which returns a integer value of
    //      the average length of songs on the playlist
    //     -1 if playlist is empty.

    //------------------------------------
    // LISTING METHODS - Basic and Advanced
    //------------------------------------

    //TODO Add a method, listAllSongs().  The return type is String.
    //     This method returns a list of the songs stored in the array list.
    //     Each song should be on a new line and should be preceded by the index number e.g.
    //        0: song 1 Details
    //        1: song 2 Details
    //    If there are no songs stored in the array list, return a string that contains "No songs in playlist.".
    public static String listSong() {
        if (Song.isEmpty()) {
            System.out.println("No Song in the list");
        }
        for (int i = 0; i < Song.size(); i++) {
            System.out.println(Song.get(i));
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
    public static String listVerifiedArtistSong() {
        if (Song.size() == 0) {
            System.out.println("No Song in the list");
        }
        if (Song.size() != 0) {
            for (int i = 0; i < Song.size(); i++) {
                Song song = Song.get(i);
                if (song.getArtist().isVerified()) {
                    System.out.println(Song.get(i));
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
    public static int SearchLongTimeSong() {
        Scanner sc = new Scanner(System.in);
        int numbers = 0 ;
        if (Song.size() == 0) {
            System.out.println("No Song in the list");
        }
        if (Song.size() != 0) {
            System.out.println("Enter the limit of the song length : ");
            int limit = sc.nextInt();
            for (int i = 0; i < Song.size(); i++) {
                Song song = Song.get(i);
                if (song.getLength() <= limit ) {
                    numbers++;
                }
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
    public static String listArtistSong() {
        if (Song.size() == 0) {
            System.out.println("No Song in the list");
        }
        if (Song.size() != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the Artist who you want to list his or her song : ");
            String ArtistName = sc.next();
            for (int i = 0; i < Song.size(); i++) {
                if (Song.get(i).getArtist().equals(ArtistName)) {
                    System.out.println(Song.get(i));
                }
            }
        }
        return "";
    }





//------------------------------
    //  FINDING METHODS
    //-------------------------------

    //TODO Add a method, findSong(int).  The return type is Song.
    //    This method returns the song stored at the index that was passed as a parameter.
    //    However, if the index is not valid, null is returned.
public static String findSong(){
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
public static Song findSongByCode(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the code of the song you want to search : ");
        int songID = sc.nextInt();
        for (int i = 0; i < Song.size(); i++) {
            Song song = Song.get(i);
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
    public static String searchSongByName(String SongName){
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




    //-------------------------
    // HELPER METHODS
    //-------------------------

    //TODO Add a method, isValidIndex(int).  The return type is boolean.
    //    This method returns true if the value passed as a parameter is a valid index in the arraylist.
    //    However, if the index is not valid, false is returned.


}
