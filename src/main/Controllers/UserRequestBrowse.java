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
        ArrayList<String> genre_list = GenreViewSort.genresViewList(user);
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
}
