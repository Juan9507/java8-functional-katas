package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import util.DataUtil;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

       return StreamUtils.zip(movies.stream(),
                bookMarks.stream(),
                (moviesId, bookMarksId) ->
                        ImmutableMap.of(
                                "id", moviesId.getId(), "bookmarkId", bookMarksId.getId()
                        )
        ).collect(Collectors.toList());

        //return ImmutableList.of(ImmutableMap.of("videoId", 5, "bookmarkId", 3));
    }
}
