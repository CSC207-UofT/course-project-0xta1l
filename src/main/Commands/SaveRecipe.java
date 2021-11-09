package Commands;

import Controllers.UserRequestRecipeView;
import Controllers.UserRequestSaveRecipe;
import Presenters.RecipeDisplay;

import java.util.ArrayList;
import java.util.Scanner;

public class SaveRecipe extends Command {
    public static String COMMANDSTRING = "save recipe";

    SaveRecipe(){
        setCOMMANDSTRING(COMMANDSTRING);
    }


    @Override
    public void execute(String username) throws Exception {
        UserRequestSaveRecipe save = new UserRequestSaveRecipe();

        // TODO figure out how to pass viewed recipe id
        //RecipeDisplay display = new RecipeDisplay();
        //ArrayList<Object> recipe = view.recipeView(recipeID);
        //display.showRecipe(recipe);
    }
}
