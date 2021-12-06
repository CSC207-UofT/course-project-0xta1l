package com.example.myfirstapp.myRecipeActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Controllers.UserRequestSaveRecipe;
import com.example.myfirstapp.main.Entities.Recipe;

public class RecipeItemActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // recipeItemIngredients
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_item);

        Recipe recipe = Globals.getRecipe();
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
    }

    public void deleteRecipe(View v) throws Exception {
        try {
            UserRequestSaveRecipe saveController = new UserRequestSaveRecipe();
            saveController.deleteRecipe(Globals.getUser_username(), String.valueOf(Globals.getViewRecipeId()));
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addReview(View v) {
        Context context = RecipeItemActivity.this;
        Intent intent = new Intent(context, AddReviewActivity.class);
        startActivity(intent);
    }
}