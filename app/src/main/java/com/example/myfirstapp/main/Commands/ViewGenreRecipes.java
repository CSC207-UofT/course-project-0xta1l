package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestBrowse;
import com.example.myfirstapp.main.Presenters.ListDisplay;

import java.util.Scanner;

public class ViewGenreRecipes extends Command {
    public static String COMMANDSTRING = "view genre recipes";

    ViewGenreRecipes(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new ViewRecipe());
    }


    @Override
    public void execute(String username) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which genre would you like to view? (Case Sensitive):");
        String genre = input.nextLine();
        UserRequestBrowse browse = new UserRequestBrowse();
        ListDisplay display = new ListDisplay();
        display.DisplayListOfRecipes(browse.browseGenreRecipes(genre));
    }

}
