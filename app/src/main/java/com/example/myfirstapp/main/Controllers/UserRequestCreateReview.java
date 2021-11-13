package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.UseCases.GetReview;
import com.example.myfirstapp.main.UseCases.RecipeReviewAdd;

public class UserRequestCreateReview { // database should be called here to write recipe to database
    public Review reviewRecipe(String userID, int recipeID, String comment, int rating) throws Exception{
        if ((rating > 5) || (rating < 1)){
            throw new Exception("Data is incomplete!");
        }
        RecipeReviewAdd recipeAdd = new RecipeReviewAdd();
        Review review =  recipeAdd.addReview(userID, recipeID, comment, rating);
        return review;
    }

}
