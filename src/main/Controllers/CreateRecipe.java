package Controllers;


import Entities.Recipe;
import Entities.Review;
import UseCases.RecipeCreate;

import java.util.ArrayList;

public class CreateRecipe {
    public Entities.Recipe recipe(String instructions, String ingredients, ArrayList<String> genres, String name,
                                  String rating, String ID, ArrayList<Review> RecipeReviews, String image,
                                  String descriptions, String preptime) {
        int a = Integer.parseInt(rating);
        int b = Integer.parseInt(ID);
        int c = Integer.parseInt(preptime);
        RecipeCreate recipeCreate = new RecipeCreate();
        Recipe rec = recipeCreate.CreateRecipeFromUser(instructions, ingredients, genres, name, a, b, RecipeReviews, image, descriptions,
                c);
        return rec;
    }
}



