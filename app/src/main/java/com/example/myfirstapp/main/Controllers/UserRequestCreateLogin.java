package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.UseCases.UserCreate;

import java.util.ArrayList;


public class UserRequestCreateLogin{
    /**
     * Creates a user
     * @param username is the username of a given User
     * @param password is the password of a given User
     * @param displayName is the display name of a given user
     * @param age is the age of the given user
     * @param biography is the biography of the given user
     * @param interestList is the interests of the given user
     * @return a string representing the username
     */
    public String createUser(String username, String password, String displayName, int age, String biography, ArrayList<String> interestList) throws Exception {
        UserCreate userCreatee = new UserCreate();
        boolean UserMade = userCreatee.userCreate(username, password, displayName, age, biography, interestList);
        if (UserMade) {
            return username;
        } else {
            throw new Exception("There was an error.");
        }
    }
    /**
     * Logins in  a user
     * @param username is the username of a given User
     * @param password is the password of a given User
     * @return whether the user was logged in
     */
    public boolean loginUser(String username, String password) {
        //boolean validated = Constants.USERSECURITY.validateLogin(username, password);
        //return validated;
        return Constants.USERSECURITY.checkPassword(username, password);
    }
}