package com.example.myfirstapp.main.Presenters;


import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.Review;

import java.util.ArrayList;

public class ListDisplay {
    public void DisplayGenre(ArrayList<String> browseInfo) {
        for(String str: browseInfo){
            System.out.println(str);
        }
    }
    public void DisplayListOfRecipes(ArrayList<Preview> browseInfo) {
        if (browseInfo.size() == 0){
            System.out.println("No recipes to display.");
        } else{
            for (Preview recipe : browseInfo) {
                System.out.println("Recipe ID: " + recipe.getID());
                System.out.println("Recipe Name: " + recipe.getName());
                System.out.println("Recipe Rating: " + recipe.getRating() + "\n");
            }
        }
    }
    public void recipeReviews(ArrayList<ArrayList<Object>> reviews) {
        if (reviews.size() == 0){
            System.out.println("No reviews to display.");
        } else{
            for (ArrayList<Object> review : reviews) {
                System.out.println("User: " + review.get(2));
                System.out.println("Rating (out of 5): " + review.get(0));
                System.out.println("Comment: " + review.get(1) + "\n");
            }
        }
    }

    public void userReviews(ArrayList<ArrayList<Object>> reviews) {
        if (reviews.size() == 0){
            System.out.println("No reviews to display.");
        } else{
            for (ArrayList<Object> review : reviews) {
                System.out.println("Recipe ID: " + review.get(2));
                System.out.println("Recipe Name: " + review.get(3));
                System.out.println("Rating (out of 5): " + review.get(0));
                System.out.println("Comment: " + review.get(1) + "\n");
            }
        }
    }
}