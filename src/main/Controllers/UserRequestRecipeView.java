package Controllers;

import UseCases.GetRecipe;
import Presenters.RecipeDisplay;

import java.util.ArrayList;

public class UserRequestRecipeView {
    public Entities.Preview recipeView(String id) throws Exception {
        GetRecipe getRecipe = new GetRecipe();
        try {
            return getRecipe.getSingleRecipe(Integer.parseInt(id),"full");
        } catch (Exception e) {
            System.out.println("Not a valid recipe ID.");
        }
        return getRecipe.getSingleRecipe(Integer.parseInt(id),"full");
    }
}
