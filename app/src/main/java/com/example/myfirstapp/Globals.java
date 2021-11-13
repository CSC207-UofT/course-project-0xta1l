package com.example.myfirstapp;

import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.UserSecurity;

import java.util.ArrayList;

public class Globals {
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
    public static String getViewGenreName(){
        return viewGenreName;
    }
    public static void setViewGenreName(String s) {
        viewGenreName = s;
    }

    public static int viewRecipeId;
    public static int getViewRecipeId(){
        return viewRecipeId;
    }
    public static void setViewRecipeId(int i) {
        viewRecipeId = i;
    }


    public static String user_username;
    public static String getUser_username(){
        return user_username;
    }
    public static void setUser_username(String s) {
        user_username = s;
    }

    public static String user_password;
    public static String getUser_password(){
        return user_password;
    }
    public static void setUser_password(String s) {
        user_password = s;
    }

    public static String user_name;
    public static String getUser_name(){
        return user_name;
    }
    public static void setUser_name(String s) {
        user_name = s;
    }

    public static String user_bio;
    public static String getUser_bio(){
        return user_bio;
    }
    public static void setUser_bio(String s) {
        user_bio = s;
    }

    private static ArrayList<String> userInterests;
    public static ArrayList<String> getUserInterests(){return userInterests;}
    public static void setUserInterests(ArrayList<String> interest_list){userInterests = interest_list;}
    public static String getUserStringInterests(){
        StringBuilder s = new StringBuilder();
        int counter = 1;
        for (String str: userInterests){
            if (counter < userInterests.size()){
                counter ++;
                s.append(str).append(", ");
            } else {
                s.append(str);
            }
        }
        return s.toString();
    }

    private static int userAge;
    public static int getUserAge(){return userAge;}
    public static void setUserAge(int i){userAge = i;}

}
