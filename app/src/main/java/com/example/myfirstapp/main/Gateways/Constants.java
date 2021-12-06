package com.example.myfirstapp.main.Gateways;

import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class Constants {
    // Create Constants
    public static ArrayList<String> GENRELIST = new ArrayList<>(Arrays.asList("All", "African",
            "Alcoholic", "American", "Appetizer", "BBQ", "Cake", "Caribbean", "Chinese", "Cocktail",
            "Dessert", "Drink", "European", "Filipino", "Fusion", "Greek", "Indian", "Italian", "Jamaican",
            "Japanese", "Korean", "Meal", "Mexican", "Middle-Eastern", "Pakistani", "Peach", "Pie", "Sauce",
            "Soul", "Southern", "Spanish", "Thai", "Vegan", "Vegetarian", "Vietnamese", "Western"));

    public static GenreLibrary GENRELIBRARY = Constants.createDataset();
    public static UserSecurity USERSECURITY = Constants.createUsers();

    public static UserSecurity createUsers() {
        // NOTE this is temporary placeholder to test android app usage

        List<String> interestList1 = Arrays.asList("Mexican", "Western");
        List<String> interestList2 = Arrays.asList("Chinese", "Indian", "Korean");

        ArrayList<String> interest1 = new ArrayList<>(interestList1);
        ArrayList<String> interest2 = new ArrayList<>(interestList2);

        User user1 = new User("username1", "password1", "Dan",
                10, "I love food", interest1, GENRELIBRARY.getAllGenres());

        User user2 = new User("username2", "password2", "Bob",
                11, "I love chicken", interest2, GENRELIBRARY.getAllGenres());

        User user3 = new User("a", "a", "Bob",
                11, "for text ui testing", interest2, GENRELIBRARY.getAllGenres());

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
        r3genres.add("Korean");
        ArrayList<String> r4genres = new ArrayList<>();
        r4genres.add("Egyptian");
        ArrayList<String> r5genres = new ArrayList<>();
        r5genres.add("Canadian");
        r5genres.add("Indian");

        Recipe recipe1 = new Recipe("Set on Fire", "Salt",
                r1genres, "Burnt Food", 5, 1, "burnt.jpg", "Is burnt food", 5);

        Recipe recipe2 = new Recipe("Throw in Oven", "Chicken",
                r2genres, "Chicken", 4, 2, "chicken.jpg", "Is Chicken", 10);

        Recipe recipe3 = new Recipe("Pan fry in pan", "Steak, butter",
                r3genres, "Good Steak", 5, 3, "steak.jpg", "Is steak", 30);

        Recipe recipe4 = new Recipe("Boil in water", "Spinach, Mushrooms",
                r4genres, "Random Veggies", 2, 4, "veg.jpg", "Is veggie", 15);

        Recipe recipe5 = new Recipe("Throw maple syrup on pancakes", "Pancakes, salt, butter",
                r5genres, "Pancakes", 3, 5, "pancake.jpg", "Is pancake", 5);

        Recipe recipe6 = new Recipe("Cut into rectangular prisms and cook in oven", "Potatoes, butter",
                r3genres, "French Fries", 4, 6, "fries.jpg", "Is frnch fry", 30);

        Review review1 = new Review("username1", 1, "comments", 2);
        Review review2 = new Review("a", 1, "222222", 3);
        Review review3 = new Review("username2", 1, "333333", 4);

        recipe1.addSavedReviews("username1", review1);
        recipe1.addSavedReviews("a", review2);
        recipe1.addSavedReviews("username2", review3);
        for (String g : recipe1.getGenre()) {
            dataset.addRecipes(g, recipe1);
        }
        for (String g : recipe2.getGenre()) {
            dataset.addRecipes(g, recipe2);
        }
        for (String g : recipe3.getGenre()) {
            dataset.addRecipes(g, recipe3);
        }
        for (String g : recipe4.getGenre()) {
            dataset.addRecipes(g, recipe4);
        }
        for (String g : recipe5.getGenre()) {
            dataset.addRecipes(g, recipe5);
        }
        for (String g : recipe6.getGenre()) {
            dataset.addRecipes(g, recipe6);
        }
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


}