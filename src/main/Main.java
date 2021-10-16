import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Controllers.UserRequestBrowse;
import Controllers.UserRequestCreateLogin;
import Controllers.UserRequestRecipeView;
import Controllers.UserRequestSaveRecipe;
import Entities.User;
import UI.CreateLoginUI;
//import Controllers.UserRequestCreateLogin;

public class Main {
    public static void main(String[] args) throws Exception {

        UserRequestCreateLogin CreateLoginController = new UserRequestCreateLogin();

        CreateLoginUI ui = new CreateLoginUI();
        String user = ui.runLogin(CreateLoginController);

        UserRequestBrowse BrowseController = new UserRequestBrowse();
        UserRequestRecipeView ViewRecipeController = new UserRequestRecipeView();
        UserRequestSaveRecipe SaveRecipeController = new UserRequestSaveRecipe();

    }


}


