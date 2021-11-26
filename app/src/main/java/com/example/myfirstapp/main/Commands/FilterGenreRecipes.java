package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestBrowse;
import com.example.myfirstapp.main.Controllers.UserRequestFilter;
import com.example.myfirstapp.main.Presenters.ListDisplay;

import java.util.ArrayList;
import java.util.Scanner;

public class FilterGenreRecipes extends GenreCommand {
    public static String COMMANDSTRING = "filter genre recipes";

    FilterGenreRecipes(){
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
        Scanner input = new Scanner(System.in);
        System.out.println("Which genre would you like to filter? (Case Sensitive):");
        String genre = input.nextLine();
        addVIEWEDGENRE(genre);
        UserRequestBrowse browse = new UserRequestBrowse();
        UserRequestFilter filter = new UserRequestFilter();
        ListDisplay display = new ListDisplay();
        try {
            display.DisplayListOfRecipes(filter.filter(browse.browseGenreRecipes(genres.get(0)), genre));
        } catch (Exception e) {
            System.out.println("Not a valid genre to filter.");
        }
    }
}
