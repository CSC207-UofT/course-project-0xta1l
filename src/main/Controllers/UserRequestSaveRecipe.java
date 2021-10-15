package Controllers;

import UseCases.RecipeSave;

import java.util.ArrayList;

public class UserRequestSaveRecipe {


    public boolean saveRecipe(String username,int recipeID, String genre) throws Exception {
        return RecipeSave.saveToUser(username, recipeID, genre);
    }


}
