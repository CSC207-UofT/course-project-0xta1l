package UseCases;
import Constants.Constants;
import Entities.User;
import Entities.UserSecurity;

import java.util.ArrayList;

//userCreate method (Handles User Creation)
//        Takes in a list of properties for user attributes,
//        Checks if username is in UserSecurity.getUsernames().getKeys()
//        If not in Usernames keys, create new User
//        If in Usernames keys, do not create new User
//        Returns a bool, True if User has been created, False if Username already exists

public class UserCreate {

    public boolean userCreate(String displayName, int age, String password, String username, String biography,
                              ArrayList<String> interests){
        if (Constants.USERSECURITY.getUsernames().containsKey(username)){
            return false;
        } else{
            User new_user = new User();
            new_user.setDisplayName(displayName);
            new_user.setAge(age);
            new_user.setPassword(password);
            new_user.setUsername(username);
            new_user.setBiography(biography);
            for (String i:interests){new_user.addInterests(i);}
            Constants.USERSECURITY.addUser(new_user);
            return true;
        }
    }
}