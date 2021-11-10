package Presenters;


import Entities.FullPreview;

public class RecipeDisplay {
    public static void showRecipe(FullPreview recipeFull) {
        System.out.println("RecipeID: " + recipeFull.getID());
        System.out.println("Recipe Name: " + recipeFull.getName());
        System.out.println("Rating: " + recipeFull.getRating());
        System.out.println("Genres: " + recipeFull.getGenre());
        System.out.println("Prep Time: " + recipeFull.getDescription());
        System.out.println("Description: " + recipeFull.getDescription());
        System.out.println("Ingredients: " + recipeFull.getIngredients());
        System.out.println("Instructions: " + recipeFull.getInstructions());
    }
}
