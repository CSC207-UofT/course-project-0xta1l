package com.example.myfirstapp.main.UseCases;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Entities.User;

import java.util.ArrayList;
import java.util.Collections;

//genresViewList method (takes in user)
//        Calls GenreLibrary.getAllGenres() to get list of string genres
//        Sorts the strings
//        If user.getInterests() is empty:
//        Sort strings into alphabetical order
//        If user.getInterests() is NOT empty:
//        Put strings in Interests first in list, all others in alphabetical order
//        Outputs the list of genre strings
//

public class GenreViewSort {
    public GenreViewSort() {
    }

    /**
     * gets the list of genres from the user
     *
     * @param user the user
     * @return list of genres
     */
    @RequiresApi(api = Build.VERSION_CODES.N)

    public ArrayList<String> genresViewList(ArrayList<String> genres, User user) {
        if (user.getInterests().isEmpty()) {
            Collections.sort(genres);
        } else {

            genres.removeIf(genre -> user.getInterests().contains(genre));

            Collections.sort(genres);
            Collections.sort(user.getInterests());
            Collections.reverse(user.getInterests());
            for (String interest : user.getInterests()) {
                genres.add(0, interest);
            }
        }
        genres.remove("All");
        genres.add(0, "All");
        return genres;
    }
}
