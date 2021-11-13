package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;

import java.util.ArrayList;
import java.util.HashMap;

public class GenreItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(Globals.getViewGenreName());
        setContentView(R.layout.activity_genre_item);
        HashMap<Integer, Recipe> recipes = Constants.GENRELIBRARY.getAllRecipes(Globals.getViewGenreName());
        GenreItemActivity that = this;
        LinearLayout layout = (LinearLayout) this.findViewById(R.id.GenreItemLayout);
        for(Recipe recipe: recipes.values()) {
            TextView text = new TextView(this);
            text.setGravity(Gravity.CENTER);
            text.setTextColor(getResources().getColor(android.R.color.black));
            text.setPadding(100, 60, 0, 0);
            text.setTextSize(24);
            text.setGravity(Gravity.LEFT);
            String recipeName = recipe.getName();
            text.setText(recipeName);
            text.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
            text.setClickable(true);
            int id = recipe.getID();
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = that;
                    Globals.setViewRecipeId(id);
                    Intent intent = new Intent(context, GenreRecipeItemActivity.class);
                    startActivity(intent);
                }
            });

            layout.addView(text);
        }

    }
}