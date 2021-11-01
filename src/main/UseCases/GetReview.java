package UseCases;

import Entities.*;
import Constants.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GetReview {

    public ArrayList<ArrayList<Object>> getRecipeReviews(int recipeID){
        // Implemented differently to CRC card. No use of hash map because Recipe.getRecipeReviews() returns
        // an ArrayList

        GenreLibrary genreLibrary = new GenreLibrary();
        Recipe specificRecipe = genreLibrary.getRecipeByID("All", recipeID);
        ArrayList<Review> reviewList = specificRecipe.getRecipeReviews();
        // HashMap<User, Review> reviewMap = specificRecipe.getRecipeReviews();

        ArrayList<ArrayList<Object>> finalReviewList = new ArrayList<>();
        for (Review review: reviewList){
            int rating = review.getRating();
            String userID = review.getUserID();
            String comment = review.getComments();
            finalReviewList.add(rating,comment,userID);
        }
        return finalReviewList;
    }

    public ArrayList<ArrayList<Object>> getUserReviews(String username){
        UserSecurity userSecurity = new UserSecurity();
        HashMap<String, User> userMap = userSecurity.getUsernames();
        User specificUser = userMap.get(username);
        ArrayList<Review> reviewList = specificUser.getUserReviews();

        ArrayList<ArrayList<Object>> finalReviewList = new ArrayList<>();
        for (Review review: reviewList){
            int rating = review.getRating();
            String recipeID = review.getRecipeID();
            String comment = review.getComments();
            finalReviewList.add(rating,comment,recipeID);
        }
        return finalReviewList;
    }

    public Review getSingle(String reviewID){

    }

}
