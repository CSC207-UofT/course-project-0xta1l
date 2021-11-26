package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestSaveRecipe;
import java.util.Scanner;

public class DeleteSavedRecipe extends RecipeCommand {
    public static String COMMANDSTRING = "delete saved recipe";

    DeleteSavedRecipe(){
        setCOMMANDSTRING(COMMANDSTRING);
    }

    @Override
    public void execute(String username) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which recipe would you like to delete? Please input the ID:");
        String recipeID = scan.nextLine();
        setVIEWEDRECIPE(recipeID);
        UserRequestSaveRecipe savedRecipes = new UserRequestSaveRecipe();
        try{
            savedRecipes.deleteRecipe(username, recipeID);
            System.out.println("Recipe has been removed from saved recipes.");

        } catch (Exception e){
            System.out.println("Recipe was not in saved recipes.");
        }
    }

    @Override
    public void execute(String username, String recipeID) {
        setVIEWEDRECIPE(recipeID);
        UserRequestSaveRecipe savedRecipes = new UserRequestSaveRecipe();
        try{
            savedRecipes.deleteRecipe(username, recipeID);
            System.out.println("Recipe has been removed from saved recipes.");

        } catch (Exception e){
            System.out.println("Recipe was not in saved recipes.");
        }
    }
}
