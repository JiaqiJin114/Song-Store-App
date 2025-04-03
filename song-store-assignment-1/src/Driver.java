import controllers.Playlist;
import models.Song;

import java.util.Scanner;

import static controllers.Playlist.*;

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
        Song Store App
        1)  add Method
        2)  list Method
        3)  search Method
        4)  remove Method
        5)  update Method
        0)  Exit
        ==>> """);
        System.out.print("Please enter your choice : ");
        int option = sc.nextInt();
        System.out.println("---------------------------------------");
        return option;
    }
    private void runMenu() {
        Scanner sc= new Scanner(System.in);
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1 -> addMenu();
                case 2 -> listMenu();
                case 3 -> searchMenu();
                case 4 -> removeMenu();
                case 5 -> updateMenu();
                default -> System.out.println("Invalid option entered: " + option) ;
            }

            System.out.print("\nPress enter key to continue...");
            sc.nextLine();
            option = mainMenu();
        }

        System.out.println("Exiting...bye");
        System.exit(0);
    }

    private void addMenu() {
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
                case 1 -> listSong();
                case 2 -> listVerifiedArtistSong();
                case 3 -> listArtistSong();
                case 0 -> runMenu();
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("---------------------------------------");
            Driver driver = new Driver();
            driver.runMenu();
        }
    }
    private  void searchMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
        Search methods
        1)  searchSong
        2)  SearchLongTimeSong
        0)  Exit
        ==>> """);
        System.out.print("Please enter your choice : ");
        int option = sc.nextInt();
        while (option != 0) {
            switch (option) {
                case 1 -> searchSong();
                case 2 -> SearchLongTimeSong();
                case 0 -> runMenu();
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("---------------------------------------");
            Driver driver = new Driver();
            driver.runMenu();
        }
    }


    private  void removeMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("""
        Remove methods
        1)  removeSong
        2)  remove Artist
        0)  Exit
        ==>> """);
        System.out.print("Please enter your choice : ");
        int option = sc.nextInt();
        while (option != 0) {
            switch (option) {
                case 1 -> removeSong();
                case 0 -> runMenu();
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("---------------------------------------");
            Driver driver = new Driver();
            driver.runMenu();
        }
    }

    private void updateMenu() {
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
    private void addSong() {
        System.out.println(playlist.addSong());
    }
    private void removeSong() {
        System.out.println(playlist.removeSong());
    }

    private void updateSong() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the index of song you want to update?: ");
        int songId = sc.nextInt();
        Song song = new Song();
        playlist.updateSong(songId, song);
    }
    private void listSong(){
        System.out.println(playlist.listSong());
    }


    private void listVerifiedArtistSong(){
        System.out.println(playlist.listVerifiedArtistSong());

    }
    private void listArtistSong(){
        System.out.println(playlist.listArtistSong());
    }


    //-----------------------------------------------------------------
    //  Private methods for Search facility
    //-----------------------------------------------------------------
    private void searchSong() {
        System.out.println(playlist.searchSong());
    }
    private void SearchLongTimeSong() {
        System.out.println(playlist.SearchLongTimeSong());
    }
    private void findSongbyint() {}



    //-----------------------------
    //  Private methods for Reports
    // ----------------------------


    //---------------------------------
    //  Private methods for Persistence
    // --------------------------------


    //TODO Add a method, load().  The return type is void.
    //    This method uses the XStream component to deserialise the playList object and their associated artists from
    //    an XML file into the Songs array list.


    //TODO Add a method, save().  The return type is void.
    //    This method uses the XStream component to serialise the playList object and their associated artists to
    //    an XML file.
}