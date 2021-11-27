package com.example.myfirstapp.main.Constants;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;
import com.example.myfirstapp.main.Commands.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;
import java.io.*;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Constants {
    // Create Constants

    public static GenreLibrary GENRELIBRARY =  createDataset();//JSONReader.readRecipes("app/src/main/res/temp_data.json");
    public static UserSecurity USERSECURITY = createUsers();//JSONReader.readUsers("app/src/main/res/users.json");


    //public static UserSecurity USERSECURITY = Constants.createUsers();
    public static com.example.myfirstapp.main.Commands.CommandTree COMMANDTREE =
            createCommandTree(new com.example.myfirstapp.main.Commands.HomePage());

    /* This is outdated code to read csv file.

    public static UserSecurity USERSECURITY;
    public static CommandTree  COMMANDTREE = createCommandTree(new Commands.HomePage());
    static {
        try {
            USERSECURITY = Constants.CSVUserReader("src/main/Constants/users.csv");
            System.out.println(USERSECURITY);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
     */

    public static UserSecurity createUsers(){
        // NOTE this is temporary placeholder to test android app usage

        List<String> interestList1 = Arrays.asList( "Mexican", "Western");
        List<String> interestList2 = Arrays.asList( "Chinese", "Indian", "Korean");

        ArrayList<String> interest1 = new ArrayList<>(interestList1);
        ArrayList<String> interest2 = new ArrayList<>(interestList2);

        User user1 = new User("username1", "password1", "Dan",
                10, "I love food", interest1);

        User user2 = new User("username2", "password2", "Bob",
                11, "I love chicken", interest2);

        User user3 = new User("a", "a", "Bob",
                11, "for text ui testing", interest2);

        UserSecurity us = new UserSecurity();
        us.addUser(user1);
        us.addUser(user2);
        us.addUser(user3);

        return us;
    }
    public static GenreLibrary createDataset() {
        GenreLibrary dataset = new GenreLibrary();
        ArrayList<String> r1genres = new ArrayList<>();
        r1genres.add("Mexican");
        ArrayList<String> r2genres = new ArrayList<>();
        r2genres.add("Chinese");
        ArrayList<String> r3genres = new ArrayList<>();
        r3genres.add("Western");
        ArrayList<String> r4genres = new ArrayList<>();
        r4genres.add("Egyptian");
        ArrayList<String> r5genres = new ArrayList<>();
        r5genres.add("Canadian");

        Recipe recipe1 = new Recipe("Set on Fire", "Salt",
                r1genres, "Burnt Food", 5, 1, "burnt.jpg", "Is burnt food",5);

        Recipe recipe2 = new Recipe("Throw in Oven", "Chicken",
                r2genres, "Chicken", 4, 2, "chicken.jpg", "Is Chicken",10);

        Recipe recipe3 = new Recipe("Pan fry in pan", "Steak, butter",
                r3genres, "Good Steak", 5, 3, "steak.jpg", "Is steak",30);

        Recipe recipe4 = new Recipe("Boil in water", "Spinach, Mushrooms",
                r4genres, "Random Veggies", 2, 4, "veg.jpg", "Is veggie",15);

        Recipe recipe5 = new Recipe("Throw maple syrup on pancakes", "Pancakes, salt, butter",
                r5genres, "Pancakes", 3, 5, "pancake.jpg", "Is pancake",5);

        Recipe recipe6 = new Recipe("Cut into rectangular prisms and cook in oven", "Potatoes, butter",
                r3genres, "French Fries", 4, 6, "fries.jpg", "Is frnch fry",30);

        for (String g: recipe1.getGenre()){
            dataset.addRecipes(g, recipe1);
        }
        for (String g: recipe2.getGenre()){
            dataset.addRecipes(g, recipe2);
        }
        for (String g: recipe3.getGenre()){
            dataset.addRecipes(g, recipe3);
        }
        for (String g: recipe4.getGenre()){
            dataset.addRecipes(g, recipe4);
        }
        for (String g: recipe5.getGenre()){
            dataset.addRecipes(g, recipe5);
        }
        for (String g: recipe6.getGenre()){
            dataset.addRecipes(g, recipe6);
        }
        dataset.setHighestID(6);
        return dataset;
    }
    public static GenreLibrary CSVRecipeReader(String fileName) throws FileNotFoundException {
        GenreLibrary genreLibrary = new GenreLibrary();

        Scanner sc = new Scanner(new File(fileName));
        sc.useDelimiter(",");

        while (sc.hasNext()) {
            String[] recipe = sc.next().split(",", 8);

            System.out.println(sc.next());
        }
        sc.close();
//        Path pathToFile = Paths.get(fileName);
//        Path path = pathToFile.toAbsolutePath();
//
//        FileReader fr = new FileReader(path.toString());
//        BufferedReader br = new BufferedReader(fr);
//        Stream<String> stream = br.lines();
//        Object[] list = stream.toArray();
//
//        for (Object recipe : list) {
//            String[] s = recipe.toString().split(",", 6);
//
//            Recipe newRecipe = new Recipe();
//            genreLibrary.addRecipes(newRecipe);
//        }
        return genreLibrary;
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

}