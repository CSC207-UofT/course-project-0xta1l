package UseCases;

import Entities.Preview;
import Constants.*;

import java.util.ArrayList;
import java.util.Arrays;

public class FilterRecipes {

    public ArrayList<Preview> recipes;
    public String key;

    public FilterRecipes(ArrayList<Preview> recipes, String filterkey) {
        this.recipes = recipes;
        this.key = filterkey;
    }

    public ArrayList<Preview> filterRecipes() throws Exception {
        ArrayList<Preview> filtered_recipes = new ArrayList<>();
        if (Constants.GENRELIBRARY.getAllGenres().contains(key)) {
            for (Preview recipe : this.recipes) {
                if (recipe.getGenre().contains(this.key)) {
                    filtered_recipes.add(recipe);
                }
            }
        } else {
            throw new Exception();
        }
        return filtered_recipes;
    }
}
