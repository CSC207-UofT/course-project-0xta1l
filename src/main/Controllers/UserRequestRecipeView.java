package Controllers;

import UseCases.GetRecipe;
import Presenters.RecipeDisplay;

public class UserRequestRecipeView {
    public void recipeView(int id){
        RecipeDisplay.showRecipe(GetRecipe.getSingleRecipe(id));
    }
}
