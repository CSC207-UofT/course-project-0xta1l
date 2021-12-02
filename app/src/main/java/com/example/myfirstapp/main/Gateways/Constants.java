package com.example.myfirstapp.main.Gateways;

import com.example.myfirstapp.main.Commands.Command;
import com.example.myfirstapp.main.Commands.CommandTree;
import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;

import java.util.*;

public class Constants {
    // Create Constants

    public static GenreLibrary GENRELIBRARY =  Constants.createDataset();
    public static UserSecurity USERSECURITY = Constants.createUsers();
    public static CommandTree COMMANDTREE = createCommandTree(new com.example.myfirstapp.main.Commands.HomePage());

    public static UserSecurity createUsers(){
        return Read.populateUserSecurity();
    }
    public static GenreLibrary createDataset() {
        return Read.populateGenreLibrary();
    }

    public static CommandTree createCommandTree(Command command){
        CommandTree commandTree = new CommandTree(new CommandTree.CommandNode());
        commandTree.setRoot(createCommandNode(command));

        return commandTree;
    }

    public static CommandTree.CommandNode createCommandNode(Command command){

        CommandTree.CommandNode node = new CommandTree.CommandNode();
        node.setCommand(command);
        ArrayList<Command> commandList = command.getSubCommands();
        if (!commandList.isEmpty()){
            for(Command c: commandList){
                CommandTree.CommandNode subNode = createCommandNode(c);
                node.addChild(subNode);

            }
        }
        return node;
    }


    public static ArrayList<String> GENRELIST = new ArrayList<>(Arrays.asList("Meal","Drink","Dessert","Sauce","Appetizer","Western",
            "Fusion","Indian","Middle-Eastern","Mexican","Italian","Spanish","Japanese","Korean","Chinese","Thai",
            "Vietnamese","Chinese", "Filipino", "Soul", "Caribbean", "Vegan/Vegetarian", "African","Alcoholic",
            "Latin American", "Vegetarian","Salad","Chicken", "BBQ","Pie","Fruit","Cake","Seafood","Coleslaw",
            "Doughnuts","Cookies","Muffins","Fast Food"));

    // TODO: create another function that will create a genre list from the database

}
