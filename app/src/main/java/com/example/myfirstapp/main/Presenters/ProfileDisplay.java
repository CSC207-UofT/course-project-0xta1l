package com.example.myfirstapp.main.Presenters;

import com.example.myfirstapp.main.Entities.UserInfo;

public class ProfileDisplay {
    /**
     * Prints the user's to the screen
     * @param profile is the information for which you want to browse by
     * @return nothing
     */
    public void displayProfile(UserInfo profile) {
        System.out.println("Username: " + profile.getUsername());
        System.out.println("Display Name: " + profile.getDisplayName());
        System.out.println("Age: " + profile.getAge());
        System.out.println("Biography: " + profile.getBiography());
        System.out.println("Interests: " + profile.getInterests().toString());
    }
}
