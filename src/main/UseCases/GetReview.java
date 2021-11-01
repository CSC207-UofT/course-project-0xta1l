package UseCases;

import java.util.ArrayList;
import Constants.*;
import Entities.Recipe;
import Entities.Review;
import Entities.User;

public class GetReview{
    public ArrayList<Review> fromUser (String username){
        User user = Constants.USERSECURITY.getUserByID(username);
        return user.getUserReviews();
    }

    public ArrayList<Review> fromRecipe (String recipeID){
        Recipe recipe = Constants.GENRELIBRARY.getRecipeByID("All", Integer.parseInt(recipeID));
        return recipe.getRecipeReviews();
    }
}
