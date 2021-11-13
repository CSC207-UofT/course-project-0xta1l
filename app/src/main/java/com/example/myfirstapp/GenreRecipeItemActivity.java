package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;

import java.util.HashMap;

public class GenreRecipeItemActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_recipe_item);

        HashMap<Integer, Recipe> recipes = Constants.GENRELIBRARY.getAllRecipes(Globals.getViewGenreName());
        Recipe recipe = recipes.get(Globals.getViewRecipeId());
        setTitle(recipe.getName());

        TextView recipeItemGenre = findViewById(R.id.genreRecipeItemGenre);
        recipeItemGenre.setText("Genres: " + recipe.getGenreStrings());

        TextView recipeItemId = findViewById(R.id.genreRecipeItemId);
        recipeItemId.setText("ID: " + recipe.getID());

        TextView recipeItemIngredients = findViewById(R.id.genreRecipeItemIngredients);
        recipeItemIngredients.setText("Ingredients: " + recipe.getIngredients());

        TextView recipeItemInstructions = findViewById(R.id.genreRecipeItemInstructions);
        recipeItemInstructions.setText("Instructions: " + recipe.getInstructions());

        TextView recipeItemRating = findViewById(R.id.genreRecipeItemRating);
        recipeItemRating.setText("Rating " + recipe.getRating());

    }
}