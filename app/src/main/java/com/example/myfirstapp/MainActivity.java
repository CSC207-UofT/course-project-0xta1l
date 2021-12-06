package com.example.myfirstapp;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myfirstapp.genreActivity.GenresFragment;
import com.example.myfirstapp.homeActivity.HomeFragment;
import com.example.myfirstapp.myRecipeActivity.MyRecipeFragment;
import com.example.myfirstapp.accountActivity.ProfileFragment;
import com.example.myfirstapp.fragments.UploadFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    /**
     * The main activity that stores the fragments:
     * HomeFragment()
     * GenresFragment()
     * UploadFragment()
     * MyRecipeFragment()
     * ProfileFragment()
     */

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    public String currentView = "Home";

    private HomeFragment homeFragment;
    private GenresFragment genresFragment;
    private UploadFragment uploadFragment;
    private MyRecipeFragment myRecipeFragment;
    private ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.homeFragment = new HomeFragment();
        this.genresFragment = new GenresFragment();
        this.uploadFragment = new UploadFragment();
        this.myRecipeFragment = new MyRecipeFragment();
        this.profileFragment = new ProfileFragment();


        this.initFragment(Globals.getCurrentActivity());

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
                Globals.setCurrentActivity(i);
                this.makeCurrentFragment(this.homeFragment);
                return true;
            case R.id.menu_search:
                this.currentView = "Genres";
                Globals.setCurrentActivity(i);
                this.makeCurrentFragment(this.genresFragment);
                return true;
            case R.id.menu_upload:
                this.currentView = "Upload";
                Globals.setCurrentActivity(i);
                this.makeCurrentFragment(this.uploadFragment);
                return true;
            case R.id.menu_recipes:
                this.currentView = "My Recipes";
                Globals.setCurrentActivity(i);
                this.makeCurrentFragment(this.myRecipeFragment);
                return true;
            case R.id.menu_account:
                this.currentView = "My Account";
                Globals.setCurrentActivity(i);
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
    }
}

