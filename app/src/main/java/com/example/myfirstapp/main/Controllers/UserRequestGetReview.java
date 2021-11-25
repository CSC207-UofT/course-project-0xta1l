package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.UseCases.GetReview;

import java.util.ArrayList;

public class UserRequestGetReview {
    /**
     * User requests to see a review
     * @param recipeID is the ID of the given recipe
     * @return a list of reviews for a specific recipe
     */
    public ArrayList<ArrayList<Object>> getrecipereview(String recipeID){
        int ID = Integer.parseInt(recipeID);

        GetReview getrecreview = new GetReview();
        return getrecreview.getRecipeReviews(ID);
    }

    public ArrayList<ArrayList<Object>> getuserreview(String username)   {
        /**
         * Displays reviews written by a specific user
         * @param username is the username of the user whose reviews you want to view
         * @return a list of reviews for a specific user
         */

            GetReview getusereview= new GetReview();
            return getusereview.getUserReviews(username);

        }

    }

