package com.example.myfirstapp.main.Controllers;

import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.FilterRecipes;

import java.util.ArrayList;

public class UserRequestFilter {

    //filter method
    public ArrayList<Preview> filter(ArrayList<Preview> recipes, String filterkey) {
        FilterRecipes f = new FilterRecipes(recipes, filterkey);
        return f.filterRecipes();
        }
    }

