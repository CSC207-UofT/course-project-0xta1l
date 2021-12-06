package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.User;

import java.util.ArrayList;

public class SortByInterests extends SortRecipes {

    User user;

    public SortByInterests(ArrayList<Preview> previews, User user) {
        super(previews);
        this.user = user;
    }

    @Override
    public ArrayList<Preview> sort() {
        ArrayList<Preview> lst = alphabet();
        return sortByInterests(lst);
    }

    /**
     * sorts recipes by the interests of the user
     *
     * @param lst list of recipes
     * @return sorted list of recipes
     */
    public ArrayList<Preview> sortByInterests(ArrayList<Preview> lst) {
        ArrayList<Preview> recipes = new ArrayList<>(lst);
        ArrayList<Preview> sorted_lst = new ArrayList<>();
        ArrayList<Preview> other_recipes = new ArrayList<>();
        ArrayList<String> user_interests = user.getInterests();

        for (Preview recipe : recipes) {
            for (String genre : recipe.getGenre()) {
                if (user_interests.contains(genre) && !(sorted_lst.contains(recipe))) {
                    sorted_lst.add(recipe);
                }
            }
        }
        for (Preview recipe : recipes) {
            if (!(sorted_lst.contains(recipe))) {
                other_recipes.add(recipe);
            }
        }
        sorted_lst.addAll(other_recipes);
        return sorted_lst;
    }
}
