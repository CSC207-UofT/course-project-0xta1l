package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Preview;

import java.util.ArrayList;
import java.util.Collections;

public class SortRecipes {
    /**
     * A class that sorts recipes.
     */

    // === Class Variables ===

    // The list of recipes to sort.
    public ArrayList<Preview> recipes;

    // Constructor that takes in a list of preview recipes
    public SortRecipes(ArrayList<Preview> previews) {
        this.recipes = previews;
    }

    // sorts recipes alphabetically
    public ArrayList<Preview> sort() {
        return alphabet();
    }

    public ArrayList<Preview> alphabet() {
        //sort alphabetically, implement directly in superclass
        ArrayList<Preview> output_lst = new ArrayList<Preview>();
        ArrayList<String> names = new ArrayList<String>();
        for (Preview preview : this.recipes) {
            String name = preview.getName();
            names.add(name);
        }
        Collections.sort(names);
        for (String name : names) {
            for (Preview preview : this.recipes) {
                if (preview.getName().equals(name)) {
                    output_lst.add(preview);
                }
            }
        }
        return output_lst;
    }
}


