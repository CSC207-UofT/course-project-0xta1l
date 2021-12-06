package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Preview;

import java.util.ArrayList;

public class FilterRecipes {

    public ArrayList<Preview> recipes;
    public String key;

    /**
     * Sorts recipes by a filter key
     *
     * @param recipes   is the list of recipe previews
     * @param filterkey the key you want to filter by
     * @return void
     */
    public FilterRecipes(ArrayList<Preview> recipes, String filterkey) {
        this.recipes = recipes;
        this.key = filterkey;
    }

    public ArrayList<Preview> filterRecipes() {
        ArrayList<Preview> filtered_recipes = new ArrayList<>();
        for (Preview recipe : this.recipes) {
            if (recipe.getGenre().contains(this.key)) {
                filtered_recipes.add(recipe);
            }
        }
        return filtered_recipes;
    }
}
