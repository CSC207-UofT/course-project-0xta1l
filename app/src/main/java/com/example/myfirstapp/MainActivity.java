package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myfirstapp.fragments.GenresFragment;
import com.example.myfirstapp.fragments.HomeFragment;
import com.example.myfirstapp.fragments.MyRecipeFragment;
import com.example.myfirstapp.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private int currentActivity = 0;

    private Button mLoadFragmentOne;
    private Button mLoadFragmentTwo;

    public String currentView = "Home";


    private HomeFragment homeFragment = new HomeFragment();
    private GenresFragment genresFragment = new GenresFragment();
    private MyRecipeFragment myRecipeFragment = new MyRecipeFragment();
    private ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.currentActivity = Globals.getCurrentActivity();

        this.initFragment(this.getCurrentActivity());

        BottomNavigationView bottom_navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                return initFragment(menuItem.getItemId());
            }
        });
    }
    public boolean initFragment(int i) {
        switch (i) {
            case R.id.menu_home:
                this.currentView = "Home";
                this.setCurrentActivity(i);
                this.makeCurrentFragment(this.homeFragment);
                return true;
            case R.id.menu_search:
                this.currentView = "Genres";
                this.setCurrentActivity(i);
                this.makeCurrentFragment(this.genresFragment);
                return true;
            case R.id.menu_recipes:
                this.currentView = "My Recipes";
                this.setCurrentActivity(i);
                this.makeCurrentFragment(this.myRecipeFragment);
                return true;
            case R.id.menu_account:
                this.currentView = "My Account";
                this.setCurrentActivity(i);
                this.makeCurrentFragment(this.profileFragment);
                return true;
            default:
                return false;
        }
    }
    private void makeCurrentFragment(Fragment fragment) {
        setTitle(currentView);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction
                .replace(R.id.fl_wrapper, fragment)
                .commit();
        // String s = R.string.current_view;
    }
    public void setCurrentActivity(int i) {
        this.currentActivity = i;
        Globals.setCurrentActivity(i);
    }
    public int getCurrentActivity() {
        return this.currentActivity;
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editTextTextPersonName);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }


    public void homeButton(View view) {
        this.currentActivity = 1;
        this.onViewChange();
    }
    public void recipeButton(View view) {
        this.currentActivity = 2;
        this.onViewChange();
    }
    public void onViewChange() {
        switch(this.currentActivity) {
            case 1:

                break;
            case 2:

                break;
            default:

                break;
        }
    }

}

