package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestGetReview;
import com.example.myfirstapp.main.Controllers.UserRequestProfile;
import com.example.myfirstapp.main.Presenters.ListDisplay;
import com.example.myfirstapp.main.Presenters.ProfileDisplay;

public class ViewUserReviews extends Command {
    public static String COMMANDSTRING = "view user reviews";

    ViewUserReviews(){
        setCOMMANDSTRING(COMMANDSTRING);
    }

    @Override
    public void execute(String username) {
        UserRequestGetReview get = new UserRequestGetReview();
        ListDisplay display = new ListDisplay();
        display.userReviews(get.getuserreview(username));
    }
}
