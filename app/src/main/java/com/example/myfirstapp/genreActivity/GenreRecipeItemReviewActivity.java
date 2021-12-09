package com.example.myfirstapp.genreActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;

import java.util.HashMap;

public class GenreRecipeItemReviewActivity extends AppCompatActivity {
    /**
     * //        The page where user are able to see all the
     * //        reviews of the recipe selected
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre_recipe_item_review);
        HashMap<Integer, Recipe> recipes = Constants.GENRELIBRARY.getAllRecipes(Globals.getViewGenreName());


        Recipe recipe = recipes.get(Globals.getViewRecipeId());
        HashMap<String, Review> reviews = recipe.getRecipeReviews();
        setTitle(recipe.getName() + " - Reviews");

        LinearLayout layout = (LinearLayout) this.findViewById(R.id.GenreRecipeReviewLayout);
        layout.removeAllViews();
        for (Review review : reviews.values()) {
            RelativeLayout view = this.createRecipeReview(review);
            layout.addView(view);
        }

    }

    public RelativeLayout createRecipeReview(Review review) {
        RelativeLayout p = new RelativeLayout(this);
        TextView text = new TextView(this);
        text.setGravity(Gravity.CENTER);
        text.setGravity(Gravity.LEFT);
        text.setTextColor(getResources().getColor(android.R.color.black));
        text.setPadding(20, 0, 40, 0);
        text.setTextSize(24);
        text.setText("Name: " + review.getUsername());
        text.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        p.addView(text);

        TextView text2 = new TextView(this);
        text2.setGravity(Gravity.CENTER);
        text2.setGravity(Gravity.LEFT);
        text2.setTextColor(getResources().getColor(android.R.color.black));
        text2.setPadding(40, 80, 40, 0);
        text2.setText("Rating: " + review.getRating());
        text2.setTextSize(18);
        text2.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        p.addView(text2);

        TextView text3 = new TextView(this);
        text3.setGravity(Gravity.CENTER);
        text3.setGravity(Gravity.LEFT);
        text3.setTextColor(getResources().getColor(android.R.color.black));
        text3.setPadding(40, 140, 40, 60);
        text3.setText("Comments: " + review.getComments());
        text3.setTextSize(18);
        text3.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        p.addView(text3);
        return p;
    }
}