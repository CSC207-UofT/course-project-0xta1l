package com.example.myfirstapp.main.Controllers;
import com.example.myfirstapp.main.Entities.UserInfo;
import com.example.myfirstapp.main.UseCases.UserProfileViewEdit;

public class UserRequestProfile {
    private UserProfileViewEdit profile = new UserProfileViewEdit();
    /**
     * Displays the profile of a specific user
     * @param username is the username of the requested user
     * @return the user's profile
     */
    public UserInfo getProfile (String username) {
        return profile.get(username);
    }

    /**
     * Changes password of a specific user
     * @param username is the username of the requested user
     * @param password the user's new password
     * @param oldPassword the user's old password
     * @return whether the password has been successfully changed
     */
    public boolean changePassword (String username, String password, String oldPassword) {
        return true;
    }
}
