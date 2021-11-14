package com.example.myfirstapp.main.Presenters;


import com.example.myfirstapp.main.Entities.FullPreview;

public class RecipeDisplay {
    public void showRecipe(FullPreview recipeFull) {
        System.out.println("RecipeID: " + recipeFull.getID());
        System.out.println("Recipe Name: " + recipeFull.getName());
        System.out.println("Rating: " + recipeFull.getRating());
        System.out.println("Genres: " + recipeFull.getGenre());
        System.out.println("Prep Time: " + recipeFull.getPreptime());
        System.out.println("Description: " + recipeFull.getDescription());
        System.out.println("Ingredients: " + recipeFull.getIngredients());
        System.out.println("Instructions: " + recipeFull.getInstructions());
    }
}