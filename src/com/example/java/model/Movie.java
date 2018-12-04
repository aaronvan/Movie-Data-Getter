package com.example.java.model;

/**
 * The Movie class created from the returned JSON data
 */

public class Movie {
    private String Title;
    private String Year;
    private String Genre;
    private String Director;
    private String Actors;
    private String Plot;

    /**
     * This method takes the movie title and returns a search URL
     * @param str is the movie title
     * @return a URL with the movie title and users API key
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
