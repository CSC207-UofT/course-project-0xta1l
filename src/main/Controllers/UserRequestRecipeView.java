package Controllers;

import UseCases.GetRecipe;
import Presenters.RecipeDisplay;

public class UserRequestRecipeView {
    public void recipeView(int id) throws Exception {
        GetRecipe getRecipe = new GetRecipe();
        RecipeDisplay r = new RecipeDisplay();
        r.showRecipe(getRecipe.getSingleRecipe(id,"full"));
    }
}
