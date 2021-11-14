package com.example.myfirstapp.main.Controllers;

//import UI.UserInputStatus;
import com.example.myfirstapp.main.Constants.*;
import com.example.myfirstapp.main.Entities.UserInfo;
import com.example.myfirstapp.main.UseCases.UserCreate;
import com.example.myfirstapp.main.UseCases.*;

import java.util.ArrayList;
import java.util.Arrays;


public class UserRequestCreateLogin{

    public String createUser(String username, String password, String displayName, int age, String biography, String interests) throws Exception {
        ArrayList<String> interestList = new ArrayList<>(Arrays.asList(interests.split(",\\s*")));
        UserCreate userCreatee = new UserCreate();
        boolean UserMade = userCreatee.userCreate(username, password, displayName, age, biography, interestList);
        if (UserMade) {
            return username;
        } else {
            throw new Exception("There was an error.");
        }
    }

    public boolean loginUser(String username, String password) {
        //boolean validated = Constants.USERSECURITY.validateLogin(username, password);
        //return validated;
        return Constants.USERSECURITY.checkPassword(username, password);
    }
}