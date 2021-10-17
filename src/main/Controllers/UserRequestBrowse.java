
package Controllers;

import Constants.Constants;
import Entities.Recipe;
import Entities.User;
import UseCases.GenreViewSort;
import UseCases.GetRecipe;

import java.util.ArrayList;

public class UserRequestBrowse {

    public ArrayList browseGenres(String username){
        User user = Constants.USERSECURITY.getUsernames().get(username);
        GenreViewSort g = new GenreViewSort();
        ArrayList<String> genre_list = g.genresViewList(user);
        return genre_list;
    }
    public ArrayList browseSavedRecipes(String username){
        User user = Constants.USERSECURITY.getUsernames().get(username);
        ArrayList<Recipe> saved_recipes = user.getSavedRecipes();
        ArrayList<Object> recipe_previews = new ArrayList<>();
        for (Recipe rec : saved_recipes){
            recipe_previews.add(rec.getPreview());
        }
        return recipe_previews;
    }

    public ArrayList<ArrayList<Object>> browseGenreRecipes(String genre){
        ArrayList<ArrayList<Object>> genre_recipe_previews;
        GetRecipe g = new  GetRecipe();
        genre_recipe_previews = g.getGenreRecipes(genre);
        return genre_recipe_previews;


    }
}


