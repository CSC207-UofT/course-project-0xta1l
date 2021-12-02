package com.example.myfirstapp.main.Controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.GenreViewSort;
import com.example.myfirstapp.main.UseCases.GetRecipe;

import java.util.ArrayList;

/**
 * This controller is responsible for coordinating the display of a list of genres, recipes or saved recipes.
 * */

public class UserRequestBrowse {

    /**
     * Generates the required list of Strings by utilizing the UseCase GenreViewSort
     * @param username is the username of a given User
     * @return a list of strings representing genres
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public ArrayList<String> browseGenres(String username){
        User user = Constants.USERSECURITY.getUsernames().get(username);
        GenreViewSort g = new GenreViewSort();
        return g.genresViewList(user);
    }

    /**
     * Generates the required list of Recipe previews
     * @param username is the username of a given User
     * @return a list of lists of RecipePreviews
     */
    public ArrayList<Preview> browseSavedRecipes(String username){
        GetRecipe getRecipe = new GetRecipe();
        return getRecipe.getUserSavedRecipes(username);
    }
    public ArrayList<Preview> browseGenreRecipes(String genre){
        GetRecipe g = new GetRecipe();
        return g.getGenreRecipes(genre);
    }
}

