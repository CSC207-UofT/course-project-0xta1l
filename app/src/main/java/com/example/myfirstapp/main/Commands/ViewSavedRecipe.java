package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestRecipeView;
import com.example.myfirstapp.main.Entities.FullPreview;
import com.example.myfirstapp.main.Presenters.RecipeDisplay;

import java.util.Scanner;

public class ViewSavedRecipe extends RecipeCommand {
    public static String COMMANDSTRING = "view saved recipe";

    ViewSavedRecipe(){
        setCOMMANDSTRING(COMMANDSTRING);
        //addSubCommands(new WriteReview());
        addSubCommands(new DeleteSavedRecipe());
    }


    @Override
    public void execute(String username) {
        UserRequestRecipeView browse = new UserRequestRecipeView();
        RecipeDisplay display = new RecipeDisplay();
        Scanner scan = new Scanner(System.in);
        String recipeID = scan.nextLine();
        setVIEWEDRECIPE(recipeID);
        try {
            display.showRecipe((FullPreview) browse.recipeView(recipeID));
        } catch (Exception e) {
            System.out.println("Recipe with such ID does not exist.");
        }

    }

    @Override
    public void execute(String username, String recipeID) {
        System.out.println("An error has occurred.");
    }
}
