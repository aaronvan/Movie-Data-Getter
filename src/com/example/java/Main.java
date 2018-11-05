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
        // create a file to hold movie data
        File movieDataFile = new File("files/data.json");

        // get the movie title from the user
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the movie title: ");
        String title = console.nextLine();

        // convert the movie title to a search string URL
        String dataSource = Movie.getAPISearchString(title);
        // create a URL to the OMDb using the search string
        URL url = new URL(dataSource);
        // create a URLConnection object to get the content from the OMBd
        // and open an Internet connection
        URLConnection urlConnection = url.openConnection();

        // create a buffered reader object to get an input stream from the connection and
        // write it to movieDataFile for eventual parsing
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
             FileWriter fileWriter = new FileWriter(movieDataFile)
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

        // this block reads the data file and parses the requested information.
        // creates a Gson instance called gson so you can use Gson methods on it.
        Gson gson = new Gson();
        // creates a new FileReader called fileReader from the data file
        // and wraps it in a JsonReader for parsing with Gson methods.
        try (FileReader fileReader = new FileReader("files/data.json");
             JsonReader jsonReader = new JsonReader(fileReader)
            )
        {
            // declares a Movie object called movie and instantiates it
            // using the next JSON value from the jsonreader.
            Movie movie = gson.fromJson(jsonReader, Movie.class);
            System.out.println("Movie: " + movie.getTitle());
            System.out.println("Year: " + movie.getYear());
            System.out.println("Genre: " + movie.getGenre());
            System.out.println("Director: " + movie.getDirector());
            System.out.println("Actors: " + movie.getActors());
            System.out.println("Plot: " + movie.getPlot());
        } finally {
            // delete the data file since it is no longer needed
            movieDataFile.delete();
        }
    }

}
