package com.example.myfirstapp.main.Gateways;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * This class is responsible for creating new entries in the database.
 */
public class Create {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();

    /**
     * Creates a new user entry in the database
     */
    public static void createUser(User user) {
        DatabaseReference reference = database.getReference("users/" + user.getUsername());
        reference.setValue(user);
    }

    /**
     * Creates a new recipe entry in the database
     */
    public static void createRecipe(Recipe recipe) {
        DatabaseReference reference = database.getReference("recipes/" + recipe.getID());
        reference.setValue(recipe);
    }

    // test function for createUser
    public static void testCreate() {
        ArrayList<String> interests = new ArrayList<>();
        interests.add("Western");

        User tester = new User("mir", "pw", "name", 9, "bio", interests, Constants.GENRELIBRARY.getAllGenres());
        Create.createUser(tester);

    }

    // test function for createRecipe
    public static void testRecipe() {
        ArrayList<String> interests = new ArrayList<>();
        interests.add("Western");
        Recipe recipe = new Recipe("nada", "love", interests, "bun up food", 7, 322, "img_208.png",
                "short n sweet", 10);
        Create.createRecipe(recipe);
    }
}