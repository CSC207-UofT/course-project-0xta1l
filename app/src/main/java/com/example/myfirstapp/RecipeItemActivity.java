package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Controllers.UserRequestSaveRecipe;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class RecipeItemActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // recipeItemIngredients
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_item);

        System.out.println("The recipe id is : " + Globals.getViewRecipeId());

        User user = Constants.USERSECURITY.getUserByID(Globals.getUser_username());
        HashMap<Integer, Recipe> recipes = user.getSavedRecipesHash();
        System.out.println("recipes is " + recipes);
        Recipe recipe = recipes.get(Globals.getViewRecipeId());
        setTitle(recipe.getName());

        TextView recipeItemGenre = findViewById(R.id.recipeItemGenre);
        recipeItemGenre.setText("Genres: " + recipe.getGenreStrings());

        TextView recipeItemId = findViewById(R.id.recipeItemId);
        recipeItemId.setText("ID: " + recipe.getID());

        TextView recipeItemIngredients = findViewById(R.id.recipeItemIngredients);
        recipeItemIngredients.setText("Ingredients: " + recipe.getIngredients());

        TextView recipeItemInstructions = findViewById(R.id.recipeItemInstructions);
        recipeItemInstructions.setText("Instructions: " + recipe.getInstructions());

        TextView recipeItemRating = findViewById(R.id.recipeItemRating);
        recipeItemRating.setText("Rating " + recipe.getRating());

        String imgName = "img_" + String.valueOf(recipe.getID());
        ImageView mImageView = findViewById(R.id.recipeItemImage);
        mImageView.setImageResource(getResources().getIdentifier(imgName, "drawable", getPackageName()));

        // TODO: add to drawables img_ID

    }
    public void deleteRecipe(View v) throws Exception {
        try {
            UserRequestSaveRecipe saveController = new UserRequestSaveRecipe();
            saveController.deleteRecipe(Globals.getUser_username(), String.valueOf(Globals.getViewRecipeId()));
            finish();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}