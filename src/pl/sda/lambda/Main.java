package pl.sda.lambda;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        AddInterface add = (a, b) -> a + b;
        add.calc(4, 2);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        for (Integer integer : numbers) {
            System.out.println(integer);
        }
        Consumer<Integer> integerConsumer = n -> System.out.println(n);
        numbers.forEach(integerConsumer);

        numbers.forEach(System.out::println);

        List<Movie> movies = Arrays.asList(
                new Movie("Tytuł",
                "Jan",
                LocalDate.of(2012,02,12),
                60,
                Arrays.asList("Michał","Maciek")),
                new Movie("Tytuł",
                        "Jan",
                        LocalDate.of(2012,02,12),
                        20,
                        Arrays.asList("Michał","Maciek")));


        List<String> titles = movies
                .stream()
                .map(f -> f.getTitle())
                .collect(Collectors.toList());

        //drugi steam - lista directors

        List<String> directors = movies
                .stream()
                .map(f -> f.getDirector())
                .collect(Collectors.toList());

        List<Movie> movieList = movies.stream()
                .filter(f -> f.getPrice()>50)    //filtr ceny
                .filter(f -> f.getTitle().length() >5) //dlugosc tytulu
                .collect(Collectors.toList());




        System.out.println(titles);
        System.out.println(directors);


    }
}



