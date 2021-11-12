package Commands;

import Controllers.UserRequestRecipeView;
import Controllers.UserRequestSaveRecipe;
import Presenters.RecipeDisplay;

import java.util.ArrayList;
import java.util.Scanner;

public class SaveRecipe extends RecipeCommand {
    public static String COMMANDSTRING = "save recipe";

    SaveRecipe(){
        setCOMMANDSTRING(COMMANDSTRING);
    }

    @Override
    public void execute(String username) throws Exception {
        System.out.println("An error has occurred.");
    }

    @Override
    public void execute(String username, String recipeID) throws Exception {
        setVIEWEDRECIPE(recipeID);
        UserRequestSaveRecipe save = new UserRequestSaveRecipe();
        try {
            save.saveRecipe(username, recipeID);
            System.out.println("Recipe has been saved!");
        } catch (Exception e){
            System.out.println("Recipe has already been saved.");
        }

    }
}
