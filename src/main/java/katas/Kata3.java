package katas;

import com.google.common.collect.ImmutableList;
import model.MovieList;
import util.DataUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        List<Integer> myList = new ArrayList<>();
        movieLists.stream().map(element -> element.getVideos())
                .flatMap(element -> element.stream())
                .map(element -> myList.add(element.getId()))
                .collect(Collectors.toList());

        return myList;
        //return ImmutableList.of(1, 2, 3);
    }

    public static void main(String[] args) {
        execute();
    }
}
