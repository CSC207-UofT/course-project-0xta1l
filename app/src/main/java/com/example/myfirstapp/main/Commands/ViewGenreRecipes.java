package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestBrowse;
import com.example.myfirstapp.main.Presenters.ListDisplay;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewGenreRecipes extends GenreCommand {
    public static String COMMANDSTRING = "view genre recipes";

    ViewGenreRecipes(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new ViewRecipe());
        addSubCommands(new FilterGenreRecipes());
        addSubCommands(new SortGenreByRating());
    }


    @Override
    public void execute(String username) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which genre would you like to view? (Case Sensitive):");
        String genre = input.nextLine();
        addVIEWEDGENRE(genre);
        UserRequestBrowse browse = new UserRequestBrowse();
        ListDisplay display = new ListDisplay();
        display.DisplayListOfRecipes(browse.browseGenreRecipes(genre));
    }
    @Override
    public void execute(String username, ArrayList<String> genres) {
        System.out.println("An error has occurred. Please try again.");
    }

}
