package Controllers;

import Entities.Preview;
import Entities.User;
import UseCases.SortByInterests;
import UseCases.SortByRating;
import UseCases.SortRecipes;

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
    public ArrayList<Preview> sort(ArrayList<Preview> recipes, String sortkey, User user) {
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
