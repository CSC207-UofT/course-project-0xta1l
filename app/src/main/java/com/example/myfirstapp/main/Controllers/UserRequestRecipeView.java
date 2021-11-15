package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.UseCases.GetRecipe;

public class UserRequestRecipeView {
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
