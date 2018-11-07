/* Aaron VanAlstine
 *  Movie Database query tool
 *  November 4, 2018
 */

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
        File movieDataFile = new File("files/data.json");

        Scanner console = new Scanner(System.in);
        System.out.print("Enter the movie title: ");
        String title = console.nextLine();

        String dataSource = Movie.getAPISearchString(title);
        URL url = new URL(dataSource);
        URLConnection urlConnection = url.openConnection();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
             FileWriter fileWriter = new FileWriter(movieDataFile)) {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                fileWriter.write(line + "\n");
            }
        }

        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(movieDataFile);
             JsonReader jsonReader = new JsonReader(fileReader)) {
            Movie movie = gson.fromJson(jsonReader, Movie.class);
            System.out.println("Movie: " + movie.getTitle());
            System.out.println("Year: " + movie.getYear());
            System.out.println("Genre: " + movie.getGenre());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Actors: " + movie.getActors());
            System.out.println("Plot: " + movie.getPlot());
            movieDataFile.delete();
        }
    }

}
