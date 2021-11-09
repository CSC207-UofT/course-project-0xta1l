package UseCases;

import Entities.Preview;
import Entities.Recipe;
import Entities.User;

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

    public ArrayList<Preview> sortByInterests(ArrayList<Preview> lst) {
        ArrayList<Preview> sorted_lst = new ArrayList<Preview>();
        ArrayList<Preview> recipes = new ArrayList<Preview>(lst);
        ArrayList<String> user_interests = user.getInterests();

        for (Preview recipe : recipes) {
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
