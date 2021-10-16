package UI;

import java.util.ArrayList;
import java.util.Scanner;
import Controllers.*;
import UI.*;

public class ViewDisplay {
    public void ViewDisplay() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your username");
        String usernameResponse = scanner.nextLine();

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Which would you like to do?");
        System.out.println("ViewUserProfile, ViewGenres, ViewUserSavedRecipe or Logout");
        String action = scanner1.nextLine();
        UserRequestBrowse browse = new UserRequestBrowse();
        CreateLoginUI log = new CreateLoginUI();
        UserRequestCreateLogin createLogin = new UserRequestCreateLogin();
        ListDisplay display = new ListDisplay();
        if (action.equals("ViewUserProfile")){

        }else if (action.equals("ViewGenres")){
            ArrayList<String> lst= browse.browseGenres(usernameResponse);
            display.DisplayGenre(lst);
        }else if (action.equals("ViewUserSavedRecipe")){
                ArrayList<Object> lst = browse.browseSavedRecipes(usernameResponse);
                display.DisplayListOfRecipes(lst);
        }else{
            log.runLogin(createLogin);
        }

    }
}
