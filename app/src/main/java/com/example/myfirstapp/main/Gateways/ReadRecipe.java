package com.example.myfirstapp.main.Gateways;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

/**
 * This class is responsible for reading Recipe data.
 */
public class ReadRecipe {

    /**
     * Reads recipes from the database.
     *
     * @param singleRecipeRef is a dataSnapshot object with an individual recipe as its root node
     * @return a Recipe object
     */
    public static Recipe readRecipe(DataSnapshot singleRecipeRef) {
        // Read recipe attributes from singleRecipeRef
        int recipeID = singleRecipeRef.child("id").getValue(Integer.class);
        String recipeDescription = singleRecipeRef.child("description").getValue(String.class);
        ArrayList<String> recipeGenres = new ArrayList<>();
        DataSnapshot recipeGenreListDatabase = singleRecipeRef.child("genre");
        for (DataSnapshot genre : recipeGenreListDatabase.getChildren()) {
            recipeGenres.add(genre.getValue(String.class));
        }
        String recipeImage = singleRecipeRef.child("image").getValue(String.class);
        String recipeIngredients = singleRecipeRef.child("ingredients").getValue(String.class);
        String recipeInstructions = singleRecipeRef.child("instructions").getValue(String.class);
        String recipeName = singleRecipeRef.child("name").getValue(String.class);
        int recipePreptime = recipePrepReader(singleRecipeRef);
        int recipeRating = recipeRatingReader(singleRecipeRef);

        // Construct and a new recipe
        Recipe newRecipe = new Recipe(recipeInstructions, recipeIngredients,
                recipeGenres, recipeName, recipeRating, recipeID, recipeImage,
                recipeDescription, recipePreptime);

        // Update the saved recipes attribute
        loadRecipeSavedReviews(singleRecipeRef, newRecipe);

        return newRecipe;
    }

    /**
     * Update a Recipe object's saved recipes by loading them in from the database.
     *
     * @param singleRecipeRef is a dataSnapshot object with an individual recipe as its root node
     * @param newRecipe       is the newly constructed Recipe object that will be updated
     */
    private static void loadRecipeSavedReviews(DataSnapshot singleRecipeRef, Recipe newRecipe) {
        // Load in saved reviews
        DataSnapshot recipeReviewsSnapshot = singleRecipeRef.child("RecipeReviews");
        for (DataSnapshot recipeReviewSnap : recipeReviewsSnapshot.getChildren()) {
            Review recipeReview = ReadReview.readReview(recipeReviewSnap);
            newRecipe.addSavedReviews(recipeReview.getUsername(), recipeReview);
        }
    }

    /**
     * Reads the prep time attribute of a recipe. Default return 60 minutes if there is none.
     *
     * @param singleRecipeRef is a dataSnapshot object with an individual recipe as its root node
     * @return the recipe's prep time
     */
    private static int recipePrepReader(DataSnapshot singleRecipeRef) {
        // Check if the recipe from the database has a valid prep time attribute.
        // If it does, return the prep time attribute value.
        if (singleRecipeRef.child("prep time").exists()) {
            Object recipePrepHolder = singleRecipeRef.child("preptime").getValue();

            if (recipePrepHolder instanceof Integer) {
                return (Integer) recipePrepHolder;
            }
        }
        // If no eligible value for prep time exists, return default value of 60 minutes.
        return 60;
    }

    /**
     * Reads the rating attribute of a recipe. Return 3 as a default is there is no readable rating.
     *
     * @param singleRecipeRef is a dataSnapshot object with an individual recipe as its root node
     * @return a recipe's rating
     */
    private static int recipeRatingReader(DataSnapshot singleRecipeRef) {
        // Check if the recipe from the database has a valid rating attribute.
        // If it does, return the rating attribute value.
        if (singleRecipeRef.child("rating").exists()) {
            if (!(singleRecipeRef.child("rating").getValue(Integer.class) == null)) {
                return singleRecipeRef.child("rating").getValue(Integer.class);
            }
        }
        // If no eligible value for rating exists, return default value of 3.
        return 3;
    }
}
