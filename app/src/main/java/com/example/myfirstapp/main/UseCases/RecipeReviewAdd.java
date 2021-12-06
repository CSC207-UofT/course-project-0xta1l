package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;

public class RecipeReviewAdd {
    /**
     * add reviews to recipes
     *
     * @param accUser is the specified user
     * @param recipe  is the specified recipe
     * @param comment user's comment for the recipe
     * @param rating  the rating given to the Recipe as designated by users (int from 1-5)
     * @return whether the review was successfully added
     */

    public Review addReview(User accUser, Recipe recipe, String comment, int rating) {
        int recipeID = recipe.getID();
        String username = accUser.getUsername();
        if (accUser.getUserReviews().containsKey(recipeID)) {
            return null;
        } else {
            Review review = new Review(username, recipeID, comment, rating);
            accUser.addSavedReviews(recipeID, review);
            recipe.addSavedReviews(username, review);
            return review;
        }
    }
}
