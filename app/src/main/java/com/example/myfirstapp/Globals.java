package com.example.myfirstapp;

import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;
import com.google.android.material.snackbar.Snackbar;

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


    private static User user;
    public static User getUser(){
        return user;
    }
    public static void setUser(User new_user){
        user = new_user;
    }
    public static String getUser_username(){
        return user.getUsername();
    }
    public static void setUser_username(String s) {
        if (!"".equals(getUser_username())){
            Constants.USERSECURITY.changeUsername(getUser_username(), s);
        }
    }

    public static String getUser_password(){
        return user.getPassword();
    }
    public static void setUser_password(String s) {
        Constants.USERSECURITY.changePassword(getUser_username(),s);
    }

    public static String getUser_name(){
        return user.getDisplayName();
    }
    public static void setUser_name(String name) {
        Constants.USERSECURITY.changeName(getUser_username(), name);
    }

    public static String getUser_bio(){
        return user.getBiography();
    }
    public static void setUser_bio(String bio) {
        Constants.USERSECURITY.changeBio(getUser_username(), bio);
    }

    public static ArrayList<String> getUserInterests(){return user.getInterests();}
    public static String getUserStringInterests(){
        StringBuilder s = new StringBuilder();
        int counter = 1;
        for (String str: getUserInterests()){
            if (counter < getUserInterests().size()){
                counter ++;
                s.append(str).append(", ");
            } else {
                s.append(str);
            }
        }
        return s.toString();
    }

    public static int getUserAge(){return user.getAge();}
    public static void setUserAge(int i){
        Constants.USERSECURITY.getUserByID(getUser_username()).setAge(i);
    }
}
