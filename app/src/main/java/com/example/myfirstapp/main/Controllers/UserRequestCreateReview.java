package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Gateways.Update;
import com.example.myfirstapp.main.UseCases.RecipeReviewAdd;


public class UserRequestCreateReview {
    /**
     * Creates a review
     *
     * @param userID   is the ID of the user
     * @param recipeID the recipeID
     * @param comment  represents the comments on a given recipe
     * @param rating   the given rating of the recipe
     * @return true if the review is created
     */
    public boolean reviewRecipe(String userID, int recipeID, String comment, int rating) {
        RecipeReviewAdd recipeAdd = new RecipeReviewAdd();
        User user = Constants.USERSECURITY.getUserByID(userID);
        Recipe recipe = Constants.GENRELIBRARY.getRecipeByID("All", recipeID);
        Review review = recipeAdd.addReview(user, recipe, comment, rating);
        if (review == null) {
            return false;
        } else {
            Update.reviewCreated(review);
            Update.recipeRating(Constants.GENRELIBRARY.getRecipeByID("All", recipeID));
            return true;
        }
    }

}
