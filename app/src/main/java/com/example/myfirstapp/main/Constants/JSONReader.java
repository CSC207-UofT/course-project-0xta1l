package com.example.myfirstapp.main.Constants;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JSONReader {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static GenreLibrary readRecipes (String filepath){
        Gson gson = new Gson();
        try {
            GenreLibrary genreLibrary = new GenreLibrary();
            Reader reader = Files.newBufferedReader(Paths.get(filepath));
            List<Recipe> recipes = new Gson().fromJson(reader, new TypeToken<List<Recipe>>() {}.getType());
            //Recipe recipe = gson.fromJson(reader, Recipe.class);
            for (Recipe recipe: recipes){
                for (String genre: recipe.getGenre()){
                    genreLibrary.addRecipes(genre, recipe);
                }
                genreLibrary.addRecipes("All", recipe);
            }
            return genreLibrary;
        } catch (IOException e){
            System.out.println("file not found");
        }
        return new GenreLibrary();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static GenreLibrary readRecipes (Context c, String filepath){
        Gson gson = new Gson();
        try {
            GenreLibrary genreLibrary = new GenreLibrary();
            Reader reader = Files.newBufferedReader(Paths.get(filepath));
            List<Recipe> recipes = new Gson().fromJson(reader, new TypeToken<List<Recipe>>() {}.getType());
            //Recipe recipe = gson.fromJson(reader, Recipe.class);
            for (Recipe recipe: recipes){
                for (String genre: recipe.getGenre()){
                    genreLibrary.addRecipes(genre, recipe);
                }
                genreLibrary.addRecipes("All", recipe);
            }
            return genreLibrary;
        } catch (IOException e){
            System.out.println("file not found");
        }
        return new GenreLibrary();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static UserSecurity readUsers (String filepath){
        Gson gson = new Gson();
        try {
            UserSecurity userSecurity = new UserSecurity();
            Reader reader = Files.newBufferedReader(Paths.get(filepath));
            List<User> users = new Gson().fromJson(reader, new TypeToken<List<User>>() {}.getType());
            for (User user: users){
                userSecurity.addUser(user);
            }
            return userSecurity;
        } catch (IOException e){
            System.out.println("file not found");
        }
        return new UserSecurity();
    }

}
