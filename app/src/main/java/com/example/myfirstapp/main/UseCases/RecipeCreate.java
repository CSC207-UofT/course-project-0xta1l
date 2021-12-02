package com.example.myfirstapp.main.UseCases;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.User;

import java.util.ArrayList;

public class RecipeCreate {
    /**
     CreateRecipeFromUser method  (creates a recipe entity from user)
     //        Takes in a list of recipe attributes
     //        Creates recipe entity and adds it to the GenreLibrary
     //        Outputs the created recipe
     */

    public Recipe CreateRecipeFromUser(String username, String instructions, String ingredients, ArrayList<String> genres, String name,
                                       int rating, int ID, String image,
                                       String descriptions, int preptime ){

        Recipe recipe = new Recipe(instructions,ingredients, genres, name, rating, ID, image, descriptions, preptime);
        for(String genre: recipe.getGenre()){
            Constants.GENRELIBRARY.addRecipes(genre, recipe);
        }

        User user = Constants.USERSECURITY.getUserByID(username);
        user.addSavedRecipes(recipe);

        return recipe;
    }
}
