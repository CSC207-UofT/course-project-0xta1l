package com.example.myfirstapp.main.Controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.UseCases.GetRecipe;

public class UserRequestRecipeView {
    /**
     * Displays the profile of a specific user
     * @param id is the id of the requested recipe
     * @return a preview of the recipe
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public com.example.myfirstapp.main.Entities.Preview recipeView(String id) throws Exception {
        GetRecipe getRecipe = new GetRecipe();
        try {
            return getRecipe.getSingleRecipe(Integer.parseInt(id),"full");
        } catch (Exception e) {
            System.out.println("Not a valid recipe ID.");
        }
        return getRecipe.getSingleRecipe(Integer.parseInt(id),"full");
    }
}
