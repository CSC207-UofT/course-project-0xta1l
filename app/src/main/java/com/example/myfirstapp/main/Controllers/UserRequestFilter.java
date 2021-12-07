package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.UseCases.FilterRecipes;

import java.util.ArrayList;

public class UserRequestFilter {
    /**
     * User requests to filter recipes
     *
     * @param filterkey is the key you want to filter the data by
     * @param recipes   a list of recipe previews
     * @return a list of recipe previews
     */
    //filter method
    public ArrayList<Preview> filter(ArrayList<Preview> recipes, String filterkey) {
        FilterRecipes filter = new FilterRecipes(recipes, filterkey);
        return filter.filterRecipes();
    }
}

