package Presenters;


import java.util.ArrayList;

public class RecipeDisplay {
    public static void showRecipe(ArrayList<Object> recipeFull) {
        System.out.println("hello");
        System.out.println("RecipeID: " + recipeFull.get(0));
        System.out.println("Recipe Name: " + recipeFull.get(1));
        System.out.println("Recipe Rating: " + recipeFull.get(2));
        System.out.println("Recipe Genre: " + recipeFull.get(3));
        System.out.println("Recipe Description: " + recipeFull.get(4));
        System.out.println("Recipe Ingredients: " + recipeFull.get(5));
        System.out.println("Recipe Instructions: " + recipeFull.get(6));
    }
}
