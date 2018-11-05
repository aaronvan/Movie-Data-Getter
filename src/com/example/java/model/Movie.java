package com.example.java.model;

/**
 * The movie class is used to extract the information specified in the class fields
 * from the JSON file.
 */
public class Movie {
    private String Title;
    private String Year;
    private String Genre;
    private String Director;
    private String Actors;
    private String Plot;

    /**
     * Adds the movie title to a URL string and API key to access the OMDb.
     * @param str
     * @return a URL string to make an Internet connection to the OMDb.
     */
    public static String getAPISearchString(String str) {
        return "https://www.omdbapi.com/?t=" + str.replaceAll("\\s", "+") + "&apikey=e88d2fb1";
    }

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

    public String getGenre() {
        return Genre;
    }

    public String getDirector() {
        return Director;
    }

    public String getActors() {
        return Actors;
    }

    public String getPlot() {
        return Plot;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Director='" + Director + '\'' +
                ", Actors='" + Actors + '\'' +
                ", Plot='" + Plot + '\'' +
                '}';
    }
}
