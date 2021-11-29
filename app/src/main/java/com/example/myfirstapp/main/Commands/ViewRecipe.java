package com.example.myfirstapp.main.Commands;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Controllers.UserRequestRecipeView;
import com.example.myfirstapp.main.Presenters.RecipeDisplay;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewRecipe extends RecipeCommand {
    public static String COMMANDSTRING = "view recipe";

    ViewRecipe(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new SaveRecipe());
        addSubCommands(new AddReview());
        addSubCommands(new ViewReviews());
    }

    @Override
    public void execute(String username, String second) throws Exception {
        System.out.println("An error has occurred.");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void execute(String username) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input the Recipe ID (number) of the recipe you want to view:");
        String recipeID = input.nextLine();
        setVIEWEDRECIPE(recipeID);
        UserRequestRecipeView view = new UserRequestRecipeView();
        RecipeDisplay display = new RecipeDisplay();
        display.showRecipe(view.recipeView(recipeID));
    }

}
