package UseCases;

import Entities.Recipe;
import Entities.User;
import Constants.*;

import java.util.ArrayList;

public class RecipeSave {

    public boolean saveToUser(String username, int recipeID, String genre) throws Exception {
        User user = Constants.USERSECURITY.getUsernames().get(username);
        Recipe recipe = Constants.GENRELIBRARY.getRecipeByID(genre, recipeID);

        ArrayList<Recipe> recipeList = user.getSavedRecipes();
        if (recipeList.contains(recipe)){
            throw new Exception("Recipe is already saved");
        }
        else {
            user.addSavedRecipes(recipe);
            return true;
        }
    }

    public boolean deleteFromUser(String username, int recipeID) throws Exception {
        User user = Constants.USERSECURITY.getUsernames().get(username);
        Recipe recipe = Constants.GENRELIBRARY.getRecipeByID("All", recipeID);

        ArrayList<Recipe> recipeList = user.getSavedRecipes();
        if (recipeList.contains(recipe)){
            user.removeSavedRecipes(recipe);
            return true;
        }
        else {
            throw new Exception("Recipe not in saved recipes.");
        }
    }
}