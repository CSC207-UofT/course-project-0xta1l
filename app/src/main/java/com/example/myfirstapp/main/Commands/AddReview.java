package com.example.myfirstapp.main.Commands;

import com.example.myfirstapp.main.Controllers.UserRequestCreateReview;

import java.util.Scanner;

public class AddReview extends RecipeCommand {
    public static String COMMANDSTRING = "add review";

    AddReview(){
        setCOMMANDSTRING(COMMANDSTRING);
    }

    @Override
    public void execute(String username, String recipeID) {
        UserRequestCreateReview create = new UserRequestCreateReview();
        Scanner input = new Scanner(System.in);
        int rating = 0;
        boolean isNotInt = true;
        do {
            try {
                System.out.println("Rating (number between 1 and 5):");
                rating = Integer.parseInt(input.nextLine());
                if (1 <= rating && rating <= 5){
                    isNotInt = false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Not an integer between 1 and 5, please try again");
            }
        } while(isNotInt);
        System.out.println("Comment (Press enter to leave blank): ");
        String comment = input.nextLine();
        if (create.reviewRecipe(username, Integer.parseInt(recipeID), comment, rating)){
            System.out.println("Review saved.");
        } else {
            System.out.println("You have already reviewed this recipe.");
        }
    }

    @Override
    public void execute(String username) throws Exception {
        System.out.println("An error has occurred.");
    }
}
