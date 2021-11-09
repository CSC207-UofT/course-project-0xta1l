package UseCases;

import Entities.GenreLibrary;
import Entities.Preview;
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

    public ArrayList<Preview> genreRecipeSort(ArrayList<Preview> previews, String sortkey) {
        ArrayList<Preview> recipes = helperMakeAlphabet(previews);
        if (sortkey.equals("")) {
                return recipes;
        } else if (sortkey.equals("rating")) {
            ArrayList<Preview> grand_lst = new ArrayList<>();
            ArrayList<Preview> lst_1 = new ArrayList<>();
            ArrayList<Preview> lst_2 = new ArrayList<>();
            ArrayList<Preview> lst_3 = new ArrayList<>();
            ArrayList<Preview> lst_4 = new ArrayList<>();
            ArrayList<Preview> lst_5 = new ArrayList<>();

            for (Preview preview : previews) {
                helperPutRecipeInRatingList(preview, lst_1, lst_2, lst_3, lst_4, lst_5);
            }
            ArrayList<Preview> lst1 = helperMakeAlphabet(lst_1);
            ArrayList<Preview> lst2 = helperMakeAlphabet(lst_2);
            ArrayList<Preview> lst3 = helperMakeAlphabet(lst_3);
            ArrayList<Preview> lst4 = helperMakeAlphabet(lst_4);
            ArrayList<Preview> lst5 = helperMakeAlphabet(lst_5);

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

    private ArrayList<Preview> helperMakeAlphabet(ArrayList<Preview> previews) {
        ArrayList<Preview> output_lst = new ArrayList<Preview>();
        ArrayList<String> names = new ArrayList<String>();
        for (Preview preview : previews) {
            String name = preview.getName();
            names.add(name);
        }
        Collections.sort(names);
        for (String name : names) {
            for (Preview preview : previews) {
                if (preview.getName().equals(name)) {
                    output_lst.add(preview);
                }
            }
        }
        return output_lst;
    }

    private void helperPutRecipeInRatingList(Preview preview, ArrayList<Preview> lst_1, ArrayList<Preview> lst_2,
                                             ArrayList<Preview> lst_3, ArrayList<Preview> lst_4, ArrayList<Preview> lst_5) {
        SortByRating.helperDuplicate(preview, lst_1, lst_2, lst_3, lst_4, lst_5);
    }

}
