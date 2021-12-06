package com.example.myfirstapp.main.Gateways;

import com.example.myfirstapp.main.Entities.Review;
import com.google.firebase.database.DataSnapshot;

public class ReadReview {
    public static Review readReview(DataSnapshot reviewSnapshot) {
        int recipeID = reviewSnapshot.child("recipeID").getValue(int.class);
        String username = reviewSnapshot.child("username").getValue(String.class);
        String comments = reviewSnapshot.child("comments").getValue(String.class);
        int rating = reviewSnapshot.child("rating").getValue(int.class);

        return new Review(username, recipeID, comments, rating);
    }
}