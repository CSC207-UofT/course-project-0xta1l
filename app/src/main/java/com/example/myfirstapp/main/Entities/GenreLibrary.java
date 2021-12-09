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

    /**
     * Returns a HashMap of genres to HashMaps of RecipeIDs to Recipe entities
     */
    public HashMap<String, HashMap<Integer, Recipe>> getListOfAllRecipes() {
        return ListOfAllRecipes;
    }

    /**
     * Adds a recipe to the given genre
     *
     * @param genre the genre to add the recipe to
     * @param recipe the recipe to be added
     */
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

    /**
     * Gets a list of all genres
     */
    public ArrayList<String> getAllGenres() {
        return new ArrayList<>(this.ListOfAllRecipes.keySet());
    }

    /**
     * Gets a list of all genres except for "All".
     */
    public ArrayList<String> getUploadGenres() {
        ArrayList<String> a = new ArrayList<>(this.ListOfAllRecipes.keySet());
        a.remove("All");
        return a;
    }

    /**
     * Gets the recipes for a given genre
     *
     * @param genre the genre to retrieve recipes from
     * @return a HashMap of recipeIDs to recipes in the genre
     */
    public HashMap<Integer, Recipe> getAllRecipes(String genre) {
        return this.ListOfAllRecipes.get(genre);
    }

    /**
     * Gets the specified recipe from the specified genre
     *
     * @param genre the genre to search
     * @param id the ID of the recipe to get
     * @return the Recipe entity corresponding to the id
     */
    public Recipe getRecipeByID(String genre, int id) {
        return this.getAllRecipes(genre).get(id);
    }

    /**
     * Gets a list of all recipeIDs
     */
    public ArrayList<Integer> getAllRecipeId() {
        ArrayList<Integer> int_list = new ArrayList<>();
        for (String genre : ListOfAllRecipes.keySet()) {
            HashMap<Integer, Recipe> h = this.ListOfAllRecipes.get(genre);
            int_list.addAll(h.keySet());
        }
        return int_list;
    }

    /**
     * Gets a new ID value not yet assigned to an existing recipe
     */
    public int getNewId() {
        ArrayList<Integer> int_list = new ArrayList<>();
        for (String genre : ListOfAllRecipes.keySet()) {
            HashMap<Integer, Recipe> h = this.ListOfAllRecipes.get(genre);
            int_list.addAll(h.keySet());
        }
        return Collections.max(int_list) + 1;
    }
}
