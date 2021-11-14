package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.*;
import com.example.myfirstapp.main.Constants.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GetReview {

    public ArrayList<ArrayList<Object>> getRecipeReviews(int recipeID){
        // Cycles through all values in Recipe.getReviews HashMap and outputs relevant review info
        Recipe specificRecipe = Constants.GENRELIBRARY.getRecipeByID("All", recipeID);
        HashMap<String, Review> reviewMap = specificRecipe.getRecipeReviews();

        ArrayList<ArrayList<Object>> finalReviewList = new ArrayList<>();
        for (Review review: reviewMap.values()){
            int rating = review.getRating();
            String userID = review.getUsername();
            String comment = review.getComments();
            ArrayList<Object> reviewInfo = new ArrayList<>();
            reviewInfo.add(rating);
            reviewInfo.add(comment);
            reviewInfo.add(userID);
            finalReviewList.add(reviewInfo);
        }
        return finalReviewList;
    }

    public ArrayList<ArrayList<Object>> getUserReviews(String username){
        User specificUser = Constants.USERSECURITY.getUserByID(username);
        HashMap<Integer, Review> reviewList = specificUser.getUserReviews();

        ArrayList<ArrayList<Object>> finalReviewList = new ArrayList<>();
        for (Review review: reviewList.values()){
            int rating = review.getRating();
            int recipeID = review.getRecipeID();
            String recipeName = Constants.GENRELIBRARY.getRecipeByID("All", recipeID).getName();
            String comment = review.getComments();
            ArrayList<Object> reviewInfo = new ArrayList<>();
            reviewInfo.add(rating);
            reviewInfo.add(comment);
            reviewInfo.add(recipeID);
            reviewInfo.add(recipeName);
            finalReviewList.add(reviewInfo);
        }
        return finalReviewList;
    }


}

