package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.*;

public class RecipeReviewAdd {
    /**
     * add reviews to recipes
     * @param username is the username of a specified user
     * @param recipeID the unique identifier for the recipe
     * @param comment  user's comment for the recipe
     * @param rating the rating given to the Recipe as designated by users (int from 1-5)
     * @return whether the review was successfully added
     */

    public boolean addReview(String username,int recipeID, String comment, int rating) {
        User accUser = Constants.USERSECURITY.getUserByID(username);
        Review review = new Review(username, recipeID, comment, rating);
        if (accUser.getUserReviews().containsKey(recipeID)){
            return false;
        }
        else{
            review.saveToUser(username, recipeID, review);
            review.saveToRecipe(recipeID, username, review);
            Update.reviewCreated(review);
            Update.recipeRating(Constants.GENRELIBRARY.getRecipeByID("All", recipeID));
            return true;
        }
    }
}
