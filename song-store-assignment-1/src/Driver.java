import controllers.Playlist;
import models.Song;

import java.util.Scanner;

public class Driver {

    //TODO Define an object of the Playlist here.  It should be declared private.
    private Playlist playlist;

    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.runMenu();
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
    private  int mainMenu() {
        Scanner sc = new Scanner(System.in);
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
        int option = sc.nextInt();
        System.out.println("---------------------------------------");
        return option;
    }

    private void printAverageLength(){

    }
    private void printLengthOfPlaylist(){

    }
    private void runMenu() {
        Scanner sc= new Scanner(System.in);
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> addSong();
                case 2 -> listMenu();
                case 3 -> searchMenu();
                case 4 -> removeMenu();
                case 5 -> updateSong();
                default -> System.out.println("Invalid option entered: " + option) ;
            }

            System.out.print("\nPress enter key to continue...");
            sc.nextLine();
            option = mainMenu();
        }

        System.out.println("Exiting...bye");
        System.exit(0);
    }

    private void save(){

    }

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


    private  void listMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
        List methods
        1)  listsong
        2)  listVerifiedArtistSong
        3)  listArtistSong
        0)  Exit
        ==>> """);
        System.out.print("Please enter your choice : ");
        int option = sc.nextInt();
        while (option != 0) {
            switch (option) {
                case 1 -> listAllSongs();
                case 2 -> listSongsOfGivenArtist();
                case 3 -> listSongsByVerifiedArtists();
                case 0 -> runMenu();
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("---------------------------------------");
            Driver driver = new Driver();
            driver.runMenu();
        }
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

    //------------------------------------
    // Private methods for CRUD on Song
    //------------------------------------

    private void deleteSong() {
        System.out.println(playlist.removeSong());
    }


    private void listAllSongs(){
        System.out.println(playlist.listSong());
    }


    private void listSongsOfGivenArtist(){
        System.out.println(playlist.listVerifiedArtistSong());

    }
    private void listSongsByVerifiedArtists(){
        System.out.println(playlist.listArtistSong());
    }


    //-----------------------------------------------------------------
    //  Private methods for Search facility
    //-----------------------------------------------------------------

   private void findSongById() {}



    //-----------------------------
    //  Private methods for Reports
    // ----------------------------


    //---------------------------------
    //  Private methods for Persistence
    // --------------------------------
    private void listSongsOverGivenLength(){

    }

    private void searchSongByName(){

    }

    private void load(){

    }

    //TODO Add a method, load().  The return type is void.
    //    This method uses the XStream component to deserialise the playList object and their associated artists from
    //    an XML file into the Songs array list.


    //TODO Add a method, save().  The return type is void.
    //    This method uses the XStream component to serialise the playList object and their associated artists to
    //    an XML file.
}