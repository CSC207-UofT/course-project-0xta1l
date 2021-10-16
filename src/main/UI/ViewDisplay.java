package UI;

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
        if (action.equals("ViewUserProfile")){

        }else if (action.equals("ViewGenres")){
            browse.browseGenres(usernameResponse);
        }else if (action.equals("ViewUserSavedRecipe")){
            browse.browseSavedRecipes(usernameResponse);
        }else{
            log.runLogin(createLogin);
        }

    }
}
