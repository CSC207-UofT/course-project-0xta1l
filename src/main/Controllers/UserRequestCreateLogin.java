package Controllers;

//import UI.UserInputStatus;
import Constants.*;
import Entities.UserSecurity;
import UseCases.UserCreate;
import UseCases.*;

import java.util.ArrayList;


public class UserRequestCreateLogin{

    public String createUser(ArrayList<Object> userInfo) throws Exception {
        if(userInfo.size()!=6){
            throw new Exception("You are missing information");
        }

        String username = (String) userInfo.get(0);
        String password = (String) userInfo.get(1);
        String displayName = (String) userInfo.get(2);
        int age = (int) userInfo.get(3);
        String biography = (String) userInfo.get(4);
        ArrayList<String> interests = (ArrayList<String>) userInfo.get(5);
        UserCreate userCreatee = new UserCreate();
        boolean UserMade = userCreatee.userCreate(displayName,age, password, username, biography, interests);
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