package com.example.myfirstapp.main.Entities;

import android.os.Build;

import java.util.ArrayList;
import java.util.HashMap;

public class UserSecurity {
    // mapping of username to password
    private HashMap<String, String> UserPassword = new HashMap<>();

    // mapping of username to user
    private HashMap<String, User> UsernameList = new HashMap<>();

    /**
     * Return a list of all users
     *
     * @return a HashMap of usernames to User entities
     */
    public HashMap<String, User> getUsernames() {
        return UsernameList;
    }

    /**
     * Gets a specific user
     *
     * @param username is the username of the requested user
     * @return the User entity
     */
    public User getUserByID(String username) {
        return UsernameList.get(username);
    }

    /**
     * Checks if a user's attempted login is successful
     *
     * @param username is the username of the requested user
     * @param password is the attempted password
     * @return if the attempted password matches the saved password
     */
    public boolean validateLogin(String username, String password) {
        return UserPassword.get(username).equals(password);
    }

    /**
     * Checks if a user and password combination is successful
     *
     * @param username is the username of the requested user
     * @param password is the attempted password
     * @return if the attempted password is valid
     */
    public boolean checkPassword(String username, String password) {
        try {
            if (this.UserPassword.get(username).equals(password)) {
                System.out.println("Password is valid");
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Adds a User entity
     *
     * @param user is the requested user
     */
    public void addUser(User user) {
        UsernameList.put(user.getUsername(), user);
        UserPassword.put(user.getUsername(), user.getPassword());
    }

    /**
     * Methods to change User attributes:
     * •changePassword - updates a user's password
     * •changeBio - updates a user's biography
     * •changeAge -  updates a user's age
     * •changeName - updates a user's display name
     * •changeInterests - updates a user's interests
     */
    public void changePassword(String username, String password) {
        // Changes user password for given username
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            this.UserPassword.replace(username, password);
        }

        // sets the new password for user.
        this.UsernameList.get(username).setPassword(password);
    }

    public void changeUsername(String username, String newUsername) {
        User user = this.UsernameList.get(username);
        user.setUsername(newUsername);
        this.UsernameList.remove(username);
        this.UsernameList.put(newUsername, user);
    }

    public void changeBio(String username, String bio) {
        User user = this.UsernameList.get(username);
        user.setBiography(bio);
    }

    public void changeAge(String username, Integer age) {
        User user = this.UsernameList.get(username);
        user.setAge(age);
    }

    public void changeName(String username, String name) {
        User user = this.UsernameList.get(username);
        user.setDisplayName(name);
    }

    public void changeInterests(String username, ArrayList<String> interests) {
        User user = this.UsernameList.get(username);
        user.setInterests(user.getInterests(), interests);
    }
}
