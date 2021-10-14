package Entities;

import Entities.Recipe;

import java.util.ArrayList;

public class RecipeLibrary {
    private ArrayList<Recipe> ListOfAllRecipes= new ArrayList<>();

    public ArrayList<Recipe> getListOfAllRecipes() {
        return ListOfAllRecipes;
    }

    public void addRecipes(Recipe recipe) {
        ListOfAllRecipes.add(recipe) ;
    }

}
