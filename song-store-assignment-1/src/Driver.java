import com.thoughtworks.xstream.io.xml.StaxDriver;
import controllers.Playlist;
import models.Song;
import utils.ScannerInput;
import com.thoughtworks.xstream.XStream;

import java.io.*;

import java.util.Scanner;

public class Driver {
    Scanner sc= new Scanner(System.in);

    //TODO Define an object of the Playlist here.  It should be declared private.
    private Playlist playlist;

    public static void main(String[] args) {
        new Driver();
    }

    public Driver(){
        runMenu();
    }

    //TODO Refer to the tutors instructions for building this class and for the menu.  You are free to deviate in any way
    //     from the Driver menu that is in the tutors instructions, once you have these included:
    //     (with tests still compiling)
    //       - CRUD on Playlist
    //       - Search facility (for Songs)
    //       - Reports
    //       - Persistence
    // Note:  This is the ONLY class that can talk to the user i.e. have System.out.print and Scanner reads in it.

    //----------------------------------------------------------------------------
    // Private methods for displaying the menu and processing the selected options
    //----------------------------------------------------------------------------
    private int mainMenu() {
        System.out.print("""
                ---------------------------------------------------------------------
                |                             SONGS APP                             |
                ---------------------------------------------------------------------
                |  Song MENU                                                        |
                |   1) Add a Song                                                   |
                |   2) List all Songs                                               |
                |   3) Update a Song                                                |
                |   4) Delete a Song                                                |
                |   5) Set verified status of a specific song's artist              |
                |   6) Find a specific Song (by code)                               |
                |   7) Search for a specific Song (by name)                         |
                |   8) Add a like to playlist                                       |
                ---------------------------------------------------------------------
                |  REPORT MENU                                                      |
                ---------------------------------------------------------------------
                |   9) List all Songs by verified artists                           |
                |   10) List all Songs over a given length                          |
                |   11) List all Songs by a given artist                            |
                |   12) Print the average length of songs in the playlist           |
                |   13) Print the total length of songs in the playlist             |
                ---------------------------------------------------------------------
                |  SETTINGS MENU                                                    |
                ---------------------------------------------------------------------
                |   20) Save                                                        |
                |   21) Load                                                        |
                |   0) Exit                                                         |
                ---------------------------------------------------------------------
                ==>>
        ==>> """);
        System.out.print("Please enter your choice : ");
        return sc.nextInt();
    }

    private void runMenu() {
        mainMenu();
        if(mainMenu() != 0) {
            switch (mainMenu()) {
                case 1 -> addSong();
                case 2 -> listAllSongs();
                case 3 -> updateSong();
                case 4 -> deleteSong();
                case 5 -> setVerifiedStatus();
                case 6 -> findSongById();
                case 7 -> searchSongByName();
                case 8 -> addLikeToPlaylist();
                case 9 -> listSongsByVerifiedArtists();
                case 10 -> listSongsOverGivenLength();
                case 11 -> listSongsOfGivenArtist();
                case 12 -> printAverageLength();
                case 13 -> printLengthOfPlaylist();
                case 20 -> save();
                case 21 -> load();
            }
            System.out.print("\nPress enter key to continue...");
        }else {
        System.out.println("Exiting...bye");
        }
    }


    //------------------------------------
    // Private methods for CRUD on Song
    //------------------------------------

