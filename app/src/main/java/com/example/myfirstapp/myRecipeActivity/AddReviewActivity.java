package com.example.myfirstapp.myRecipeActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Controllers.UserRequestCreateReview;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;

import java.util.HashMap;

public class AddReviewActivity extends AppCompatActivity {

    private User user;
    private HashMap<Integer, Recipe> recipes;
    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_review);

        this.user = Constants.USERSECURITY.getUserByID(Globals.getUser_username());
        this.recipes = user.getSavedRecipesHash();
        this.recipe = recipes.get(Globals.getViewRecipeId());
        setTitle(recipe.getName());

        setTitle("New Review - " + recipe.getName());
    }

    public void submitReview(View v) {
        UserRequestCreateReview reviewController = new UserRequestCreateReview();
        EditText commentText = findViewById(R.id.add_review_text);
        String comment = commentText.getText().toString();
        EditText ratingText = findViewById(R.id.add_rating_text);
        int rating = Integer.parseInt(ratingText.getText().toString());
        reviewController.reviewRecipe(user.getUsername(), recipe.getID(), comment, rating);
        finish();
    }
}