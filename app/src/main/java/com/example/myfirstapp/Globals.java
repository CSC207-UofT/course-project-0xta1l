package com.example.myfirstapp;

import com.example.myfirstapp.main.Controllers.UserRequestProfile;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;

import java.util.ArrayList;

public class Globals {
    private static UserRequestProfile userEdit = new UserRequestProfile();

    /**
     * Has static methods to store:
     * Current Activity
     * Current Genre being Viewed
     * User and user's attributes
     * Current Recipe being Viewed
     */
    // Standard stuff for main
    public static int currentActivity = 0;
    public static UserSecurity us = Constants.USERSECURITY;
    public static GenreLibrary genreLibrary = Constants.GENRELIBRARY;

    public static void setCurrentActivity(int i) {
        currentActivity = i;
    }

    public static int getCurrentActivity() {
        return currentActivity == 0 ? R.id.menu_home : currentActivity;
    }

    public static String viewGenreName = "";

    public static String getViewGenreName() {
        return viewGenreName;
    }

    public static void setViewGenreName(String s) {
        viewGenreName = s;
    }

    public static int viewRecipeId;

    public static int getViewRecipeId() {
        return viewRecipeId;
    }

    public static void setViewRecipeId(int i) {
        viewRecipeId = i;
    }

    public static String genreItemSortState = "Alphabetical";

    public static String getGenreItemSortState() {
        return genreItemSortState;
    }

    public static void setGenreItemSortState(String s) {
        genreItemSortState = s;
    }


    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User newUser) {
        user = newUser;
    }

    public static String getUser_username() {
        return user.getUsername();
    }

    public static boolean setUser_username(String s) {
        if (!"".equals(getUser_username())) {
            user.setUsername(s);
            return userEdit.changeUsername(getUser_username(), s);
        } else {
            return false;
        }
    }

    public static String getUser_password() {
        return user.getPassword();
    }

    public static void setUser_password(String password) {
        userEdit.changePassword(getUser_username(), password);
        user.setPassword(password);
    }

    public static String getUser_name() {
        return user.getDisplayName();
    }

    public static void setUser_name(String name) {
        userEdit.changeName(getUser_username(), name);
        user.setDisplayName(name);
    }

    public static String getUser_bio() {
        return user.getBiography();
    }

    public static void setUser_bio(String bio) {
        userEdit.changeBio(getUser_username(), bio);
        user.setBiography(bio);
    }

    public static ArrayList<String> getUserInterests() {
        return user.getInterests();
    }

    public static String getUserStringInterests() {
        StringBuilder s = new StringBuilder();
        int counter = 1;
        for (String str : getUserInterests()) {
            if (counter < getUserInterests().size()) {
                counter++;
                s.append(str).append(", ");
            } else {
                s.append(str);
            }
        }
        return s.toString();
    }

    public static void setUserInterests(ArrayList<String> interests) {
        userEdit.changeInterests(getUser_username(), interests);
        user.setInterests(interests);
    }

    public static int getUserAge() {
        System.out.println(user.getAge());
        return user.getAge();
    }

    public static void setUserAge(int age) {
        userEdit.changeAge(getUser_username(), age);
        user.setAge(age);
    }

    public static Recipe getRecipe() {
        return Constants.GENRELIBRARY.getAllRecipes("All").get(viewRecipeId);
    }

    public static Recipe getRecipe(int id) {
        return Constants.GENRELIBRARY.getAllRecipes("All").get(id);
    }
}
