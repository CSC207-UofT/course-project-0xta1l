package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Constants.*;

public class RecipeReviewAdd {


    public Review addReview(String username,int recipeID, String comment, int rating) throws Exception {
        User accUser = Constants.USERSECURITY.getUserByID(username);
        Review review = new Review(username, recipeID, comment, rating);
        if (accUser.getUserReviews().containsKey(recipeID)){
            throw new Exception("Review already exists");
        }
        else{
            review.saveToUser(username, recipeID, review);
            review.saveToRecipe(recipeID, username, review);
            return review;
        }
    }
}
