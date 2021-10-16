
package Controllers;

import Constants.Constants;
import Entities.Recipe;
import Entities.User;
import UseCases.GenreViewSort;
import UseCases.GetRecipe;

import java.util.ArrayList;

public class UserRequestBrowse {

    public ArrayList<String> browseGenres(String username){
        User user = Constants.USERSECURITY.getUsernames().get(username);
        // theoretically have 2 userSecurity instances
        // static, with all from csv
        // non-static, includes csv stuff + ANY NEW USERS temporary
        GenreViewSort g = new GenreViewSort();
        return g.genresViewList(user);
    }
    public ArrayList<ArrayList<Object>> browseSavedRecipes(String username){
        User user = Constants.USERSECURITY.getUsernames().get(username);
        ArrayList<Recipe> saved_recipes = user.getSavedRecipes();
        ArrayList<ArrayList<Object>> recipe_previews = new ArrayList<>();
        for (Recipe rec : saved_recipes){
            recipe_previews.add(rec.getPreview());
        }
        return recipe_previews;
    }
    public ArrayList<ArrayList<Object>> browseGenreRecipes(String genre){
        GetRecipe g = new GetRecipe();
        return g.getGenreRecipes(genre);
    }
}


