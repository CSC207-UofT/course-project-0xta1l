package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserInfo;
import com.example.myfirstapp.main.Entities.UserSecurity;

import java.util.ArrayList;

public class UserProfileViewEdit {
    /**
     * gets the user's profile
     *
     * @param user is the specified user
     * @return user's UserInfo profile
     */
    public UserInfo get(User user) {
        return user.getProfile();
    }


    public void editUsername(String username, String newUsername, UserSecurity userSecurity) {
        userSecurity.changeUsername(username, newUsername);
    }

    /**
     * changes the password of the user
     *
     * @param username     is the username of a specified user
     * @param newPassword  new password desired by the user
     * @param userSecurity is the repository of users
     * @return void
     */
    public void editPassword(String username, String newPassword, UserSecurity userSecurity) {
        userSecurity.changePassword(username, newPassword);
    }

    public void editBio(String username, String newBio, UserSecurity userSecurity) {
        userSecurity.changeBio(username, newBio);
    }

    public void editAge(String username, int newAge, UserSecurity userSecurity) {
        userSecurity.changeAge(username, newAge);
    }

    public void editName(String username, String newName, UserSecurity userSecurity) {
        userSecurity.changeName(username, newName);
    }

    public void editInterests(String username, ArrayList<String> interests, UserSecurity userSecurity) {
        userSecurity.changeInterests(username, interests);
    }
}
