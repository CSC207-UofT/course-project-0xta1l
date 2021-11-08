package UseCases;

import Entities.GenreLibrary;
import Entities.Recipe;
import Entities.User;
import Constants.*;

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
//genreRecipeSort method  (sorts the recipes in a genre)
//        Takes in a list of recipe previews, and a sorting key (string either “rating” or “”)
//        Rating (High to low)
//        Alphabetical (default)
//        Sorts list of recipe previews according to key
//        Outputs rearranged list

public class GenreViewSort {
    public GenreViewSort(){}

    public ArrayList<String> genresViewList(User user) {
        ArrayList<String> genres = Constants.GENRELIBRARY.getAllGenres();
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
        return genres;
    }

    public ArrayList<Recipe> genreRecipeSort(ArrayList<Recipe> previews, String sortkey) {
        ArrayList<Recipe> recipes = helperMakeAlphabet(previews);
        if (sortkey.equals("")) {
                return recipes;
        } else if (sortkey.equals("rating")) {
            ArrayList<Recipe> grand_lst = new ArrayList<Recipe>();
            ArrayList<Recipe> lst_1 = new ArrayList<Recipe>();
            ArrayList<Recipe> lst_2 = new ArrayList<Recipe>();
            ArrayList<Recipe> lst_3 = new ArrayList<Recipe>();
            ArrayList<Recipe> lst_4 = new ArrayList<Recipe>();
            ArrayList<Recipe> lst_5 = new ArrayList<Recipe>();

            for (Recipe preview : previews) {
                helperPutRecipeInRatingList(preview, lst_1, lst_2, lst_3, lst_4, lst_5);
            }
            ArrayList<Recipe> lst1 = helperMakeAlphabet(lst_1);
            ArrayList<Recipe> lst2 = helperMakeAlphabet(lst_2);
            ArrayList<Recipe> lst3 = helperMakeAlphabet(lst_3);
            ArrayList<Recipe> lst4 = helperMakeAlphabet(lst_4);
            ArrayList<Recipe> lst5 = helperMakeAlphabet(lst_5);

            grand_lst.addAll(lst5);
            grand_lst.addAll(lst4);
            grand_lst.addAll(lst3);
            grand_lst.addAll(lst2);
            grand_lst.addAll(lst1);

            return grand_lst;
        } else{
            return null;
        }
    }

    private ArrayList<Recipe> helperMakeAlphabet(ArrayList<Recipe> previews) {
        ArrayList<Recipe> output_lst = new ArrayList<Recipe>();
        ArrayList<String> names = new ArrayList<String>();
        for (Recipe preview : previews) {
            String name = preview.getName();
            names.add(name);
        }
        Collections.sort(names);
        for (String name : names) {
            for (Recipe preview : previews) {
                if (preview.getName().equals(name)) {
                    output_lst.add(preview);
                }
            }
        }
        return output_lst;
    }

    private void helperPutRecipeInRatingList(Recipe preview, ArrayList<Recipe> lst_1, ArrayList<Recipe> lst_2,
    ArrayList<Recipe> lst_3, ArrayList<Recipe> lst_4, ArrayList<Recipe> lst_5) {
        SortByRating.helperDuplicate(preview, lst_1, lst_2, lst_3, lst_4, lst_5);
    }

}
