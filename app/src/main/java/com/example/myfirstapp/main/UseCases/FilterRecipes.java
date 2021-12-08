package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Preview;

import java.util.ArrayList;

public class FilterRecipes {

    public ArrayList<Preview> recipes;
    public String key;

    /**
     * FilterRecipes constructor
     *
     * @param recipes   is the list of recipe previews
     * @param filterkey the key you want to filter by
     */
    public FilterRecipes(ArrayList<Preview> recipes, String filterkey) {
        this.recipes = recipes;
        this.key = filterkey;
    }

    /**
     * Filters the stored list of recipes by a filter key
     *
     * @return list of recipe previews that include the genre filtered
     */
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
