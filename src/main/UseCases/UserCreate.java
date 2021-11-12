package UseCases;
import Constants.Constants;
import Entities.User;

import java.util.ArrayList;

//userCreate method (Handles User Creation)
//        Takes in a list of properties for user attributes,
//        Checks if username is in UserSecurity.getUsernames().getKeys()
//        If not in Usernames keys, create new User
//        If in Usernames keys, do not create new User
//        Returns a bool, True if User has been created, False if Username already exists

public class UserCreate {

    public boolean userCreate(String username, String password, String displayName, int age, String biography,
                              ArrayList<String> interests){
        if (Constants.USERSECURITY.getUsernames().containsKey(username)){
            return false;
        } else{
            User new_user = new User(username, password, displayName, age, biography, interests);
            Constants.USERSECURITY.addUser(new_user);
            return true;
        }
    }
}