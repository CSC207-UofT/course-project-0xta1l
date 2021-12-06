package com.example.myfirstapp.main.Entities;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is the GenreLibrary Entity. It possesses 1 attribute:
 * •ListOfAllRecipes - A hashmap of String genres, to a hashmap of recipeIDs to Recipe entities
 */

public class GenreLibrary {
    public HashMap<String, HashMap<Integer, Recipe>> ListOfAllRecipes = new HashMap<>();

    public HashMap<String, HashMap<Integer, Recipe>> getListOfAllRecipes() {
        return ListOfAllRecipes;
    }

    public void addRecipes(String genre, Recipe recipe) {
        if (!this.ListOfAllRecipes.containsKey(genre)) {
            HashMap<Integer, Recipe> recipe_map = new HashMap<>();
            recipe_map.put(recipe.getID(), recipe);
            this.ListOfAllRecipes.put(genre, recipe_map);
        } else {
            HashMap<Integer, Recipe> recipe_map = this.ListOfAllRecipes.get(genre);
            recipe_map.put(recipe.getID(), recipe);
        }
    }


    public ArrayList<String> getAllGenres() {
        return new ArrayList<>(this.ListOfAllRecipes.keySet());
    }

    public ArrayList<String> getUploadGenres() {
        ArrayList<String> a = new ArrayList<>(this.ListOfAllRecipes.keySet());
        if (a.contains("All")) {
            a.remove("All");
        }
        return a;
    }

    public HashMap<Integer, Recipe> getAllRecipes(String genre) {
        return this.ListOfAllRecipes.get(genre);
    }

    public Recipe getRecipeByID(String genre, int id) {
        return this.getAllRecipes(genre).get(id);
    }

    public ArrayList<Integer> getAllRecipeId() {
        ArrayList<Integer> int_list = new ArrayList<>();
        for (String genre : ListOfAllRecipes.keySet()) {
            HashMap<Integer, Recipe> h = this.ListOfAllRecipes.get(genre);
            int_list.addAll(h.keySet());
        }
        return int_list;
    }

    public int getNewId() {
        ArrayList<Integer> int_list = new ArrayList<>();
        for (String genre : ListOfAllRecipes.keySet()) {
            HashMap<Integer, Recipe> h = this.ListOfAllRecipes.get(genre);
            int_list.addAll(h.keySet());
        }
        int i = Collections.max(int_list) + 1;
        return i;
    }
}
