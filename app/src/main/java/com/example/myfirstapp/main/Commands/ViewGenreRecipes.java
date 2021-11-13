package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestBrowse;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Presenters.ListDisplay;

import java.util.ArrayList;
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
        ArrayList<Preview> lst = browse.browseGenreRecipes(genre);
        display.DisplayListOfRecipes(lst);
    }

}
