package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestBrowse;
import com.example.myfirstapp.main.Presenters.ListDisplay;

import java.util.ArrayList;

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
