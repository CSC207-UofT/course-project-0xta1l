package Controllers;

import UseCases.GetReview;

public class UserRequestReview {
    public boolean reviewRecipe(String userID, String recipeID, String comment, int rating) throws Exception{
        if (rating > 5) or (rating < 1){ // what will be the format on reviewData?
            throw new Exception("Data is incomplete!");
        }
        Boolean reviewAdded = RecipeReviewAdd.addReview(userID, recipeID, comment, rating); // useCase was not implemented prior; should i implement it?

        if (reviewAdded){
            return true;
        }
        return false;
    }

}
