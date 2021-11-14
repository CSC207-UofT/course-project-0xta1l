package Controllers;

import Entities.Preview;
import Entities.User;
import UseCases.FilterRecipes;

import java.util.ArrayList;

public class UserRequestFilter {

    //filter method
    public ArrayList<Preview> filter(ArrayList<Preview> recipes, String filterkey) throws Exception {
        FilterRecipes f = new FilterRecipes(recipes, filterkey);
        return f.filterRecipes();
        }
    }

