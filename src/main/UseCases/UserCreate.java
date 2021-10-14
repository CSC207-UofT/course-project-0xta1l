package UseCases;

import Entities.User;
import Entities.UserSecurity;

import java.util.ArrayList;

//userCreate method (Handles User Creation)
//        Takes in a list of properties for user attributes,
//        Checks if username is in UserSecurity.getUsernames().getKeys()
//        If not in Usernames keys, create new User
//        If in Usernames keys, do not create new User
//        Returns a bool, True if User has been created, False if Username already exists

class UserCreateUseCase {

    public boolean userCreate(String displayname, int age, String password, String username, String biography,
                              ArrayList<String> interests){
        User user = new User();
        UserSecurity usersecurity = new UserSecurity();
        if (usersecurity.getUsernames().containsKey(user.getUsername())){
            return false;
        } else{
            User new_user = new User();
            new_user.setDisplayName(displayname);
            new_user.setAge(age);
            new_user.setPassword(password);
            new_user.setUsername(username);
            new_user.setBiography(biography);
            new_user.setInterests(interests);
            return true;
        }
    }
}