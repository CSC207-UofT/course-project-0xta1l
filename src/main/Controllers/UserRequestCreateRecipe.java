package Controllers;


import Entities.Recipe;
import Entities.Review;
import UseCases.RecipeCreate;

import java.util.ArrayList;
import java.util.Arrays;

public class UserRequestCreateRecipe {
    public Entities.Recipe recipe(String username, String instructions, String ingredients, String genres, String name,
                                  String rating, String ID, String image,
                                  String descriptions, String preptime) {
        int ratingInt = Integer.parseInt(rating);
        // TODO: UPDATE ALL INSTANCES OF RECIPE CREATION TO GET AUTOINCREMENT FROM DB, ALSO WE NEED TO FIGURE OUT RATINGS FOR NEW RECIPES
        int IDint = Integer.parseInt(ID);
        int prepInt = Integer.parseInt(preptime);
        ArrayList<String> genresList = new ArrayList<>(Arrays.asList(genres.split(",\\s*")));
        RecipeCreate recipeCreate = new RecipeCreate();
        return recipeCreate.CreateRecipeFromUser(username, instructions, ingredients, genresList, name, ratingInt, IDint, image, descriptions,
                prepInt);
    }
}



