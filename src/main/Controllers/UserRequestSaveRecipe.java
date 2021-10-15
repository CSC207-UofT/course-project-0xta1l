package Controllers;

import UseCases.RecipeSave;

import java.util.ArrayList;

public class UserRequestSaveRecipe {


    public boolean saveRecipe(String username,int recipeID, String genre) throws Exception {
        boolean saved_state = RecipeSave.saveToUser(username, recipeID, genre);
        return saved_state;
    }


}
