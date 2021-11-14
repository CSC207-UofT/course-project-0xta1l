package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.UseCases.RecipeReviewAdd;

public class UserRequestCreateReview { // database should be called here to write recipe to database
    public Review reviewRecipe(String userID, int recipeID, String comment, int rating) throws Exception {
        RecipeReviewAdd recipeAdd = new RecipeReviewAdd();
        return recipeAdd.addReview(userID, recipeID, comment, rating);
    }

}