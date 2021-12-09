package com.example.myfirstapp.homeActivity;

import android.graphics.Typeface;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Controllers.UserRequestRecommend;
import com.example.myfirstapp.main.Entities.Preview;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    /**
     * //        The page where user are able to see all the
     * //        recommended recipes based on the user's interests
     */
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        ArrayList<Preview> recipes = getRecommendedRecipes();
        this.showItems(recipes, v);
        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<Preview> getRecommendedRecipes() {
        UserRequestRecommend recommendController = new UserRequestRecommend();
        ArrayList<Preview> recipes = recommendController.recommendRecipes(Globals.getUser_username(), 3);
        return recipes;
    }

    public void showItems(ArrayList<Preview> recipes, View v) {
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.RecommendRecipeLayout);
        layout.removeAllViews();
        for (Preview recipePreview : recipes) {
            RelativeLayout p = this.createRecipePreview(recipePreview);
            layout.addView(p);
        }
    }

    public TextView createRecipeName(Preview recipePreview, int height) {
        TextView text = new TextView(getContext());
        text.setGravity(Gravity.CENTER);
        text.setTextColor(getResources().getColor(android.R.color.black));
        text.setPadding(40, 40 + height, 40, 0);
        text.setTextSize(26);
        text.setGravity(Gravity.CENTER);
        text.setTextColor(Color.rgb(22, 83, 126));
        text.setTypeface(null, Typeface.BOLD);
        String recipeName = recipePreview.getName();
        text.setText(recipeName);
        text.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        text.setClickable(true);
        int id = recipePreview.getID();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getContext();
                Globals.setViewRecipeId(id);
                Intent intent = new Intent(context, RecommendRecipeItemActivity.class);
                startActivity(intent);
            }
        });
        return text;
    }

    public TextView createRecipeDetail(Preview recipePreview, int height) {
        TextView text = new TextView(getContext());
        text.setGravity(Gravity.CENTER);
        text.setTextColor(getResources().getColor(android.R.color.black));
        text.setPadding(100, 200 + height, 40, 40);
        text.setTextSize(20);
        text.setGravity(Gravity.LEFT);
        text.setTextColor(Color.rgb(22, 83, 126));
        String recipeDescription = recipePreview.getDescription();
        text.setText(recipeDescription);
        text.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        text.setClickable(true);
        int id = recipePreview.getID();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getContext();
                Globals.setViewRecipeId(id);
                Intent intent = new Intent(context, RecommendRecipeItemActivity.class);
                startActivity(intent);
            }
        });
        return text;
    }

    public ImageView createRecipeImage(Preview recipePreview) {
        ImageView text = new ImageView(getContext());
        int id = recipePreview.getID();
        String imgName = "img_" + String.valueOf(id);
        text.setImageResource(getResources().getIdentifier(imgName, "drawable", getContext().getPackageName()));
        text.setPadding(10, 20, 0, 0);
        text.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        text.setClickable(true);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getContext();
                Globals.setViewRecipeId(id);
                Intent intent = new Intent(context, RecommendRecipeItemActivity.class);
                startActivity(intent);
            }
        });
        return text;
    }

    public int getImageHeight(Preview recipePreview) {
        ImageView text = new ImageView(getContext());
        text.setAdjustViewBounds(true);
        int id = recipePreview.getID();
        String imgName = "img_" + String.valueOf(id);
        text.setImageResource(getResources().getIdentifier(imgName, "drawable", getContext().getPackageName()));
        text.setPadding(10, 20, 0, 0);
        text.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        int height = text.getDrawable().getIntrinsicHeight();
        return height;
    }

    public RelativeLayout createRecipePreview(Preview recipe) {
        RelativeLayout preview = new RelativeLayout(getContext());
        preview.addView(this.createRecipeImage(recipe));
        int height = this.getImageHeight(recipe);
        preview.addView(this.createRecipeName(recipe, height));
        preview.addView(this.createRecipeDetail(recipe, height));
        return preview;
    }
}
