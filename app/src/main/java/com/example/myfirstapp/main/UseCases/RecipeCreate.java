package com.example.myfirstapp.main.UseCases;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.User;

import java.util.ArrayList;

public class RecipeCreate {
    /**
     CreateRecipeFromUser method  (creates a recipe entity from user)
     //        Takes in a list of recipe attributes
     //        Creates recipe entity and adds it to the GenreLibrary
     //        Outputs the created recipe
     */

    @RequiresApi(api = Build.VERSION_CODES.O)
    public int CreateRecipeFromUser(String username, String instructions, String ingredients, ArrayList<String> genres, String name,
                                       int rating, String image,
                                       String descriptions, int preptime ){

        int ID = Constants.GENRELIBRARY.getNewID();
        Recipe recipe = new Recipe(instructions,ingredients, genres, name, rating, ID, image, descriptions, preptime);
        Constants.GENRELIBRARY.setHighestID(ID);
        for(String genre: recipe.getGenre()){
            Constants.GENRELIBRARY.addRecipes(genre, recipe);
        }

        User user = Constants.USERSECURITY.getUserByID(username);
        user.addSavedRecipes(recipe);

        return recipe.getID();
    }
}
