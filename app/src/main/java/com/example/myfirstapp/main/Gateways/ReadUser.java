package com.example.myfirstapp.main.Gateways;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for reading User information from the database.
 */
public class ReadUser {

    /**
     * Reads users from the database.
     *
     * @param singleUserRef is a dataSnapshot object with an individual user as its root node
     * @return a User object
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static User readUser(DataSnapshot singleUserRef) {
        // Read user attributes from singleUserRef
        String userUsername = singleUserRef.child("username").getValue(String.class);
        String userDisplayName = singleUserRef.child("displayName").getValue(String.class);
        String userPassword = singleUserRef.child("password").getValue(String.class);
        String userBiography = singleUserRef.child("biography").getValue(String.class);
        int userAge = singleUserRef.child("age").getValue(Integer.class);
        ArrayList<String> userInterests = new ArrayList<>();
        DataSnapshot userInterestSnapshot = singleUserRef.child("interests");
        for (DataSnapshot interest : userInterestSnapshot.getChildren()) {
            userInterests.add(interest.getValue(String.class));
        }

        // Construct a new user object
        User newUser = new User(userUsername, userPassword, userDisplayName,
                userAge, userBiography, userInterests, Constants.GENRELIST);

        // Update user attributes that were missed in the constructor
        loadUserSavedRecipes(singleUserRef, newUser);
        loadUserGenreWeights(singleUserRef, newUser);
        loadUserSavedReviews(singleUserRef, newUser);

        return newUser;
    }

    /**
     * Update a User object by adding its saved reviews attribute.
     *
     * @param singleUserRef is a dataSnapshot object with an individual user as its root node
     * @param newUser       is the newly constructed User object that will be updated
     */
    private static void loadUserSavedReviews(DataSnapshot singleUserRef, User newUser) {
        // Load in user saved reviews
        DataSnapshot userReviewsSnapshot = singleUserRef.child("UserReviews");
        for (DataSnapshot userReviewSnap : userReviewsSnapshot.getChildren()) {
            Review userReview = ReadReview.readReview(userReviewSnap);
            newUser.addSavedReviews(userReview.getRecipeID(), userReview);
        }
    }

    /**
     * Update a User object by adding its genre weights attribute.
     *
     * @param singleUserRef is a dataSnapshot object with an individual user as its root node
     * @param newUser       is the newly constructed User object that will be updated
     */
    private static void loadUserGenreWeights(DataSnapshot singleUserRef, User newUser) {
        Map<String, Double> userGenreWeights = new HashMap<>();
        DataSnapshot userGenreWeightsSnapshot = singleUserRef.child("genreWeights");
        for (DataSnapshot genreWeightSnap : userGenreWeightsSnapshot.getChildren()) {
            String genreWeightName = genreWeightSnap.getKey();
            Double genreWeightValue = genreWeightSnap.getValue(Double.class);
            newUser.updateGenreWeight(genreWeightName, genreWeightValue);
        }
    }

    /**
     * Update a User object by adding its saved recipes attribute.
     *
     * @param singleUserRef is a dataSnapshot object with an individual user as its root node
     * @param newUser       is the newly constructed User object that will be updated
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void loadUserSavedRecipes(DataSnapshot singleUserRef, User newUser) {
        // Load in user saved recipes
        DataSnapshot userSavedRecipeSnapshot = singleUserRef.child("SavedRecipes");
        for (DataSnapshot savedRecipeSnap : userSavedRecipeSnapshot.getChildren()) {
            Recipe savedRecipe = ReadRecipe.readRecipe(savedRecipeSnap);
            newUser.addSavedRecipes(savedRecipe);
        }
    }

}