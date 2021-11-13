package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Review;

import java.util.ArrayList;

public class GetReview {
    public ArrayList<ArrayList<Object>> getrecipereview(String recipeID){
        int ID = Integer.parseInt(recipeID);
        com.example.myfirstapp.main.UseCases.GetReview getrecreview = new com.example.myfirstapp.main.UseCases.GetReview();
        ArrayList<ArrayList<Object>> getre = getrecreview.getRecipeReviews(ID);
        return getre;
    }

    public ArrayList<ArrayList<Object>> getuserreview(String username)   {
        com.example.myfirstapp.main.UseCases.GetReview getusereview= new com.example.myfirstapp.main.UseCases.GetReview();
            ArrayList<ArrayList<Object>> getuser = getusereview.getUserReviews(username);
            return getuser;

        }

    }

