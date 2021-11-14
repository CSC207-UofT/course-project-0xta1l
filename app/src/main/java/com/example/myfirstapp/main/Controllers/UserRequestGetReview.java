package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Review;

import java.util.ArrayList;

public class UserRequestGetReview {
    public ArrayList<ArrayList<Object>> getrecipereview(String recipeID){
        int ID = Integer.parseInt(recipeID);
        com.example.myfirstapp.main.UseCases.GetReview getrecreview = new com.example.myfirstapp.main.UseCases.GetReview();
        return getrecreview.getRecipeReviews(ID);
    }

    public ArrayList<ArrayList<Object>> getuserreview(String username)   {
        com.example.myfirstapp.main.UseCases.GetReview getusereview= new com.example.myfirstapp.main.UseCases.GetReview();
            return getusereview.getUserReviews(username);

        }

    }

