package com.example.myfirstapp.main.Controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Gateways.Create;
import com.example.myfirstapp.main.Gateways.Update;
import com.example.myfirstapp.main.UseCases.RecipeCreate;

import java.util.ArrayList;

public class UserRequestCreateRecipe {
    /**
     * Creates a recipe
     *
     * @param username     is the username of a given User
     * @param descriptions the description of the recipe
     * @param genres       represents the genres that the recipe falls into
     * @param ID           the assigned recipeID
     * @param image        the image URL
     * @param ingredients  the ingredients needed for the recipe
     * @param instructions the instructions on how to create the recipe
     * @param name         the name of the recipe
     * @param preptime     represents how long the meal takes to prepare and cook
     * @param rating       the given rating of the recipe
     * @return the recipe created
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void recipe(String username, String instructions, String ingredients, ArrayList<String> genres, String name,
                       String rating, int ID, String image,
                       String descriptions, String preptime) {
        int ratingInt = Integer.parseInt(rating);
        int prepInt = Integer.parseInt(preptime);
        RecipeCreate recipeCreate = new RecipeCreate();
        Recipe newRecipe = recipeCreate.CreateRecipeFromUser(instructions, ingredients, genres, name, ratingInt, ID, image, descriptions,
                prepInt, Constants.GENRELIBRARY);
        User user = Constants.USERSECURITY.getUserByID(username);
        user.addSavedRecipes(newRecipe);

        // Update the database
        Update.recipesSaved(user);
        Create.createRecipe(newRecipe);
    }
}



