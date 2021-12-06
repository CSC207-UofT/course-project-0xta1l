package com.example.myfirstapp.main.Entities;

public class Review {
    /**
     * This class is the Review Entity. It possesses 5 attributes:
     * •rating - the rating given to the Recipe as designated by users (int from 1-5)
     * •reviewID - the unique identifier for the review (int)
     * •username - the username of the user that wrote a specific review (String)
     * •comments - the comments on the specific review
     */
    private int recipeID;
    private String username;
    private String comments;
    private int rating;

    public Review(String username, int recipeID, String comment, int rating) {
        this.username = username;
        this.recipeID = recipeID;
        this.comments = comment;
        this.rating = rating;
    }

    public int getRecipeID() {
        return recipeID;
    }

    public String getUsername() {
        return username;
    }

    public String getComments() {
        return comments;
    }

    public int getRating() {
        return rating;
    }


    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}

