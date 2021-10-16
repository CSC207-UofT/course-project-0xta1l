import Constants.Constants;
import UI.*;

import java.util.ArrayList;
import java.util.Collections;
//import Controllers.UserRequestCreateLogin;

public class Main {
    public static void main(String[] args) throws Exception {

        CreateLoginUI CreateLoginUI = new CreateLoginUI();
        String username = CreateLoginUI.runLogin();
        ViewUI ViewDisplayUI = new ViewUI();
        ViewDisplayUI.ViewOptionsDisplay(username);


    }
}


