package com.example.myfirstapp.main.Controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Constants.JSONWriter;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.UseCases.RecipeReviewAdd;


public class UserRequestCreateReview { // database should be called here to write recipe to database
    /**
     * Creates a review
     * @param userID is the ID of the user
     * @param recipeID the recipeID
     * @param comment represents the comments on a given recipe
     * @param rating the given rating of the recipe
     * @return true if the review is created
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean reviewRecipe(String userID, int recipeID, String comment, int rating) {
        RecipeReviewAdd recipeAdd = new RecipeReviewAdd();
        boolean created = recipeAdd.addReview(userID, recipeID, comment, rating);
        JSONWriter.writeUsers("app/src/main/java/com/example/myfirstapp/main/Constants/users.json");
        JSONWriter.writeRecipes("app/src/main/java/com/example/myfirstapp/main/Constants/temp_data.json");
        return created;
    }

}
