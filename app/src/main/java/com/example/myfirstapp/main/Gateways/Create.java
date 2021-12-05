package com.example.myfirstapp.main.Gateways;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
public class Create{
    private static FirebaseDatabase database = FirebaseDatabase.getInstance(); // gets database from firebase
    public static void createUser(User user){
        //method that writes a user object to the database storing it by username
        DatabaseReference reference = database.getReference("users/"+user.getUsername());
        reference.setValue(user);
    }
    public static void createRecipe(Recipe recipe){
        //method that writes a recipe object to the database storing it by id
        DatabaseReference reference = database.getReference("recipes/"+ recipe.getID());
        reference.setValue(recipe);
    }
    public static void testCreate(){
        //method that tests if  a user object is written to the database 
        ArrayList<String> interests = new ArrayList<>();
        interests.add("Western");

        User tester = new User("mir", "pw", "name", 9, "bio", interests);
        Create.createUser(tester);

    }
    public static void testRecipe(){
            //method that tests if  a recipe object is written to the database 
        ArrayList<String> interests = new ArrayList<>();
        interests.add("Western");
         Recipe recipe = new Recipe("nada", "love",interests, "bun up food", 7, 322, "img_208.png",
                "short n sweet", 10);
        Create.createRecipe(recipe);

    }
}
