import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Controllers.UserRequestCreateLogin;
import Entities.User;
import UI.CreateLoginUI;
//import Controllers.UserRequestCreateLogin;

public class Main {
    public static void main(String[] args) throws Exception {

        UserRequestCreateLogin controller = new UserRequestCreateLogin();

        CreateLoginUI ui = new CreateLoginUI(); //UI
        // Note how this differs from a previous example we saw, where
        // we "injected" the UI into the controller. Here, we are doing it
        // the other way. Are both ways consistent with the Dependency Rule?
        ui.runLogin(controller);
    }


}


