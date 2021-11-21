package com.example.myfirstapp.genreActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Controllers.UserRequestSort;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class GenreItemActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(Globals.getViewGenreName());
        setContentView(R.layout.activity_genre_item);
        HashMap<Integer, Recipe> recipesHash = Constants.GENRELIBRARY.getAllRecipes(Globals.getViewGenreName());
        ArrayList<Recipe> recipesRecipe = new ArrayList<>(recipesHash.values());
        ArrayList<Preview> recipes = new ArrayList<>();
        for (Recipe recipeRecipe: recipesRecipe) {
            recipes.add(recipeRecipe.getPreview());
        }
        showItems(recipes);
        Spinner spinner = (Spinner) findViewById(R.id.genreRecipeSortSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.recipe_sort_by, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner

        GenreItemActivity that = this;

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // An item was selected. You can retrieve the selected item using
                // parent.getItemAtPosition(pos)
                View constraintLayout = findViewById(R.id.GenreItemConstraintLayout);
                ArrayList<Preview> previews = new ArrayList<Preview>();
                for (Preview recipePreview: recipes) {
                    previews.add(recipePreview);
                }
                UserRequestSort sortController = new UserRequestSort();

                String item = (String) parent.getItemAtPosition(position);

                switch (item) {
                    case "Alphabetical":
                        that.showItems(sortController.sort(previews, ""));
                        break;
                    case "Rating":
                        that.showItems(sortController.sort(previews, "Rating"));
                        break;
                    case "Interest":
                        String username = Globals.getUser_username();
                        that.showItems(sortController.sort(previews, "Interest"));
                        // TODO: figure out why user has a bug
                        break;

                }
                // TODO: sort interest

                Spinner spinner = (Spinner) findViewById(R.id.genreRecipeSortSpinner);
                spinner.setOnItemSelectedListener(this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                View constraintLayout = findViewById(R.id.GenreItemConstraintLayout);
            }
        });

    }
    public void showItems(ArrayList<Preview> recipes) {
        GenreItemActivity that = this;
        LinearLayout layout = (LinearLayout) this.findViewById(R.id.GenreItemLayout);
        layout.removeAllViews();
        for(Preview recipePreview: recipes) {
            TextView text = new TextView(this);
            text.setGravity(Gravity.CENTER);
            text.setTextColor(getResources().getColor(android.R.color.black));
            text.setPadding(100, 60, 0, 0);
            text.setTextSize(24);
            text.setGravity(Gravity.LEFT);
            String recipeName = recipePreview.getName();
            text.setText(recipeName);
            text.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
            text.setClickable(true);
            int id = recipePreview.getID();
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