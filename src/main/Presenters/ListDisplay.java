package Presenters;


import Entities.Preview;

import java.util.ArrayList;

public class ListDisplay {
    public void DisplayGenre(ArrayList<String> browseInfo) {
        System.out.println("Genres: ");
        System.out.println("All");
        /*for(String str: browseInfo){
            System.out.println(str);
        }*/
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
}