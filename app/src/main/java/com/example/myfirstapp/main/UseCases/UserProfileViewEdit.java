package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserInfo;
import com.example.myfirstapp.main.Gateways.Constants;

public class UserProfileViewEdit {
    /**
     * gets the user's profile
     * @param user is the specified user
     * @return user's UserInfo profile
     */
    public UserInfo get (User user) {
        return user.getProfile();
    }

    /**
     * edits the password of the user
     * @param username is the username of a specified user
     * @param newPassword new password desired by the user
     * @return void
     */
    public void editPassword (String username, String newPassword) {
        Constants.USERSECURITY.changePassword(username, newPassword);
    }
}
