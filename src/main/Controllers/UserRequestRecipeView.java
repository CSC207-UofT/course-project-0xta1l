package Controllers;

import UseCases.GetRecipe;
import UI.RecipeDisplay;

public class UserRequestRecipeView {
    public void recipeView(int id) throws Exception {
        GetRecipe getRecipe = new GetRecipe();
        RecipeDisplay.showRecipe(getRecipe.getSingleRecipe(id,"full"));
    }
}
