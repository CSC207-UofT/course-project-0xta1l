import Constants.Constants;
import Entities.Recipe;
import UseCases.SortByRating;
import UseCases.SortRecipes;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortRecipesTest {
    ArrayList<String> genre1 = new ArrayList<>(Arrays.asList("Jamaican", "Meals"));
    Recipe recipe1 = new Recipe("just cook", "water flour sugar", genre1, "Oxtail Stew", 5, 50, "img", "description", 5);
    ArrayList<String> genre2 = new ArrayList<>(Arrays.asList("Japanese", "Meals"));
    Recipe recipe2 = new Recipe("just cook", "water tofu", genre2, "Miso Soup", 4, 50, "img", "description", 5);
    ArrayList<String> genre3 = new ArrayList<>(Arrays.asList("Jamaican", "Meals"));
    Recipe recipe3 = new Recipe("just cook", "tea egg", genre3, "Tea Egg", 2, 50, "img", "description", 5);

    ArrayList<Recipe> recipes = new ArrayList<>();
    ArrayList<Recipe> sorted_lst = new ArrayList<>();

    @Before
    public void setUp() {
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        SortRecipes s = new SortRecipes(recipes);
        sorted_lst = s.sort();
    }

    @Test(timeout = 50)
    public void Testsort() {
        ArrayList<Recipe> actual_recipes = new ArrayList<>();
        actual_recipes.add(recipe2);
        actual_recipes.add(recipe1);
        actual_recipes.add(recipe3);
        assertEquals(actual_recipes, sorted_lst);
    }
}

