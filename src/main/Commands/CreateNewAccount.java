package Commands;

import Controllers.UserRequestCreateLogin;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateNewAccount extends Command{

    public static String COMMANDSTRING = "create new account";
    CreateNewAccount(){
        setCOMMANDSTRING(COMMANDSTRING);
    }

    @Override
    public void execute(String username) {
        UserRequestCreateLogin CreateLoginController = new UserRequestCreateLogin();

        Scanner input = new Scanner(System.in);
        ArrayList<Object> UserInfo = new ArrayList<>();
        System.out.println("Welcome! You will be making a new user account.");
        System.out.println("Please enter the username you want (each user must have a unique username):");
        UserInfo.add(input.nextLine());

        System.out.println("Please enter your password:");
        UserInfo.add(input.nextLine());

        System.out.println("Please enter the display name you want:");
        UserInfo.add(input.nextLine());

        boolean isNotInt = true;
        do {
            try {
                System.out.println("Please enter your age:");
                UserInfo.add(Integer.parseInt(input.nextLine()));
                isNotInt = false;
            } catch (NumberFormatException exception) {
                System.out.println("Not an integer, please try again");
            }
        } while(isNotInt);
        System.out.println("Please enter a short blurb about yourself:");
        UserInfo.add(input.nextLine());
        ArrayList<Object> interests = new ArrayList<>();
        UserInfo.add(interests);
        try {
            CreateLoginController.createUser(UserInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
