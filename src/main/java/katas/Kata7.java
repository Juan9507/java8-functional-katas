package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

         return movieLists.stream().map(element -> element.getVideos())
                .flatMap(videos -> videos.stream())
                .map(element -> ImmutableMap.of(
                        "id", element.getId(), "title", element.getTitle(), "boxart",
                        element.getBoxarts().stream().reduce((acumulador, tamanio)->
                                acumulador.getWidth() < tamanio.getWidth()
                                        ? acumulador : tamanio).get().getUrl()
                )).collect(Collectors.toList()); //.forEach(System.out::println);

        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", "url"));
    }

    public static void main(String[] args) {
        execute();
    }
}
