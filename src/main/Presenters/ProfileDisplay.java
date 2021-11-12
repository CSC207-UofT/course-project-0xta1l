package Presenters;

import Entities.UserInfo;

public class ProfileDisplay {
    public void displayProfile(UserInfo profile) {
        System.out.println("Username: " + profile.getUsername());
        System.out.println("Display Name: " + profile.getDisplayName());
        System.out.println("Age: " + profile.getAge());
        System.out.println("Biography: " + profile.getBiography());
        System.out.println("Interests: " + profile.getInterests().toString());
    }
}
