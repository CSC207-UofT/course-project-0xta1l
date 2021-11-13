package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;

public class RecipeItemActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // recipeItemIngredients
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_item);

        User user = Constants.USERSECURITY.getUserByID(Globals.getUser_username());
        Recipe recipe = user.getSavedRecipes().get(Globals.getViewRecipeId());
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

    }
}