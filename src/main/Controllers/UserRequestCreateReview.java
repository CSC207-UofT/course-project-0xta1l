package Controllers;

import UseCases.GetReview;

public class UserRequestReview {
    public boolean reviewRecipe(String userID, String recipeID, String reviewData) throws Exception{
        if (!(1<= reviewData.rating <= 5)){ // what will be the format on reviewData?
            throw new Exception("Data is incomplete!");
        }
        Boolean reviewAdded = RecipeReviewAdd.addReview(userID, recipeID, reviewData); // useCase was not implemented prior; should i implement it?
        UserInputStatus(reviewAdded); // this is not created; will this be a thing?
        if (reviewAdded){
            return true;
        }
        return false;
    }

}
