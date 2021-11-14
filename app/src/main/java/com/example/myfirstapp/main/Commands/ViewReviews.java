package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestGetReview;
import com.example.myfirstapp.main.Presenters.ListDisplay;

public class ViewReviews extends RecipeCommand {
    public static String COMMANDSTRING = "view reviews";

    ViewReviews(){
        setCOMMANDSTRING(COMMANDSTRING);
        addSubCommands(new AddReview());
    }

    @Override
    public void execute(String username, String recipeID) throws Exception {
        UserRequestGetReview get = new UserRequestGetReview();
        ListDisplay display = new ListDisplay();
        display.recipeReviews(get.getrecipereview(recipeID));
    }

    @Override
    public void execute(String username) throws Exception {
        System.out.println("An error has occurred.");
    }
}
