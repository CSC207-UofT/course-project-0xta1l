package Commands;

import Controllers.UserRequestBrowse;
import Entities.Preview;
import Presenters.ListDisplay;

import java.util.ArrayList;

public class ViewGenreRecipes extends Command {
    public static String COMMANDSTRING = "view genre recipes";

    ViewGenreRecipes(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new ViewRecipe());
    }


    @Override
    public void execute(String genre) {
        // how do we pass in multiple values (eg we still want to store the user's id at this point)
        UserRequestBrowse browse = new UserRequestBrowse();
        ListDisplay display = new ListDisplay();
        ArrayList<Preview> lst = browse.browseGenreRecipes(genre);
        display.DisplayListOfRecipes(lst);
    }

}
