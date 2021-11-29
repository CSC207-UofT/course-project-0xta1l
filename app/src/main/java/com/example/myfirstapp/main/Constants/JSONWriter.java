package com.example.myfirstapp.main.Constants;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSONWriter {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void writeRecipes (String filepath){
        // create a list of recipes from GENRELIBRARY
        ArrayList<Recipe> recipes = new ArrayList<>();
        recipes.addAll(Constants.GENRELIBRARY.getAllRecipes("All").values());

        // create writer
        try{
            Writer writer = new FileWriter("temp_data.json");

            // convert users list to JSON file
            new Gson().toJson(recipes, writer);

            // close writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void writeUsers (String filepath){
        // create a list of recipes from GENRELIBRARY
        ArrayList<User> users = new ArrayList<>();
        users.addAll(Constants.USERSECURITY.getUsernames().values());
        // create writer
        try{
            Writer writer = new FileWriter(filepath);

            // convert users list to JSON file
            new Gson().toJson(users, writer);

            // close writer
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
