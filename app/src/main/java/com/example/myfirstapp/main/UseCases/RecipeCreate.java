package com.example.myfirstapp.main.UseCases;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.Create;
import com.example.myfirstapp.main.Gateways.Update;

import java.util.ArrayList;

public class RecipeCreate {
    /**
     CreateRecipeFromUser method  (creates a recipe entity from user)
     //        Takes in a list of recipe attributes
     //        Creates recipe entity and adds it to the GenreLibrary
     //        Outputs the created recipe
     */
    /**
     * creates recipe from recipe attributes
     * @param username is the username of the user
     * @param instructions the instructions to make the recipe
     * @param ingredients the different ingredients required
     * @param genres the types of recipe in question, for example "Jamaican" and "Dessert"
     * @param  name the name of the recipe
     * @param  rating the rating given to the Recipe as designated by users (int from 1-5)
     * @param ID the unique identifier for the recipe
     * @param image text representing a jpg file of the recipe
     * @param descriptions brief description of the recipe
     * @param preptime the number of minutes it takes to prepare for the cooking/baking of recipe
     * @return recipe
     */

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Recipe CreateRecipeFromUser(String username, String instructions, String ingredients, ArrayList<String> genres, String name,
                                       int rating, int ID, String image,
                                       String descriptions, int preptime ){

        Recipe recipe = new Recipe(instructions,ingredients, genres, name, rating, ID, image, descriptions, preptime);
        for(String genre: recipe.getGenre()){
            Constants.GENRELIBRARY.addRecipes(genre, recipe);
        }

        User user = Constants.USERSECURITY.getUserByID(username);
        user.addSavedRecipes(recipe);

        Update.recipesSaved(user);
        Create.createRecipe(recipe);
        return recipe;
    }
}
