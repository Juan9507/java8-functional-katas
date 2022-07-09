package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream().map(element -> element.getVideos())
                .flatMap(data -> data.stream())
                .map(elements -> ImmutableMap.of(
                        "id", elements.getId(), "title", elements.getTitle(),
                        "time", elements.getInterestingMoments().stream().reduce((acumulador, time) -> acumulador).get().getTime(),
                        "url", elements.getBoxarts().stream().reduce((acumulador, box) ->
                                acumulador.getWidth() < box.getWidth() ? acumulador : box).get().getUrl()
                )).collect(Collectors.toList());

        //return ImmutableList.of(ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl"));
    }

    public static void main(String[] args) {
        execute();
    }
}
