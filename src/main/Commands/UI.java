package Commands;
import Constants.*;
import Controllers.UserRequestCreateLogin;
import Entities.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    CommandTree commandTree = Constants.COMMANDTREE;
    CommandTree.CommandNode currentNode = commandTree.root;
    boolean is_running = true;

    public static void main(String[] args) {
        UI ui = new UI();
        Scanner scanner = new Scanner(System.in);
        System.out.println("login\ncreate account");
        boolean userInstance = false;
        User user = null;
        while (!userInstance) {
            String userOption = scanner.nextLine();
            if (userOption.equals("login")) {
                user = login();
                userInstance = true;
            } else if (userOption.equals("create account")) {
                user = createAccount();
                userInstance = true;
            }
        }


        while(ui.is_running){
            try {
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
                        child.getCommand().execute(user.getUsername());
                        ui.currentNode = child;
                        hasMatch = true;
                        break;
                    } /*else if (action.equals("back") && !ui.currentNode.getCommand().getCommandName().equals("home")) {
                        child.getParent().getCommand().execute(user.getUsername());
                        hasMatch = true;
                        break;
                    }*/
                }
                // checks if user wants to go back to previous page
                CommandTree.CommandNode parent = ui.currentNode.parent;
                if (action.equals(parent.getCommand().getCommandName()) &&
                        !ui.currentNode.getCommand().getCommandName().equals("home")){
                    parent.getCommand().execute(user.getUsername());
                    ui.currentNode = parent;
                    hasMatch = true;
                }
                // checks if user wants to go back to home
                CommandTree.CommandNode home = Constants.COMMANDTREE.root;
                if (action.equals("home") &&
                        !ui.currentNode.getCommand().getCommandName().equals("home")){
                    home.getCommand().execute(user.getUsername());
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

    private static User login(){
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

        return Constants.USERSECURITY.getUserByID(username);
    }

    private static User createAccount(){
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
        return Constants.USERSECURITY.getUserByID((String) UserInfo.get(0));
    }


}
