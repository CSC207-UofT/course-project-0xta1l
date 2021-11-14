package Commands;

import Controllers.UserRequestBrowse;
import Presenters.ListDisplay;

public class ViewSavedRecipes extends Command {
    public static String COMMANDSTRING = "view saved recipes";

    ViewSavedRecipes(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new ViewSavedRecipe());
        addSubCommands(new DeleteSavedRecipe());
    }


    @Override
    public void execute(String username) {
        UserRequestBrowse browse = new UserRequestBrowse();
        ListDisplay display = new ListDisplay();
        System.out.println("\n" + username + "'s Saved Recipes:");
        display.DisplayListOfRecipes(browse.browseSavedRecipes(username));
    }
}
