package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.UseCases.GetReview;

import java.util.ArrayList;

public class UserRequestGetReview {
    /**
     * User requests to see a review
     *
     * @param recipeID is the ID of the given recipe
     * @return a list of reviews for a specific recipe
     */
    public ArrayList<ArrayList<Object>> getRecipeReview(String recipeID) {
        int ID = Integer.parseInt(recipeID);

        GetReview getRecReview = new GetReview();
        Recipe recipe = Constants.GENRELIBRARY.getRecipeByID("All", ID);
        return getRecReview.getRecipeReviews(recipe);
    }

    public ArrayList<ArrayList<Object>> getUserReview(String username) {
        /**
         * Displays reviews written by a specific user
         * @param username is the username of the user whose reviews you want to view
         * @return a list of reviews for a specific user
         */

        GetReview getUserReview = new GetReview();
        User user = Constants.USERSECURITY.getUserByID(username);
        return getUserReview.getUserReviews(Constants.GENRELIBRARY, user);

    }

}

