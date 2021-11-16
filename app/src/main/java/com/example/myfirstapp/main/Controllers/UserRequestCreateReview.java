package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.UseCases.RecipeReviewAdd;


public class UserRequestCreateReview { // database should be called here to write recipe to database
    /**
     * Creates a review
     * @param userID is the ID of the user
     * @param recipeID the recipeID
     * @param comment represents the comments on a given recipe
     * @param rating the given rating of the recipe
     * @return the review created
     */
    public Review reviewRecipe(String userID, int recipeID, String comment, int rating) throws Exception {
        RecipeReviewAdd recipeAdd = new RecipeReviewAdd();
        return recipeAdd.addReview(userID, recipeID, comment, rating);
    }

}
