package com.example.myfirstapp.myRecipeActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Controllers.UserRequestBrowse;
import com.example.myfirstapp.main.Controllers.UserRequestFilter;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyRecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyRecipeFragment extends Fragment {


    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public MyRecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyRecipeFragment.
     */

    public static MyRecipeFragment newInstance(String param1, String param2) {
        MyRecipeFragment fragment = new MyRecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_recipe, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        //TODO Add a global saved spinner state where the default is "ALl"

        UserRequestBrowse genreController = new UserRequestBrowse();
        ArrayList<String> genres = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            genres = genreController.browseGenres(Globals.getUser_username());
        }
        String[] genreList = new String[genres.size()];
        genreList = genres.toArray(genreList); // List of genre (strings)
        System.out.println("Genre list is: " + genreList);

        Spinner spinner = (Spinner) getView().findViewById(R.id.myRecipeSortSpinner);
        ArrayAdapter adapter = new ArrayAdapter(this.getContext(), android.R.layout.simple_spinner_item, genreList);
        spinner.setAdapter(adapter);

        User user = Constants.USERSECURITY.getUserByID(Globals.getUser_username());
        ArrayList<Recipe> recipes = user.getSavedRecipes();

        MyRecipeFragment that = this;
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Preview> previews = new ArrayList<Preview>();
                for (Recipe recipe : recipes) {
                    previews.add(recipe.getPreview());
                }
                String item = (String) parent.getItemAtPosition(position);
                UserRequestFilter filterController = new UserRequestFilter();
                that.showItems(filterController.filter(previews, item), getView());
                Spinner spinner = (Spinner) getView().findViewById(R.id.myRecipeSortSpinner);
                spinner.setOnItemSelectedListener(this);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void showItems(ArrayList<Preview> recipes, View v) {
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.MyRecipeLayout);
        layout.removeAllViews();
        for (int i = 0; i < recipes.size(); i++) {
            TextView text = new TextView(getContext());
            text.setGravity(Gravity.CENTER);
            text.setTextColor(getResources().getColor(android.R.color.black));
            text.setPadding(100, 60, 0, 0);
            text.setTextSize(24);
            text.setGravity(Gravity.LEFT);
            Preview recipe = recipes.get(i);
            String recipeName = recipe.getName();
            text.setText(recipeName);
            text.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
            text.setClickable(true);
            int recipeID = recipe.getID();
            text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = getContext();
                    Globals.setViewRecipeId(recipeID);
                    Intent intent = new Intent(context, RecipeItemActivity.class);
                    startActivity(intent);
                }
            });
            layout.addView(text);
        }
    }
}