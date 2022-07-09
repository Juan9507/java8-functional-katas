package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

       String someUrl = movies.stream().map(element -> element.getBoxarts())
                .flatMap(element -> element.stream())
                .reduce((acumulador, data) -> acumulador.getWidth() > data.getWidth() ? acumulador : data).get().getUrl();
       return someUrl;
    }

    public static void main(String[] args) {
        execute();
    }
}
