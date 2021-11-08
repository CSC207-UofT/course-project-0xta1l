package UseCases;

import Entities.Review;
import Entities.User;
import Entities.UserSecurity;

public class RecipeReviewAdd {

    public Review addReview(String username,int recipeID, String comment, int rating) throws Exception {

        UserSecurity user = new UserSecurity();
        User accUser = user.getUserByID(username);
        Review review = new Review(username, recipeID, comment, rating);
        if (accUser.getUserReviews().containsKey(review.getReviewID())){
            throw new Exception("Review already exists");
        }
        else{
            review.saveToUser(username, review.getReviewID(), review);
            return review;
        }
    }
}
