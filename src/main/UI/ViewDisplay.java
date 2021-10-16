package UI;

import java.util.Scanner;
import Controllers.*;

public class ViewDisplay {
    public String ViewDisplay(String username) throws Exception {

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Which would you like to do?");
        System.out.println("ViewUserProfile, ViewGenres, ViewUserSavedRecipes or Logout");
        String action = scanner1.nextLine();
        UserRequestBrowse browse = new UserRequestBrowse();
        CreateLoginDisplay log = new CreateLoginDisplay();
        UserRequestCreateLogin createLogin = new UserRequestCreateLogin();
        if (action.equals("ViewUserProfile")){
            return username;
        }else if (action.equals("ViewGenres")){
            browse.browseGenres(username);
            return username;
        }else if (action.equals("ViewUserSavedRecipes")){
            browse.browseSavedRecipes(username);
            return username;
        }else{
            log.runLogin();
            return username;
        }

    }
}
