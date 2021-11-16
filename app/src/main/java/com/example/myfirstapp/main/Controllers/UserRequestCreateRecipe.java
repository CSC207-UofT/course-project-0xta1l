package com.example.myfirstapp.main.Controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Constants.JSONWriter;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.UseCases.RecipeCreate;

import java.util.ArrayList;
import java.util.Arrays;

public class UserRequestCreateRecipe {
    /**
     * Creates a recipe
     * @param username is the username of a given User
     * @param descriptions the description of the recipe
     * @param genres represents the genres that the recipe falls into
     * @param image  the image URL
     * @param ingredients the ingredients needed for the recipe
     * @param instructions the instructions on how to create the recipe
     * @param name the name of the recipe
     * @param preptime represents how long the meal takes to prepare and cook
     * @param rating the given rating of the recipe
     * @return the recipe created
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public int recipe(String username, String instructions, String ingredients, String genres, String name,
                                                              String rating, String image,
                                                              String descriptions, String preptime) {
        int ratingInt = Integer.parseInt(rating);
        // TODO: NEED TO FIGURE OUT RATINGS FOR NEW RECIPES
        int prepInt = Integer.parseInt(preptime);
        ArrayList<String> genresList = new ArrayList<>(Arrays.asList(genres.split(",\\s*")));
        RecipeCreate recipeCreate = new RecipeCreate();
        int ID = recipeCreate.CreateRecipeFromUser(username, instructions, ingredients, genresList, name, ratingInt, image, descriptions,
                prepInt);
        JSONWriter.writeRecipes("app/src/main/java/com/example/myfirstapp/main/Constants/temp_data.json");
        JSONWriter.writeUsers("app/src/main/java/com/example/myfirstapp/main/Constants/users.json");
        return ID;
    }
}



