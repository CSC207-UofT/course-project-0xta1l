package Commands;

import Controllers.UserRequestBrowse;
import Controllers.UserRequestFilter;
import Presenters.ListDisplay;

import java.util.Scanner;

public class SortGenreByRating extends Command {
    public static String COMMANDSTRING = "sort genre by rating";

    SortGenreByRating(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new ViewRecipe());
        addSubCommands(new FilterGenreRecipes());
    }


    @Override
    public void execute(String username) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which genre would you like to filter? (Case Sensitive):");
        String genre = input.nextLine();
        UserRequestBrowse browse = new UserRequestBrowse();
        UserRequestFilter filter = new UserRequestFilter();
        ListDisplay display = new ListDisplay();
        try {
            display.DisplayListOfRecipes(filter.filter(browse.browseGenreRecipes(genre), genre));
        } catch (Exception e) {
            System.out.println("Not a valid genre to filter.");
        }
    }
}
