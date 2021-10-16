import UI.*;
//import Controllers.UserRequestCreateLogin;

public class Main {
    public static void main(String[] args) throws Exception {

        CreateLoginDisplay CreateLoginUI = new CreateLoginDisplay();
        String username = CreateLoginUI.runLogin();

        ViewDisplay ViewDisplayUI = new ViewDisplay();
        ViewDisplayUI.ViewDisplay(username);
    }


}


