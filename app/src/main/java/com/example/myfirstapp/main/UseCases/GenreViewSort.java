package com.example.myfirstapp.main.UseCases;

import android.os.Build;

import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Constants.*;

import java.util.ArrayList;
import java.util.Arrays;
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
    public GenreViewSort(){}

    public ArrayList<String> genresViewList(User user) {
        ArrayList<String> genres = Constants.GENRELIBRARY.getAllGenres();
        if (user.getInterests().isEmpty()) {
            Collections.sort(genres);
        } else {
            System.out.println(Build.VERSION_CODES.N);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                genres.removeIf(genre -> user.getInterests().contains(genre));
            }
            Collections.sort(genres);
            Collections.sort(user.getInterests());
            Collections.reverse(user.getInterests());
            for (String interest : user.getInterests()) {
                genres.add(0, interest);
            }
        }
        return genres;
    }
}
