package UseCases;

import Entities.Recipe;
import Entities.User;
import Constants.*;

import java.util.ArrayList;

public class RecipeSave {

    public boolean saveToUser(String userID, int recipeID, String genre) throws Exception {
        User user = Constants.USERSECURITY.getUsernames().get(userID);
        Recipe recipe = Constants.GENRELIBRARY.getRecipeByID(genre, recipeID);

        ArrayList<Recipe> recipelist = user.getSavedRecipes();
        if (recipelist.contains(recipe)){
            throw new Exception("Recipe is already saved");
        }
        else {
            user.addSavedRecipes(recipe);
            return true;
        }
    }
}