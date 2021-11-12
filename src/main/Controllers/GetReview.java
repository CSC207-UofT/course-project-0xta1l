package Controllers;

import Entities.Review;

import java.util.ArrayList;

public class GetReview {
    public ArrayList<ArrayList<Object>> getrecipereview(String recipeID){
        int ID = Integer.parseInt(recipeID);
        UseCases.GetReview getrecreview = new UseCases.GetReview();
        ArrayList<ArrayList<Object>> getre = getrecreview.getRecipeReviews(ID);
        return getre;
    }

    public ArrayList<ArrayList<Object>> getuserreview(String username)   {
            UseCases.GetReview getusereview= new UseCases.GetReview();
            ArrayList<ArrayList<Object>> getuser = getusereview.getUserReviews(username);
            return getuser;

        }

    }

