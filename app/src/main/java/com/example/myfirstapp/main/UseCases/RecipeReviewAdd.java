package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.*;

public class RecipeReviewAdd {

    public boolean addReview(String username,int recipeID, String comment, int rating) {
        User accUser = Constants.USERSECURITY.getUserByID(username);
        Review review = new Review(username, recipeID, comment, rating);
        if (accUser.getUserReviews().containsKey(recipeID)){
            return false;
        }
        else{
            review.saveToUser(username, recipeID, review);
            review.saveToRecipe(recipeID, username, review);
            return true;
        }
    }
}
