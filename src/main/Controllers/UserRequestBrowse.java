package Controllers;

import UseCases.GenreViewSort;
import UseCases.GetRecipe;

import java.util.ArrayList;

public class UserRequestBrowse {

    public ArrayList browseGenres(String username){
        // getter for user from username?
        // where does GenreLibrary come from?
        ArrayList<String> genre_list = GenreViewSort.genresViewList();
        if ()
    }

    public ArrayList browseSavedRecipes(String username){
        GetRecipe.getSavedRecipes();


    }
}
