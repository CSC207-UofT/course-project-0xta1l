package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.UseCases.RecipeSave;

import java.util.ArrayList;

public class UserRequestSaveRecipe {
    private RecipeSave recipeSave = new RecipeSave();
    public boolean saveRecipe(String username, String recipeID) throws Exception {
        return recipeSave.saveToUser(username, Integer.parseInt(recipeID), "All");
    }

    public boolean deleteRecipe(String username, String recipeID) throws Exception {
        return recipeSave.deleteFromUser(username, Integer.parseInt(recipeID));
    }


}
