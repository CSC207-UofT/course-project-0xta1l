package UI;

import Controllers.UserRequestCreateLogin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CreateLoginDisplay {
        public String runLogin() throws Exception {
                UserRequestCreateLogin CreateLoginController = new UserRequestCreateLogin();
                Scanner input = new Scanner(System.in);
                //System.out.println("Would you like to create a user or login? \n Please input either \"create\" or \"login\"");
                //String UserChoice = input.nextLine();
                //if (UserChoice.equals("create")) {
                        ArrayList<Object> UserInfo = new ArrayList<>();
                        System.out.println("Welcome! You will be making a new user account.");
                        System.out.println("Please enter the username you want (each user must have a unique username):");
                        UserInfo.add(input.nextLine());

                        System.out.println("Please enter your password:");
                        UserInfo.add(input.nextLine());

                        System.out.println("Please enter the display name you want:");
                        UserInfo.add(input.nextLine());

                        System.out.println("Please enter your age:");
                        UserInfo.add(Integer.parseInt(input.nextLine()));

                        System.out.println("Please enter a short blurb about yourself:");
                        UserInfo.add(input.nextLine());

                        System.out.println("The recipe genres we currently have are: \n Mexican \n Chinese");
                        System.out.println("Please write out the genres you are interested in, separated by a comma:");
                        ArrayList<Object> interests = new ArrayList<>(Arrays.asList(input.nextLine().replaceAll("\\s+", "").split(",")));
                        UserInfo.add(interests);

                        return CreateLoginController.createUser(UserInfo);
                        //}


                }
}
