package UI;

import Controllers.UserRequestCreateLogin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CreateLoginUI {
        public void runLogin(UserRequestCreateLogin controller) throws Exception {
                Scanner input = new Scanner(System.in);
                System.out.println("Would you like to create a user or login? \n Please input either \"create\" or \"login\"");
                String UserChoice = input.nextLine();
                if (UserChoice.equals("create")){
                        ArrayList<Object> UserInfo = new ArrayList<>();
                        System.out.println("Please enter the username you want (each user must have a unique username):");
                        UserInfo.add(input.nextLine().toString());

                        System.out.println("Please enter your password:");
                        UserInfo.add(input.nextLine().toString());

                        System.out.println("Please enter the display name you want:");
                        UserInfo.add(input.nextLine().toString());

                        System.out.println("Please enter your age:");
                        UserInfo.add(Integer.parseInt(input.nextLine());

                        System.out.println("Please enter a short blurb about yourself:");
                        UserInfo.add(input.nextLine().toString());

                        System.out.println("The recipe genres we currently have are: \n Mexican \n Chinese");
                        System.out.println("Please write out the genres you are interested in, separated by a comma:");
                        ArrayList<Object> interests = new ArrayList<>(Arrays.asList(input.nextLine().replaceAll("\\s+", "").split(",")));
                        UserInfo.add(interests);

                        String CurrentUsername = controller.createUser(UserInfo);
                }
        }
}
    public String createUser(){
            Scanner input = new Scanner(System.in);


            return UserRequestCreateLogin.createUser(UserInfo);
        }
    }
}




// TODO: implement way to ensure user input is not ""
// TODO: do we want the parsing of the ArrayList object types to be done here? or should the use case do it
