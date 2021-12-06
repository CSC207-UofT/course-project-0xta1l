package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

//userCreate method (Handles User Creation)

/**
 * //        Takes in a list of properties for user attributes,
 * //        Checks if username is in UserSecurity.getUsernames().getKeys()
 * //        If not in Usernames keys, create new User
 * //        If in Usernames keys, do not create new User
 * //        Returns a bool, True if User has been created, False if Username already exists
 */
public class UserCreate {
    /**
     * creates user from user attributes
     *
     * @param username      the user's unique identifier; used in conjunction with password to login
     * @param displayName   the name the user chooses to make public
     * @param age           the age of the user
     * @param biography     a description of the user
     * @param interests     a list of genres the user is interested in
     * @param existingUsers a HashMap of existing usernames to User entities
     * @param genreList     a list of all existing recipe genres
     * @return the User created
     */
    public User userCreate(String username, String password, String displayName, int age, String biography,
                           ArrayList<String> interests, HashMap<String, User> existingUsers, ArrayList<String> genreList) {
        if (existingUsers.containsKey(username)) {
            return null;
        } else {
            User newUser = new User(username, password, displayName, age, biography, interests, genreList);
            return newUser;
        }
    }
}