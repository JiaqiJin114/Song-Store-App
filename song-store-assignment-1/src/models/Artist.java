package models;

public class Artist {
    //TODO The artist name (String artistName)  in the system is entered by the user.
    //     Default value is "".
    //     When creating the Artist, truncate the name to 15 characters.
    //     When updating an existing Artist, only update the name if it is 15 characters or less.
    //TODO The verified status (boolean verified)  Default is false.
    private String artistName = "";
    private boolean verified;

    //TODO Add the constructor, Artist(String, boolean), that adheres to the above validation rules
    public Artist(String artistName, boolean verified) {
        while (artistName.length() < 15){
            this.artistName = artistName;
        }
        this.verified = verified;
    }

    //TODO Add a getter and setter for each field, that adheres to the above validation rules
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    //TODO Add a generated equals method.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Artist artist = (Artist) o;
        return isVerified() == artist.isVerified() && getArtistName().equals(artist.getArtistName());
    }

    //TODO The toString should return the string in this format:
    //      Taylor Swift is a verified artist  OR
    //      Shane Hennessy is not a verified artist

    private String judgement(){
        if(isVerified()){
            return "";
        }else {
            return "not";
        }
    }

    @Override
    public String toString() {
        return artistName + "is" + judgement() + "a verified artist";
    }

}
