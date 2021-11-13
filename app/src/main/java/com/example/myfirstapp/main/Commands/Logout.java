package com.example.myfirstapp.main.Commands;

import java.util.ArrayList;

public class Logout extends Command{
    public static String COMMANDSTRING = "logout";

    Logout(){
        setCOMMANDSTRING(COMMANDSTRING);
    }

    @Override
    public void execute(String username) {

        System.out.println(username + " has been logged out. Have a good day! \n\n");
    }

}
