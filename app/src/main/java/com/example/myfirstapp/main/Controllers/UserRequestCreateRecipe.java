package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.UseCases.RecipeCreate;

import java.util.ArrayList;
import java.util.Arrays;

public class UserRequestCreateRecipe {
    /**
     * Creates a recipe
     * @param username is the username of a given User
     * @param descriptions the description of the recipe
     * @param genres represents the genres that the recipe falls into
     * @param ID the assigned recipeID
     * @param image  the image URL
     * @param ingredients the ingredients needed for the recipe
     * @param instructions the instructions on how to create the recipe
     * @param name the name of the recipe
     * @param preptime represents how long the meal takes to prepare and cook
     * @param rating the given rating of the recipe
     * @return the recipe created
     */
    public com.example.myfirstapp.main.Entities.Recipe recipe(String username, String instructions, String ingredients, String genres, String name,
                                  String rating, String ID, String image,
                                  String descriptions, String preptime) {
        int ratingInt = Integer.parseInt(rating);
        // TODO: UPDATE ALL INSTANCES OF RECIPE CREATION TO GET AUTOINCREMENT FROM DB, ALSO WE NEED TO FIGURE OUT RATINGS FOR NEW RECIPES
        int IDint = Integer.parseInt(ID);
        int prepInt = Integer.parseInt(preptime);
        ArrayList<String> genresList = new ArrayList<>(Arrays.asList(genres.split(",\\s*")));
        RecipeCreate recipeCreate = new RecipeCreate();
        return recipeCreate.CreateRecipeFromUser(username, instructions, ingredients, genresList, name, ratingInt, IDint, image, descriptions,
                prepInt);
    }
}



