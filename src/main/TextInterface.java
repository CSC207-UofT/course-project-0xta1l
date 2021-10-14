import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Entities.User;
//import Controllers.UserRequestCreateLogin;

public class TextInterface {
    public static void main(String[] arguments){
        Scanner input = new Scanner(System.in);
        System.out.println("Would you like to create a user or login? \n Please input either \"create\" or \"login\"");
        String UserChoice = input.nextLine();
        //String CurrentUsername = createOrLogin(UserChoice);


    }

    // TODO: implement way to ensure user input is not ""
    // TODO: do we want the parsing of the ArrayList object types to be done here? or should the use case do it
    private static User createOrLogin(String choice){
        Scanner input = new Scanner(System.in);

        if (choice.equals("create")){
            ArrayList<Object> UserInfo = new ArrayList<>();
            System.out.println("Please enter the display name you want:");
            //UserInfo.add(input.nextLine());
            String display = input.nextLine();

            System.out.println("Please enter your age:");
            //UserInfo.add(Integer.parseInt(input.nextLine()));
            int age = Integer.parseInt(input.nextLine());

            System.out.println("Please enter your password:");
            //UserInfo.add(input.nextLine());
            String pass = input.nextLine();

            System.out.println("Please enter the username you want (each user must have a unique username):");
            //UserInfo.add(input.nextLine());
            String username = input.nextLine();

            System.out.println("Please enter a short blurb about yourself:");
            //UserInfo.add(input.nextLine());
            String bio = input.nextLine();

            System.out.println("The recipe genres we currently have are: ");
            System.out.println("Please write out the genres you are interested in, separated by a comma:");
            //UserInfo.add(input.nextLine());
            ArrayList<String> interests = new ArrayList<>(Arrays.asList(input.nextLine().split(", ")));


            return new User(display, age, pass, username, bio, interests);
            //UserRequestCreateLogin.createUser(UserInfo);
        } if (choice.equals("login")){
            /*System.out.println("Please enter your username:");
            UserInfo.add(input.nextLine());
            System.out.println("Please enter your password:");
            UserInfo.add(input.nextLine());
            //UserRequestCreateLogin.loginUser(UserInfo);*/
            return new User();
        }

        return new User();
    }
}


