package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserInfo;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Gateways.Update;
import com.example.myfirstapp.main.UseCases.UserProfileViewEdit;

import java.util.ArrayList;

public class UserRequestProfile {
    private UserProfileViewEdit profile = new UserProfileViewEdit();

    /**
     * Displays the profile of a specific user
     *
     * @param username is the username of the requested user
     * @return the user's profile
     */
    public UserInfo getProfile(String username) {
        User user = Constants.USERSECURITY.getUserByID(username);
        return profile.get(user);
    }

    /**
     * Verifies and changes password of a specific user
     *
     * @param username    is the username of the requested user
     * @param password    the user's new password
     * @param oldPassword the user's old password
     * @return whether the password has been successfully changed
     */
    public boolean changePassword(String username, String password, String oldPassword) {
        boolean verified = Constants.USERSECURITY.validateLogin(username, oldPassword);
        if (verified) {
            profile.editPassword(username, password, Constants.USERSECURITY);
            Update.userProfile(username, password, "password");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Overloads change password to not include verification
     *
     * @param username is the username of the requested user
     * @param password the user's new password
     * @return whether the password has been successfully changed
     */
    public void changePassword(String username, String password) {
        profile.editPassword(username, password, Constants.USERSECURITY);
        Update.userProfile(username, password, "password");
    }

    public boolean changeUsername(String username, String newUsername) {
        boolean taken = Constants.USERSECURITY.getUsernames().containsKey(newUsername);
        if (!taken) {
            User user = Constants.USERSECURITY.getUserByID(username);
            profile.editUsername(username, newUsername, Constants.USERSECURITY);
            Update.username(username, newUsername, user);
            return true;
        } else {
            return false;
        }
    }

    public void changeBio(String username, String newBio) {
        profile.editBio(username, newBio, Constants.USERSECURITY);
        Update.userProfile(username, newBio, "biography");
    }

    public void changeAge(String username, int age) {
        profile.editAge(username, age, Constants.USERSECURITY);
        Update.userProfile(username, age, "age");
    }

    public void changeName(String username, String name) {
        profile.editName(username, name, Constants.USERSECURITY);
        Update.userProfile(username, name, "displayName");
    }

    public void changeInterests(String username, ArrayList<String> interests) {
        User user = Constants.USERSECURITY.getUserByID(username);
        profile.editInterests(username, interests, Constants.USERSECURITY);
        Update.userProfile(username, interests, "interests");
        Update.userProfile(username, user.getGenreWeights(), "genreWeights");
    }


}
