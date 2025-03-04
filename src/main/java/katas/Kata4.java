package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        return movieLists.stream().map(element -> element.getVideos())
                .flatMap(element -> element.stream())
                .map(element -> {
                    return ImmutableMap.of("id" ,element.getId(),"title",
                            element.getTitle(), "boxart",
                            element.getBoxarts().stream()
                                    .filter(filter -> filter.getWidth() == 150)
                                    .filter(filter -> filter.getHeight() == 200)
                                    .findFirst()
                                    .map(el -> el.getUrl()).get()
                    );

                })
                .collect(Collectors.toList());

       // return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys", "boxart", new BoxArt(150, 200, "url")));
    }

    public static void main(String[] args) {
        execute();
    }
}
