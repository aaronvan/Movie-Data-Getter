package com.example.java;

import com.example.java.model.Movie;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner console = new Scanner(System.in);
        String dataTarget = "files/data.json";
        System.out.print("Enter the movie title: ");
        String title = console.nextLine();

        // convert the movie title to a search string URL
        String dataSource = Movie.getAPISearchString(title);
        // create a URL to the OMDb using the search string
        URL url = new URL(dataSource);
        // create a URLConnection object to get the content from the OMBd
        // and open a connection
        URLConnection urlConnection = url.openConnection();

        // create a buffered reader object to get an input stream from the connection and
        // write it to the the file for eventual parsing
        try (
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
             FileWriter fileWriter = new FileWriter(dataTarget)
            )
        {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                fileWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        try (
            FileReader fileReader = new FileReader("files/data.json");
            JsonReader jsonReader = new JsonReader(fileReader)
            )
        {
            Movie movie = gson.fromJson(jsonReader, Movie.class);
            System.out.println("Movie: " + movie.getTitle());
            System.out.println("Year: " + movie.getYear());
            System.out.println("Genre: " + movie.getGenre());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Actors: " + movie.getActors());
            System.out.println("Plot: " + movie.getPlot());
        }
    }

}
