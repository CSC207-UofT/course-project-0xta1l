package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Constants.*;

import java.util.ArrayList;

public class RecipeSave {
    /**
     * Saves a recipe to a user's saved recipes list
     * @param recipeID is the ID of recipe
     * @param username the username of a specified user
     * @param genre saves the recipe a user's saved recipes
     * @return whether the recipe was successfully saved
     */
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
    /**
     * Deleted a recipe to a user's saved recipes list
     * @param recipeID is the ID of recipe
     * @param username the username of a specified user
     * @return whether the recipe was successfully deleted
     */
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