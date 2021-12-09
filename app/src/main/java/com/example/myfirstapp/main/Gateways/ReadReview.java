package com.example.myfirstapp.main.Gateways;

import com.example.myfirstapp.main.Entities.Review;
import com.google.firebase.database.DataSnapshot;

/**
 * This class is responsible for reading Review data.
 */
public class ReadReview {

    /**
     * Reads reviews from the database.
     * @param reviewSnapshot is a dataSnapshot object with an individual review as its root node
     * @return a Review object
     */
    public static Review readReview(DataSnapshot reviewSnapshot) {
        // get review attributes
        int recipeID = reviewSnapshot.child("recipeID").getValue(int.class);
        String username = reviewSnapshot.child("username").getValue(String.class);
        String comments = reviewSnapshot.child("comments").getValue(String.class);
        int rating = reviewSnapshot.child("rating").getValue(int.class);

        // construct a new Review object
        return new Review(username, recipeID, comments, rating);
    }
}