package Commands;

import Controllers.UserRequestRecipeView;
import Presenters.RecipeDisplay;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewRecipe extends Command {
    public static String COMMANDSTRING = "view recipe";

    ViewRecipe(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new SaveRecipe());
    }


    @Override
    public void execute(String username) throws Exception {
        Scanner input = new Scanner(System.in);
        String recipeID = input.nextLine();
        UserRequestRecipeView view = new UserRequestRecipeView();

        // TODO Instantiation of utility class 'RecipeDisplay'
        RecipeDisplay display = new RecipeDisplay();
        ArrayList<Object> recipe = view.recipeView(recipeID);
        display.showRecipe(recipe);
    }

}
