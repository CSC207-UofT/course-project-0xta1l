package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.UseCases.GetReview;

import java.util.ArrayList;

public class UserRequestGetReview {
    public ArrayList<ArrayList<Object>> getrecipereview(String recipeID){
        int ID = Integer.parseInt(recipeID);

        GetReview getrecreview = new GetReview();
        return getrecreview.getRecipeReviews(ID);
    }

    public ArrayList<ArrayList<Object>> getuserreview(String username)   {

            GetReview getusereview= new GetReview();
            return getusereview.getUserReviews(username);

        }

    }

