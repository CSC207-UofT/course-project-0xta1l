package Commands;

import Controllers.UserRequestCreateLogin;

import java.util.Scanner;

public class HomePage extends Command{

        public static String COMMANDSTRING = "home";
        HomePage(){
            setCOMMANDSTRING(COMMANDSTRING);
            addSubCommands(new ViewGenres());
            addSubCommands(new Logout());
        }

        @Override
        public void execute(String username) throws Exception {
            boolean loggedIn;
            Scanner scan = new Scanner(System.in);
            System.out.println("Username:");
            String user = scan.nextLine();
            System.out.println("Password:");
            String password = scan.nextLine();

            UserRequestCreateLogin login = new UserRequestCreateLogin();
            loggedIn = login.loginUser(user, password);
            while (!loggedIn){
                System.out.println("Incorrect username/password. Please try again.");
                System.out.println("Username:");
                user = scan.nextLine();
                System.out.println("Password:");
                password = scan.nextLine();
                loggedIn = login.loginUser(user, password);
            }
            System.out.println("login successful");



        }

}
