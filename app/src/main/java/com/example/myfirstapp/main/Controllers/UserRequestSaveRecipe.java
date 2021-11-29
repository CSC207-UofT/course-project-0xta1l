package com.example.myfirstapp.main.Controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Constants.JSONWriter;
import com.example.myfirstapp.main.UseCases.RecipeSave;

public class UserRequestSaveRecipe {
    private RecipeSave recipeSave = new RecipeSave();
    /**
     * Saves a specified recipe to a user's saved recipes
     * @param username is the username of the requested user
     * @param recipeID the id of the recipe wanted to be saved
     * @return whether the recipe was successfully saved
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean saveRecipe(String username, String recipeID) throws Exception {
        boolean saved = recipeSave.saveToUser(username, Integer.parseInt(recipeID), "All");
        JSONWriter.writeUsers("app/src/main/java/com/example/myfirstapp/main/Constants/users.json");
        return saved;
    }
    /**
     * Deletes a specified recipe from a user's saved recipes
     * @param username is the username of the requested user
     * @param recipeID the id of the recipe wanted to be deleted
     * @return whether the recipe was successfully deleted
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean deleteRecipe(String username, String recipeID) throws Exception {
        boolean deleted = recipeSave.deleteFromUser(username, Integer.parseInt(recipeID));
        JSONWriter.writeUsers("app/src/main/java/com/example/myfirstapp/main/Constants/users.json");
        return deleted;
    }


}
