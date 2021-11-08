package Commands;

import Controllers.UserRequestCreateLogin;

import java.util.Scanner;

public class HomePage extends Command{

        public static String COMMANDSTRING = "home";
        HomePage(){
            setCOMMANDSTRING(COMMANDSTRING);
            addSubCommands(new ViewGenres());
            //addSubCommands(new ViewUserProfile());
            //addSubCommands(new ViewUserSavedRecipes());
            addSubCommands(new Logout());
        }

        @Override
        public void execute(String username) throws Exception {
        }

}
