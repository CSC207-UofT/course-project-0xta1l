package UseCases;

import Entities.*;
import Constants.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GetReview {

    public ArrayList<ArrayList<Object>> getRecipeReviews(int recipeID){
        // Cycles through all values in Recipe.getReviews HashMap and outputs relevant review info

        GenreLibrary genreLibrary = new GenreLibrary();
        Recipe specificRecipe = genreLibrary.getRecipeByID("All", recipeID);
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
            String comment = review.getComments();
            ArrayList<Object> reviewInfo = new ArrayList<>();
            reviewInfo.add(rating);
            reviewInfo.add(comment);
            reviewInfo.add(recipeID);
            finalReviewList.add(reviewInfo);
        }
        return finalReviewList;
    }


}
