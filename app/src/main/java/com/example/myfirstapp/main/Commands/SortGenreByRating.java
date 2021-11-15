package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestBrowse;
import com.example.myfirstapp.main.Controllers.UserRequestSort;
import com.example.myfirstapp.main.Presenters.ListDisplay;

import java.util.ArrayList;

public class SortGenreByRating extends GenreCommand {
    public static String COMMANDSTRING = "sort genre by rating";

    SortGenreByRating(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new ViewRecipe());
    }


    @Override
    public void execute(String username) {
        System.out.println("An error has occurred. Please try again.");
    }

    @Override
    public void execute(String username, ArrayList<String> genres) {
        setVIEWEDGENRES(genres);
        UserRequestBrowse browse = new UserRequestBrowse();
        UserRequestSort sort = new UserRequestSort();
        ListDisplay display = new ListDisplay();
        display.DisplayListOfRecipes(sort.sort(browse.browseGenreRecipes(genres.get(0)),"Rating"));

    }
}
