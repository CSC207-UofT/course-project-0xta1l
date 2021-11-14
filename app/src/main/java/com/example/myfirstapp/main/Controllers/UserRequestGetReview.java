package Controllers;

import Entities.Review;

import java.util.ArrayList;

public class UserRequestGetReview {
    public ArrayList<ArrayList<Object>> getrecipereview(String recipeID){
        int ID = Integer.parseInt(recipeID);
        UseCases.GetReview getrecreview = new UseCases.GetReview();
        return getrecreview.getRecipeReviews(ID);
    }

    public ArrayList<ArrayList<Object>> getuserreview(String username)   {
            UseCases.GetReview getusereview= new UseCases.GetReview();
            return getusereview.getUserReviews(username);

        }

    }

