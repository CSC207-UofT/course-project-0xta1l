package com.example.myfirstapp.genreActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Controllers.UserRequestSort;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.Recipe;

import java.util.ArrayList;
import java.util.HashMap;

public class GenreItemActivity extends AppCompatActivity {
    /**
     * //        The page where user are able to see all the
     * //        available recipes based on genre selected
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(Globals.getViewGenreName());
        setContentView(R.layout.activity_genre_item);
        HashMap<Integer, Recipe> recipesHash = Constants.GENRELIBRARY.getAllRecipes(Globals.getViewGenreName());
        ArrayList<Recipe> recipesRecipe = new ArrayList<>(recipesHash.values());
        ArrayList<Preview> recipes = new ArrayList<>();
        for (Recipe recipeRecipe : recipesRecipe) {
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
                for (Preview recipePreview : recipes) {
                    previews.add(recipePreview);
                }
                UserRequestSort sortController = new UserRequestSort();

                String item = (String) parent.getItemAtPosition(position);

                //TODO save spinner state
                switch (item) {
                    case "Alphabetical":
                        that.showItems(sortController.sort(previews, ""));
                        break;
                    case "Rating":
                        that.showItems(sortController.sort(previews, "Rating"));
                        break;
                    case "Interest":
                        String username = Globals.getUser_username();
                        that.showItems(sortController.sort(previews, "Interests", username));

                        break;

                }

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
        LinearLayout layout = (LinearLayout) this.findViewById(R.id.GenreItemLayout);
        layout.removeAllViews();
        for (Preview recipePreview : recipes) {
            RelativeLayout preview = this.createRecipePreview(recipePreview);
            layout.addView(preview);
        }
    }

    public TextView createRecipeName(Preview recipePreview, int height) {
        TextView text = new TextView(this);
        text.setGravity(Gravity.CENTER);
        text.setTextColor(getResources().getColor(android.R.color.black));
        text.setPadding(40, 40 + height, 40, 0);
        text.setTextSize(24);
        text.setTypeface(null, Typeface.BOLD);
        text.setGravity(Gravity.LEFT);
        String recipeName = recipePreview.getName();
        text.setText(recipeName);
        text.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        text.setClickable(true);
        int id = recipePreview.getID();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = GenreItemActivity.this;
                Globals.setViewRecipeId(id);
                Intent intent = new Intent(context, GenreRecipeItemActivity.class);
                startActivity(intent);
            }
        });
        return text;
    }

    public TextView createRecipeDetail(Preview recipePreview, int height) {
        TextView text = new TextView(this);
        text.setGravity(Gravity.CENTER);
        text.setTextColor(getResources().getColor(android.R.color.black));
        text.setPadding(100, 200 + height, 40, 40);
        text.setTextSize(18);
        text.setGravity(Gravity.LEFT);
        String recipeDescription = recipePreview.getDescription();
        text.setText(recipeDescription);
        text.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        text.setClickable(true);
        int id = recipePreview.getID();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = GenreItemActivity.this;
                Globals.setViewRecipeId(id);
                Intent intent = new Intent(context, GenreRecipeItemActivity.class);
                startActivity(intent);
            }
        });
        return text;
    }

    public ImageView createRecipeImage(Preview recipePreview) {
        ImageView text = new ImageView(this);
        int id = recipePreview.getID();
        String imgName = "img_" + String.valueOf(id);
        text.setImageResource(getResources().getIdentifier(imgName, "drawable", getPackageName()));
        text.setPadding(10, 20, 0, 0);
        text.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        text.setClickable(true);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = GenreItemActivity.this;
                Globals.setViewRecipeId(id);
                Intent intent = new Intent(context, GenreRecipeItemActivity.class);
                startActivity(intent);
            }
        });
        return text;
    }

    public int getImageHeight(Preview recipePreview) {
        ImageView text = new ImageView(this);
        text.setAdjustViewBounds(true);
        int id = recipePreview.getID();
        String imgName = "img_" + String.valueOf(id);
        text.setImageResource(getResources().getIdentifier(imgName, "drawable", getPackageName()));
        text.setPadding(10, 20, 0, 0);
        text.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        int height = text.getDrawable().getIntrinsicHeight();
        return height;
    }

    public RelativeLayout createRecipePreview(Preview recipe) {
        RelativeLayout preview = new RelativeLayout(this);
        preview.addView(this.createRecipeImage(recipe));
        int height = this.getImageHeight(recipe);
        preview.addView(this.createRecipeName(recipe, height));
        preview.addView(this.createRecipeDetail(recipe, height));
        return preview;
    }

}
