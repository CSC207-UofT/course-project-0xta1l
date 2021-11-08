package UseCases;

import Entities.Recipe;

import java.util.ArrayList;
import java.util.Collections;

public class SortRecipes {
    /**
     * A class that sorts recipes.
     */

    // === Class Variables ===

    // The list of recipes to sort.
    public ArrayList<Recipe> recipes;

    // Constructor that takes in a list of preview recipes
    public SortRecipes(ArrayList<Recipe> previews) {
        this.recipes = previews;
    }

    // sorts recipes alphabetically
    public ArrayList<Recipe> sort() {
            return alphabet();
    }

    public ArrayList<Recipe> alphabet(){
        //sort alphabetically, implement directly in superclass
        ArrayList<Recipe> output_lst = new ArrayList<Recipe>();
        ArrayList<String> names = new ArrayList<String>();
        for (Recipe preview : this.recipes) {
            String name = preview.getName();
            names.add(name);
        }
        Collections.sort(names);
        for (String name : names) {
            for (Recipe preview : this.recipes) {
                if (preview.getName().equals(name)) {
                    output_lst.add(preview);
                }
            }
        }
        return output_lst;
    }
}


