package Controllers;

import Entities.Review;
import UseCases.GetReview;
import UseCases.RecipeReviewAdd;

public class UserRequestCreateReview { // database should be called here to write recipe to database
    public Review reviewRecipe(String userID, int recipeID, String comment, int rating) throws Exception {
        RecipeReviewAdd recipeAdd = new RecipeReviewAdd();
        return recipeAdd.addReview(userID, recipeID, comment, rating);
    }

}
