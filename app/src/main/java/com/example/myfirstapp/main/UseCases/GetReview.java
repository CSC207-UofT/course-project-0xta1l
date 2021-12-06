package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GetReview {
    /**
     * Gets the recipe reviews by recipeID
     *
     * @param specificRecipe is the recipe
     * @return list of recipe previews
     */
    public ArrayList<ArrayList<Object>> getRecipeReviews(Recipe specificRecipe) {
        // Cycles through all values in Recipe.getReviews HashMap and outputs relevant review info
        HashMap<String, Review> reviewMap = specificRecipe.getRecipeReviews();

        ArrayList<ArrayList<Object>> finalReviewList = new ArrayList<>();
        for (Review review : reviewMap.values()) {
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

    /**
     * Gets reviews written by a specified user
     *
     * @param specificUser is the specified user
     * @param genreLibrary is the collection of recipes to obtain recipe names from
     * @return list of reviews
     */
    public ArrayList<ArrayList<Object>> getUserReviews(GenreLibrary genreLibrary, User specificUser) {
        HashMap<Integer, Review> reviewList = specificUser.getUserReviews();

        ArrayList<ArrayList<Object>> finalReviewList = new ArrayList<>();
        for (Review review : reviewList.values()) {
            int rating = review.getRating();
            int recipeID = review.getRecipeID();
            String recipeName = genreLibrary.getRecipeByID("All", recipeID).getName();
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

