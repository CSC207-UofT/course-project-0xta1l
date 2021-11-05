package Commands;

import Controllers.UserRequestBrowse;
import Presenters.ListDisplay;

import java.util.ArrayList;

public class ViewGenres extends Command {
    public static String COMMANDSTRING = "view genres";
    public static ArrayList<Command> subCommands= new ArrayList<>();

    ViewGenres(){
        setCOMMANDSTRING(COMMANDSTRING);}

    @Override
    public void execute(String username) {
        UserRequestBrowse browse = new UserRequestBrowse();
        ListDisplay display = new ListDisplay();
        ArrayList<String> lst = browse.browseGenres(username);
        display.DisplayGenre(lst);
    }

}
