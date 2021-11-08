package Commands;

import Controllers.UserRequestBrowse;
import Presenters.ListDisplay;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewGenres extends Command {
    public static String COMMANDSTRING = "view genres";

    ViewGenres(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new ViewGenreRecipes());
    }


    @Override
    public void execute(String username) {
        UserRequestBrowse browse = new UserRequestBrowse();
        ListDisplay display = new ListDisplay();
        ArrayList<String> lst = browse.browseGenres(username);
        display.DisplayGenre(lst);
    }

}
