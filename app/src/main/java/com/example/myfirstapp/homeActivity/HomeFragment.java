package com.example.myfirstapp.homeActivity;

import android.content.Context;
import android.content.Intent;
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
        ArrayList<Preview> recipes = recommendController.recommendRecipes(Globals.getUser_username(), 2);
        return recipes;
    }

    public void showItems(ArrayList<Preview> recipes, View v) {
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.RecommendRecipeLayout);
        layout.removeAllViews();
        for(Preview recipePreview: recipes) {
            RelativeLayout p = this.createRecipePreview(recipePreview);
            layout.addView(p);
        }
    }
    public TextView createRecipeName(Preview recipePreview, int height) {
        TextView text = new TextView(getContext());
        text.setGravity(Gravity.CENTER);
        text.setTextColor(getResources().getColor(android.R.color.black));
        text.setPadding(40, 40 + height, 40, 0);
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
        text.setPadding(100, 120 + height, 40, 40);
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
        int h = text.getDrawable().getIntrinsicHeight();
        return h;
    }
    public RelativeLayout createRecipePreview(Preview recipe) {
        RelativeLayout p = new RelativeLayout(getContext());
        p.addView(this.createRecipeImage(recipe));
        int height = this.getImageHeight(recipe);
        p.addView(this.createRecipeName(recipe, height));
        p.addView(this.createRecipeDetail(recipe, height));
        return p;
    }
}