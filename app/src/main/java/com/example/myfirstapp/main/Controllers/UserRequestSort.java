package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.SortByInterests;
import com.example.myfirstapp.main.UseCases.SortByRating;
import com.example.myfirstapp.main.UseCases.SortRecipes;

import java.util.ArrayList;

public class UserRequestSort {
    /**
     * sorts recipe according to user's filter
     *
     * @param recipes is the list of recipe previews
     * @param sortkey the key you want to filter by
     * @return list of recipes if can't null
     */

    //sort method
    public ArrayList<Preview> sort(ArrayList<Preview> recipes, String sortkey) {
        if (sortkey.isEmpty()) {
            SortRecipes s = new SortRecipes(recipes);
            return s.sort();
        } else if (sortkey.equals("Rating")) {
            SortByRating s = new SortByRating(recipes);
            return s.sort();
        } else {
            return null;
        }
    }

    /**
     * sorts recipe according to user's interests
     *
     * @param recipes  is the list of recipe previews
     * @param sortkey  the key you want to filter by
     * @param username the username of a specified user
     * @return list of recipes if can't null
     */

    // overload sort method for sort by interests
    public ArrayList<Preview> sort(ArrayList<Preview> recipes, String sortkey, String username) {
        User user = Constants.USERSECURITY.getUsernames().get(username);
        if (sortkey.isEmpty()) {
            SortRecipes s = new SortRecipes(recipes);
            return s.sort();
        } else if (sortkey.equals("Rating")) {
            SortByRating s = new SortByRating(recipes);
            return s.sort();
        } else if (sortkey.equals("Interests")) {
            SortByInterests s = new SortByInterests(recipes, user);
            return s.sort();
        } else {
            return null;
        }
    }


}
