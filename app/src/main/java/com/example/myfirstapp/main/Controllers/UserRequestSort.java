package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.SortByInterests;
import com.example.myfirstapp.main.UseCases.SortByRating;
import com.example.myfirstapp.main.UseCases.SortRecipes;

import java.util.ArrayList;

public class UserRequestSort {

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
