package UseCases;

import Entities.Preview;

import java.util.ArrayList;
import java.util.Arrays;

public class FilterRecipes {

    public ArrayList<Preview> recipes;
    public String key;

    public FilterRecipes(ArrayList<Preview> recipes, String filterkey) {
        this.recipes = recipes;
        this.key = filterkey;
    }

    public ArrayList<Preview> filterRecipes() {
        ArrayList<Preview> filtered_recipes = new ArrayList<>();
        for (Preview recipe: this.recipes) {
            if (recipe.getGenre().contains(this.key)) {
                filtered_recipes.add(recipe);
            }
        }
        return filtered_recipes;
    }
}
