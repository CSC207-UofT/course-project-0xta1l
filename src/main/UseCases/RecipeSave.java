package UseCases;

import Entities.Recipe;
import Entities.User;

public class RecipeSave {

public RecipeSave(User user, Recipe recipe) throws Exception {
   for (Recipe rec: user.getSavedRecipes()) {
       if (rec.getID() != recipe.getID()){
           user.addSavedRecipes(recipe);
       } else{
           throw new Exception("Recipe is already saved");
       }

       }
       }



}