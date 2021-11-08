package Controllers;

import Entities.Review;
import UseCases.GetReview;
import UseCases.RecipeReviewAdd;

public class UserRequestCreateReview {
    public Review reviewRecipe(String userID, String recipeID, String comment, int rating) throws Exception{
        if ((rating > 5) || (rating < 1)){
            throw new Exception("Data is incomplete!");
        }
        Review review = new Review(userID, recipeID, comment,rating);// should this review be added to a csv file?
        RecipeReviewAdd recipeAdd = new RecipeReviewAdd();
        recipeAdd.addReview(review);
        return review;
    }

}
