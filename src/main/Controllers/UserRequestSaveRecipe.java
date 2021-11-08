package Controllers;

import UseCases.RecipeSave;

import java.util.ArrayList;

public class UserRequestSaveRecipe {

    public boolean saveRecipe(String username, String recipeID, String genre) throws Exception {
        RecipeSave recipeSave = new RecipeSave();
        return recipeSave.saveToUser(username, Integer.parseInt(recipeID), genre);
    }


}
