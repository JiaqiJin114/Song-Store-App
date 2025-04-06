package models;

import java.util.Objects;

public class Artist {


    //TODO The artist name (String artistName)  in the system is entered by the user.
    //     Default value is "".
    //     When creating the Artist, truncate the name to 15 characters.
    //     When updating an existing Artist, only update the name if it is 15 characters or less.
    private String artistName = "";


    //TODO The verified status (boolean verified)  Default is false.
    private boolean verified;


    //TODO Add the constructor, Artist(String, boolean), that adheres to the above validation rules


    public Artist(String artistName, boolean verified) {
        this.artistName = limit(artistName, 15);
        this.verified = verified;
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
    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = limit(artistName, 15);
    }

    //TODO Add a generated equals method.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return verified == artist.verified && Objects.equals(artistName, artist.artistName);
    }

    //TODO The toString should return the string in this format:
    //      Taylor Swift is a verified artist  OR
    //      Shane Hennessy is not a verified artist


    @Override
    public String toString() {
        return artistName + (verified ? " is a verified artist" : " is not a verified artist");
    }

}
