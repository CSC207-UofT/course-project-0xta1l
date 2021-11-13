package com.example.myfirstapp.main.Controllers;


import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.UseCases.RecipeCreate;

import java.util.ArrayList;
import java.util.Arrays;

public class UserRequestCreateRecipe {
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



