package UI;

import java.util.ArrayList;
import java.util.Scanner;
import Controllers.*;
import Presenters.ListDisplay;

/*
* A user interface class that handles the controls and handles the commands a user can execute.
* */

public class ViewUI {
    Scanner scanner = new Scanner(System.in);

    ListDisplay display = new ListDisplay();

    // Commands a user can call immediately they after they have logged in or created an account
    public String ViewOptionsDisplay(String username) throws Exception {
        System.out.println("Which would you like to do? \n ViewUserProfile, ViewGenres, ViewUserSavedRecipe or Logout");
        String action = scanner.nextLine();
        UserRequestBrowse browse = new UserRequestBrowse();
        ListDisplay display = new ListDisplay();
        ViewUI nextPrompt = new ViewUI();

        if (action.equals("ViewUserProfile")){
            System.out.println("We're still working on this, try again later!");
            nextPrompt.ViewOptionsDisplay(username);
            return username;
        }else if (action.equals("ViewGenres")){
            ArrayList<String> lst = browse.browseGenres(username);
            display.DisplayGenre(lst);
            nextPrompt.ViewGenreOptionsDisplay(username);
            return username;
        }else if (action.equals("ViewUserSavedRecipe")){
                display.DisplayListOfRecipes(browse.browseSavedRecipes(username));
                nextPrompt.ViewOptionsDisplay(username);
                return username;
        }else if (action.equals("Logout")){
            System.out.println("You have been logged out. Have a good day, Tabeeb! :D");
            return "";
        } else {
            System.out.println("That is not an accepted choice. Please make sure to follow the capitalization when entering your choice.");
            nextPrompt.ViewOptionsDisplay(username);
            return username;
        }
    }

    // Commands a
    public void ViewGenreOptionsDisplay(String username) throws Exception {
        ViewUI nextPrompt = new ViewUI();
        System.out.println("Which would you like to do? \n ViewGenreRecipes or GoBack");
        String action = scanner.nextLine();
        String genre = "";
        if (action.equals("ViewGenreRecipes")){

            boolean isNotAll = true;
            do {
                try {
                    System.out.println("Which genre would you like to view? (Only option is 'All'):");
                    genre = scanner.nextLine();
                    UserRequestBrowse BrowseController = new UserRequestBrowse();
                    ArrayList<ArrayList<Object>> GenreRecipes = BrowseController.browseGenreRecipes(genre);
                    display.DisplayListOfRecipes(GenreRecipes);

                    if (genre.equals("All")){
                        isNotAll = false;
                    }
                } catch (NullPointerException exception) {
                    System.out.println("Not a genre we have.");
                }
            } while(isNotAll);

            nextPrompt.ViewListRecipesOptionsDisplay(username, genre);

        } else if (action.equals("GoBack")){
            nextPrompt.ViewOptionsDisplay(username);
        } else {
            System.out.println("That is not an accepted choice. Please make sure to follow the capitalization when entering your choice.");
            nextPrompt.ViewGenreOptionsDisplay(username);
        }
    }

    private void ViewListRecipesOptionsDisplay(String username, String genre) throws Exception {
        ViewUI nextPrompt = new ViewUI();

        System.out.println("Which would you like to do? \n ViewRecipe or GoBack");
        String action = scanner.nextLine();
        if (action.equals("ViewRecipe")){

            boolean isNotID = true;
            do {
                try {
                    System.out.println("Which recipe would you like to view? Please enter its ID:");
                    int recipeID = Integer.parseInt(scanner.nextLine());
                    UserRequestRecipeView u = new UserRequestRecipeView();
                    u.recipeView(recipeID);
                    nextPrompt.ViewRecipeOptionsDisplay(username, recipeID, genre);
                    if ((recipeID == 6) || (recipeID == 7)) {
                        isNotID = false;
                    }
                } catch (Exception exception) {
                    System.out.println("Not a valid recipe ID.");
                }
            } while(isNotID);

        } else if (action.equals("GoBack")){
            nextPrompt.ViewOptionsDisplay(username);
        } else {
            System.out.println("That is not an accepted choice. Please make sure to follow the capitalization when entering your choice.");
            nextPrompt.ViewListRecipesOptionsDisplay(username, genre);
        }
    }

    private void ViewRecipeOptionsDisplay(String username, int recipeID, String genre) throws Exception {
        ViewUI nextPrompt = new ViewUI();

        System.out.println("Which would you like to do? \n SaveRecipe, or GoBack");
        String action = scanner.nextLine();
        if (action.equals("SaveRecipe")){
            UserRequestSaveRecipe SaveRecipeController = new UserRequestSaveRecipe();
            SaveRecipeController.saveRecipe(username, recipeID, genre);
            nextPrompt.ViewOptionsDisplay(username);
        } else if (action.equals("GoBack")){
            nextPrompt.ViewOptionsDisplay(username);
        } else {
            System.out.println("That is not an accepted choice. Please make sure to follow the capitalization when entering your choice.");
            nextPrompt.ViewRecipeOptionsDisplay(username, recipeID, genre);
        }
    }

}

