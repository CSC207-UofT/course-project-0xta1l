package Entities;

public class Review {
    // NOTE: NOT USED IN SKELETON MODEL
    private String reviewID;
    private String recipeID;
    private String userID;
    private String comments;
    private int rating;

    public Review(String reviewID,String recipeID, String userID, String comments, int rating){
        this.rating = rating;
        this.recipeID = recipeID;
        this.userID = userID;
        this.comments =  comments;
        this.reviewID = reviewID;
    }
    public String getReviewID() {return reviewID;}
    public String getRecipeID() {return recipeID;}
    public String getUserID() {return userID;}
    public String getComments() {return comments;}
    public int getRating() {return rating;}


    public void setReviewID(String reviewID) {this.reviewID = reviewID;}
    public void setRecipeID(String recipeID) {this.recipeID = recipeID;}
    public void setUserID(String userID) {this.userID = userID;}
    public void setComments(String comments) {this.comments = comments;}
    public void setRating(int rating) {this.rating = rating;}
}

