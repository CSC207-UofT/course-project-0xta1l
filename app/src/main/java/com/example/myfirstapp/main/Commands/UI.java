
package com.example.myfirstapp.main.Commands;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Constants.*;
import com.example.myfirstapp.main.Controllers.UserRequestCreateLogin;
import com.example.myfirstapp.main.Entities.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@RequiresApi(api = Build.VERSION_CODES.O)
public class UI {

    CommandTree commandTree = Constants.COMMANDTREE;
    CommandTree.CommandNode currentNode = commandTree.root;
    boolean is_running = true;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
        JSONReader.readRecipes("app/src/main/java/com/example/myfirstapp/main/Constants/temp_data.json");
        Constants.GENRELIBRARY.setHighestID(207);
        UI ui = new UI();
        Scanner scanner = new Scanner(System.in);
        User user = getUser(scanner);

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
                            child.getCommand().execute(user.getUsername());
                            ui.currentNode = Constants.COMMANDTREE.root;
                            user = getUser(scanner);
                        } else if (child.getCommand() instanceof RecipeCommand
                                && !action.equals("view recipe")
                                && !action.equals("view saved recipe")
                                && !ui.currentNode.getCommand().getCommandName().equals("view saved recipes")){
                            ((RecipeCommand) child.getCommand()).execute(user.getUsername(), ((RecipeCommand) ui.currentNode.getCommand()).getViewedRecipe());
                            ui.currentNode = child;
                            hasMatch = true;
                            break;
                        }  else if (child.getCommand() instanceof GenreCommand
                                && !action.equals("view genre recipes")
                                && !ui.currentNode.getCommand().getCommandName().equals("view genre")){
                            ((GenreCommand) child.getCommand()).execute(user.getUsername(), ((GenreCommand) ui.currentNode.getCommand()).getViewedGenre());
                            ui.currentNode = child;
                            hasMatch = true;
                            break;
                        } else {
                            child.getCommand().execute(user.getUsername());
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

    private static User getUser(Scanner scanner) {
        boolean userInstance = false;
        User user = new User();
        System.out.println("Welcome! Choose one of the following:");
        while (!userInstance) {
            System.out.println("login\ncreate account");
            String userOption = scanner.nextLine();
            if (userOption.equals("login")) {
                user = login();
                userInstance = true;
            } else if (userOption.equals("create account")) {
                user = createAccount();
                userInstance = true;
            } else {
                System.out.println("Not a valid command. Please beware of spelling and case.");
            }
        }
        return user;
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
            ArrayList<String> interestList = new ArrayList<>(Arrays.asList(interests.split(",\\s*")));
            CreateLoginController.createUser(username, password, displayName, age, bio, interestList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Constants.USERSECURITY.getUserByID(username);
    }


}
