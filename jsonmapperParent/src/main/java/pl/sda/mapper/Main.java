package pl.sda.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.lambda.Movie;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Movie> movies = Arrays.asList(
                new Movie("Tytul",
                        "Jan",
                        LocalDate.of(2012, 02, 12),
                        60,
                        Arrays.asList("Jan", "Maciek")),
                new Movie("Sensacja",
                        "Kamil",
                        LocalDate.of(2018, 02, 12),
                        33,
                        Arrays.asList("Jan", "Maciek")),
                new Movie("Tytul2",
                        "Jan",
                        LocalDate.of(2012, 02, 12),
                        20,
                        Arrays.asList("Marek", "Maciek"))
        );

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("movies.json");

        try {
            mapper.writeValue(file, movies);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Movie[] movies1 = mapper.readValue(file, Movie[].class);
            System.out.println(movies1);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
