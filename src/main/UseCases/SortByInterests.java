package UseCases;

import Entities.Recipe;
import Entities.User;

import java.util.ArrayList;

public class SortByInterests extends SortRecipes {

    User user;

    public SortByInterests(ArrayList<Recipe> previews, User user) {
        super(previews);
        this.user = user;
    }

    @Override
    public ArrayList<Recipe> sort() {
        ArrayList<Recipe> lst = alphabet();
        return sortByInterests(lst);
    }

    public ArrayList<Recipe> sortByInterests(ArrayList<Recipe> lst) {
        ArrayList<Recipe> sorted_lst = new ArrayList<Recipe>();
        ArrayList<Recipe> recipes = new ArrayList<Recipe>(lst);
        ArrayList<String> user_interests = user.getInterests();

        for (Recipe recipe : recipes) {
            for (String genre : recipe.getGenre()) {
                if (user_interests.contains(genre) && !(sorted_lst.contains(recipe))) {
                    sorted_lst.add(recipe);
                    recipes.remove(recipe);
                }
            }
        }
        sorted_lst.addAll(recipes);
        return sorted_lst;
    }
}
