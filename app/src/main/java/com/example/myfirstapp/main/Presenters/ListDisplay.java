package com.example.myfirstapp.main.Presenters;


import com.example.myfirstapp.main.Entities.Preview;

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
}