    private void addSong() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
        Add methods
        1)  addtsong
        0)  Exit
        ==>> """);
        System.out.print("Please enter your choice : ");
        int option = sc.nextInt();
        while (option != 0) {
            switch (option) {
                case 1 -> addSong();
                case 0 -> runMenu();
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("---------------------------------------");
            Driver driver = new Driver();
            driver.runMenu();
        }
    }

    private void listAllSongs(){
       playlist.listAllSongs();
    }


    private void updateSong() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
        Remove methods
        1)  updateSong
        0)  Exit
        ==>> """);
        System.out.print("Please enter your choice : ");
        int option = sc.nextInt();
        while (option != 0) {
            switch (option) {
                case 1 -> updateSong();
                case 0 -> runMenu();
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("---------------------------------------");
            Driver driver = new Driver();
            driver.runMenu();
        }
    }

    private void deleteSong() {
        listAllSongs();
        int index = ScannerInput.readNextInt("Enter the index of the song you want to delete");
        playlist.deleteSong(index);
    }

    private void addLikeToPlaylist(){
        System.out.println("Adding a like to the playlist");
        playlist.addLike();
    }

    private void setVerifiedStatus(){
        System.out.println("Setting verified status of a specific song's artist");
        System.out.println("Enter the index of the song you want to update");
        int index = ScannerInput.readNextInt("Enter the index of the song you want to update");
        playlist.updateVerifiedStatus(index, true);
        System.out.println("Verified status updated successfully");
    }

    //-----------------------------------------------------------------
    //  Private methods for Search facility
    //-----------------------------------------------------------------


    private void findSongById() {
        System.out.println("Finding a song by ID");
        System.out.println("Enter the ID of the song you want to find");
        int id = ScannerInput.readNextInt("Enter the ID of the song you want to find");
        Song song = playlist.findSong(id);
        if (song != null) {
            System.out.println("Song found: " + song.getName());
        } else {
            System.out.println("Song not found");
        }
    }

    private void searchSongByName(){
        System.out.println("Searching for a song by name");
        System.out.println("Enter the name of the song you want to search");
        String name = ScannerInput.readNextLine("Enter the name of the song you want to search");
        Song song = playlist.findSong(name);
        if (song != null) {
            System.out.println("Song found: " + song.getName());
        } else {
            System.out.println("Song not found");
        }
    }

    //-----------------------------
    //  Private methods for Reports
    // ----------------------------

    private void listSongsOfGivenArtist(){
        System.out.println("Listing songs of a given artist");
        System.out.println("Enter the name of the artist you want to search");
        String artistName = ScannerInput.readNextLine("Enter the name of the artist you want to search");
        System.out.println(playlist.listOfSongsOfArtist());
        if (artistName.equals(artistName)){
            System.out.println("Song found: " + artistName);
        } else {
            System.out.println("Song not found");
        }
    }

    private void listSongsByVerifiedArtists(){
        System.out.println("Listing songs of verified artists");
        System.out.println(playlist.listVerifiedArtistSong());
    }

    private void listSongsOverGivenLength(){
        System.out.println("Listing songs over a given length");
        System.out.println("Enter the length of the song you want to search");
        int length = ScannerInput.readNextInt("Enter the length of the song you want to search");
        System.out.println(playlist.SearchLongTimeSong());
        if (length > 0){
            System.out.println("Song found: " + length);
        } else {
            System.out.println("Song not found");
        }
    }

    private void printAverageLength(){
        System.out.println("Printing average length of songs");
        System.out.println(playlist.getAverageSongLength());
    }

    private void printLengthOfPlaylist(){
        System.out.println("Printing length of playlist");
        System.out.println(playlist.getTotalPlayListLength());
        if (playlist.getTotalPlayListLength() > 0){
            System.out.println("Playlist found: " + playlist.getTotalPlayListLength());
        } else {
            System.out.println("Playlist not found");
        }
    }

    //---------------------------------
    //  Private methods for Persistence
    // --------------------------------

    //TODO Add a method, load().  The return type is void.
    //    This method uses the XStream component to deserialise the playList object and their associated artists from
    //    an XML file into the Songs array list.
    private void load(){

        try {
            XStream xstream = new XStream(new StaxDriver());
            FileInputStream fis = new FileInputStream("playlist.xml");
            ObjectInputStream is = xstream.createObjectInputStream(fis);
            playlist = (Playlist) is.readObject();
            is.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Playlist loaded successfully");
    }


    //TODO Add a method, save().  The return type is void.
    //    This method uses the XStream component to serialise the playList object and their associated artists to
    //    an XML file.
    private void save(){
        try {
            XStream xstream = new XStream(new StaxDriver());
            FileOutputStream fos = new FileOutputStream("playlist.xml");
            ObjectOutputStream out = xstream.createObjectOutputStream(fos);
            out.writeObject(playlist);
            out.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Playlist saved successfully");
    }
}