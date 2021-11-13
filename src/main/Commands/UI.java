package Commands;
import Constants.*;
import Controllers.UserRequestCreateLogin;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    CommandTree commandTree = Constants.COMMANDTREE;
    CommandTree.CommandNode currentNode = commandTree.root;
    boolean is_running = true;

    public static void main(String[] args) {
        UI ui = new UI();
        Scanner scanner = new Scanner(System.in);
        String username = getUser(scanner);

        while(ui.is_running){
            try {
                System.out.println("\nPOSSIBLE COMMANDS:");
                for (CommandTree.CommandNode child : ui.currentNode.children) {
                    System.out.println(child.getCommand().getCommandName());
                }

                if (!ui.currentNode.getCommand().getCommandName().equals("home")){
                    System.out.println(ui.currentNode.parent.getCommand().getCommandName());
                    if (!ui.currentNode.parent.getCommand().getCommandName().equals("home")){
                        System.out.println("home");
                    }
                }

                String action = scanner.nextLine(); //user types input

                boolean hasMatch = false;
                for (CommandTree.CommandNode child : ui.currentNode.children) {
                    if (action.equals(child.getCommand().getCommandName())) {
                        // reset tree, move user out of tree command line
                        if (action.equals("logout")){
                            child.getCommand().execute(username);
                            ui.currentNode = Constants.COMMANDTREE.root;
                            username = getUser(scanner);
                        } else if (child.getCommand() instanceof RecipeCommand
                                && !action.equals("view recipe")
                                && !action.equals("view saved recipe")
                                && !ui.currentNode.getCommand().getCommandName().equals("view saved recipes")){
                            ((RecipeCommand) child.getCommand()).execute(username, ((RecipeCommand) ui.currentNode.getCommand()).getViewedRecipe());
                            ui.currentNode = child;
                            hasMatch = true;
                            break;
                        }  else {
                            child.getCommand().execute(username);
                            ui.currentNode = child;
                            hasMatch = true;
                            break;
                        }

                    }
                }
                // checks if user wants to go back to previous page
                CommandTree.CommandNode parent = ui.currentNode.parent;
                if (action.equals(parent.getCommand().getCommandName()) &&
                        !ui.currentNode.getCommand().getCommandName().equals("home")){
                    parent.getCommand().execute(username);
                    ui.currentNode = parent;
                    hasMatch = true;
                }
                // checks if user wants to go back to home
                CommandTree.CommandNode home = Constants.COMMANDTREE.root;
                if (action.equals("home") &&
                        !ui.currentNode.getCommand().getCommandName().equals("home")){
                    home.getCommand().execute(username);
                    ui.currentNode = home;
                    hasMatch = true;
                }
                if (!hasMatch) {
                    // TO FORCE SHUTDOWN PROGRAM
                    if (action.equals("SHUTDOWN")){
                        ui.is_running=false;
                    }else{System.out.println("Please enter a valid command");}
                }
            } catch(Exception e){ System.out.println(e.getMessage());}
        }
    }

    private static String getUser(Scanner scanner) {
        boolean userInstance = false;
        String username = "";
        System.out.println("Welcome! Choose one of the following:");
        while (!userInstance) {
            System.out.println("login\ncreate account");
            String userOption = scanner.nextLine();
            if (userOption.equals("login")) {
                username = login();
                userInstance = true;
            } else if (userOption.equals("create account")) {
                username = createAccount();
                userInstance = true;
            } else {
                System.out.println("Not a valid command. Please beware of spelling and case.");
            }
        }
        return username;
    }

    private static String login(){
        boolean loggedIn;
        Scanner scan = new Scanner(System.in);
        System.out.println("Username:");
        String username = scan.nextLine();
        System.out.println("Password:");
        String password = scan.nextLine();

        UserRequestCreateLogin login = new UserRequestCreateLogin();
        loggedIn = login.loginUser(username, password);
        while (!loggedIn){
            System.out.println("Incorrect username/password. Please try again.");
            System.out.println("Username:");
            username = scan.nextLine();
            System.out.println("Password:");
            password = scan.nextLine();
            loggedIn = login.loginUser(username, password);
        }
        System.out.println("login successful");

        return username;
    }

    private static String createAccount(){
        UserRequestCreateLogin CreateLoginController = new UserRequestCreateLogin();

        Scanner input = new Scanner(System.in);
        ArrayList<Object> UserInfo = new ArrayList<>();
        System.out.println("Welcome! You will be making a new user account.");
        System.out.println("Please enter the username you want (each user must have a unique username):");
        String username = input.nextLine();

        System.out.println("Please enter your password:");
        String password = input.nextLine();

        System.out.println("Please enter the display name you want:");
        String displayName = input.nextLine();

        int age = 0;
        boolean isNotInt = true;
        do {
            try {
                System.out.println("Please enter your age:");
                age = Integer.parseInt(input.nextLine());
                isNotInt = false;
            } catch (NumberFormatException exception) {
                System.out.println("Not an integer, please try again");
            }
        } while(isNotInt);
        System.out.println("Please enter a short blurb about yourself:");
        String bio = input.nextLine();

        System.out.println("The recipe genres we currently have are: ");
        System.out.println(Constants.GENRELIBRARY.getAllGenres());
        System.out.println("Please enter the genres you are interested in, each separated by a comma and space.");
        String interests = input.nextLine();
        try {
            CreateLoginController.createUser(username, password, displayName, age, bio, interests);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return username;
    }


}
