package UseCases;

import Entities.GenreLibrary;
import Entities.Recipe;
import Entities.GenreLibrary;
import Entities.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetRecipe {
    public HashMap<Integer, List<?>> getUserSavedRecipes(User user) {
        ArrayList<Recipe> userRecipeList = user.getSavedRecipes();

        GenreLibrary userLibrary = new GenreLibrary();
        HashMap<Integer, List<?>> recipeMap = new HashMap<Integer, List<?>>();

        for (Recipe recipe: userRecipeList) {
            Recipe variable = userLibrary.getRecipeByID("All", recipe.getID());
            recipeMap.put(variable.getID(), variable.getPreview());
        }

        return recipeMap;
    }

//    public ArrayList<Object> getSingleRecipe (int recipeID) {
//
//
//    }
//
//    public ArrayList<ArrayList<Object>> getGenreRecipes (String genreName) {
//
//    }
}

// Notes:
//  - might edit output types later since a lot of
//    stuff outputted is in the format of a recipe preview
