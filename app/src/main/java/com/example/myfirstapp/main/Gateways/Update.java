package com.example.myfirstapp.main.Gateways;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * This class is responsible for updating existing entries in the database.
 */
public class Update {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();

    /**
     * Updates a recipe's rating
     */
    public static void recipeRating(Recipe recipe) {
        DatabaseReference recipeRatingRef = database.getReference("recipes/" + recipe.getID() + "/rating");
        DatabaseReference recipeRatingListRef = database.getReference("recipes/" + recipe.getID() + "/ratingList");
        recipeRatingRef.setValue(recipe.getRating());
        recipeRatingListRef.setValue(recipe.getRatingList());
    }

    /**
     * Updates a user's saved recipes list
     */
    public static void recipesSaved(User user) {
        DatabaseReference userSavedRef = database.getReference("users/" + user.getUsername() + "/SavedRecipes");
        userSavedRef.setValue(null);
        for (Recipe recipe : user.getSavedRecipes()) {
            DatabaseReference recipeRef = database.getReference("users/" + user.getUsername() + "/SavedRecipes/" + recipe.getID());
            recipeRef.setValue(recipe);
        }
    }

    /**
     * Updates a User and Recipe's list of reviews
     */
    public static void reviewCreated(Review review) {
        DatabaseReference userReviewsRef = database.getReference("users/" + review.getUsername() + "/UserReviews/" + review.getRecipeID());
        DatabaseReference recipeReviewsRef = database.getReference("recipes/" + review.getRecipeID() + "/RecipeReviews/" + review.getUsername());

        userReviewsRef.setValue(review);
        recipeReviewsRef.setValue(review);
    }

    /**
     * Updates a specified property of the user's profile
     *
     * @param username     is the username of the user
     * @param property     is the value of the property
     * @param propertyName is the name of the property being changed
     */
    public static void userProfile(String username, Object property, String propertyName) {
        DatabaseReference userRef = database.getReference("users/" + username + "/" + propertyName);
        userRef.setValue(property);
    }

    /**
     * Deletes a user's reference at their old username, and
     * creates a new reference at their new username
     *
     * @param oldUsername is their previous username
     * @param newUsername is their changed username
     * @param user        is the user whose username is changing
     */
    public static void username(String oldUsername, String newUsername, User user) {
        DatabaseReference userRef = database.getReference("users/" + oldUsername);
        userRef.removeValue();
        DatabaseReference newUserRef = database.getReference("users/" + newUsername);
        newUserRef.setValue(user);
    }

    /**
     * Updates a user's list of genre weights
     */
    public static void userGenreWeights(User user) {
        DatabaseReference userRef = database.getReference("users/" + user.getUsername() + "/genreWeights");
        userRef.setValue(user.getGenreWeights());
    }
}
