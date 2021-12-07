package tests;

import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.UseCases.FilterRecipes;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FilterRecipesTest {

    ArrayList<String> genre1 = new ArrayList<>(Arrays.asList("Jamaican", "Meals"));
    Recipe recipe1 = new Recipe("just cook", "water flour sugar", genre1, "Oxtail Stew", 5, 50, "img", "description",5);
    ArrayList<String> genre2 = new ArrayList<>(Arrays.asList("Japanese", "Meals"));
    Recipe recipe2 = new Recipe("just cook", "water tofu", genre2, "Miso Soup", 4, 50, "img", "description",10);
    ArrayList<String> genre3 = new ArrayList<>(Arrays.asList("Japanese", "Meals"));
    Recipe recipe3 = new Recipe("just cook", "tea egg", genre3, "Tea Egg", 2, 50, "img", "description",15);

    ArrayList<Preview> recipes = new ArrayList<>();
    ArrayList<Preview> filtered_lst = new ArrayList<>();

    @Before
    public void setUp() {
        recipes.add(recipe1.getPreview());
        recipes.add(recipe2.getPreview());
        recipes.add(recipe3.getPreview());
        FilterRecipes f = new FilterRecipes(recipes, "Japanese");
        filtered_lst = f.filterRecipes();
    }

    @Test(timeout=50)
    public void TestfilterRecipes() {
        ArrayList<Preview> actual_recipes = new ArrayList<>();
        actual_recipes.add(recipe2.getPreview());
        actual_recipes.add(recipe3.getPreview());
        assertEquals(actual_recipes, filtered_lst);
    }
}
