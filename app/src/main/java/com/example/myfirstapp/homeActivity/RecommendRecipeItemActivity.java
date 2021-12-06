package com.example.myfirstapp.homeActivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Controllers.UserRequestSaveRecipe;
import com.example.myfirstapp.main.Entities.Recipe;

import java.util.ArrayList;

public class RecommendRecipeItemActivity extends AppCompatActivity {
    /**
     * //        The page where user are able to see all the
     * //        recommended recipe details based on the user's interests
     */

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_recipe_item);
        Recipe recipe = Globals.getRecipe();
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

        String imgName = "img_" + String.valueOf(recipe.getID());
        ImageView mImageView = findViewById(R.id.recipeItemImage);
        mImageView.setImageResource(getResources().getIdentifier(imgName, "drawable", getPackageName()));

    }

    public void saveRecipe(View v) throws Exception {
        try {
            UserRequestSaveRecipe saveController = new UserRequestSaveRecipe();
            saveController.saveRecipe(Globals.getUser_username(), String.valueOf(Globals.getViewRecipeId()));
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            Notification.displaySnackBar(findViewById(R.id.recommendRecipePage), "Menu already saved!", "top");
        }
    }

    public void showReviews(View v) {
        Context context = RecommendRecipeItemActivity.this;
        Intent intent = new Intent(context, RecommendRecipeReviewActivity.class);
        startActivity(intent);
    }
}