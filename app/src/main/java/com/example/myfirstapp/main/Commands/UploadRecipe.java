package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestCreateRecipe;
import com.example.myfirstapp.main.Controllers.UserRequestRecipeView;
import com.example.myfirstapp.main.Entities.FullPreview;
import com.example.myfirstapp.main.Presenters.RecipeDisplay;

import java.util.Scanner;

public class UploadRecipe extends Command {
    public static String COMMANDSTRING = "upload recipe";

    UploadRecipe(){
        setCOMMANDSTRING(COMMANDSTRING);
    }

    @Override
    public void execute(String username) throws Exception {
        Scanner scan = new Scanner(System.in);
        UserRequestCreateRecipe userRequestCreateRecipe = new UserRequestCreateRecipe();
        System.out.println("Recipe Name: ");
        String name = scan.nextLine();
        System.out.println("Recipe Description: ");
        String description = scan.nextLine();
        System.out.println("Recipe Genres (Please input separated by commas): ");
        String genres = scan.nextLine();
        System.out.println("Recipe Ingredients: ");
        String ingredients = scan.nextLine();
        System.out.println("Recipe Instructions (Please separate each line with a comma instead of a line break):");
        String instructions = scan.nextLine();
        System.out.println("Prep Time (How long does this recipe take to make? Please input the number in minutes):");
        String preptime = scan.nextLine();
        System.out.println("WILL BE CHANGED FOR PHASE 2\nRecipe ID:");
        String id = scan.nextLine();
        String image = "";
        userRequestCreateRecipe.recipe(username, instructions, ingredients, genres, name, "0", id, image, description, preptime);

        System.out.println("Success! Your new recipe has been created.");
        UserRequestRecipeView view = new UserRequestRecipeView();
        RecipeDisplay display = new RecipeDisplay();
        display.showRecipe((FullPreview) view.recipeView(id));
    }

}
