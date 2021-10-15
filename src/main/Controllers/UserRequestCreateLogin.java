package Controllers;

import Presenters.UserInputStatus;
import UserSecurity; // constant? not an argument for createUser
import Entities.UserSecurity;
import UseCases.UserCreate;

import java.util.ArrayList;


public class UserRequestCreateLogin{

    public void createUser(ArrayList<Object> userInfo) throws Exception {
        if(userInfo.size()!=5){
            throw new Exception("You are missing information");
        }

        String displayName = (String) userInfo.get(0);
        int age = (int) userInfo.get(1);
        String password = (String) userInfo.get(2);
        String username = (String) userInfo.get(3);
        String biography = (String) userInfo.get(4);
        ArrayList<String> interests = (ArrayList<String>) userInfo.get(5);
        UserCreate userCreatee = new UserCreate();
        UserInputStatus(userCreatee.userCreate(displayName,age, password, username, biography, interests));
    }
}
