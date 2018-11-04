package com.example.java.model;

public class Movie {
    private String Title;
    private String Year;
    private String Genre;
    private String Director;
    private String Actors;

    public static String getAPISearchString(String str) {
        String searchString = "https://www.omdbapi.com/?t=" + str.replaceAll("\\s", "+") + "&apikey=e88d2fb1";
        return searchString;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Director='" + Director + '\'' +
                ", Actors='" + Actors + '\'' +
                '}';
    }
}
