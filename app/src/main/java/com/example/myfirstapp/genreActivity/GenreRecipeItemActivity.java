package com.example.myfirstapp.genreActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Controllers.UserRequestSaveRecipe;
import com.example.myfirstapp.main.Entities.Recipe;

import java.util.HashMap;

public class GenreRecipeItemActivity extends AppCompatActivity {

    /**
     * //        The page where user are able to see information of the
     * //        recipe selected
     * //        User can save recipe or view reviews
     */
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
            Notification.displaySnackBar(findViewById(R.id.genreRecipeItemPage), "Menu already saved!", "top");
        }
    }

    public void showReviews(View v) {
        Context context = GenreRecipeItemActivity.this;
        Intent intent = new Intent(context, GenreRecipeItemReviewActivity.class);
        startActivity(intent);
    }
}