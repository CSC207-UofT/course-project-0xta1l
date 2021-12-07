package tests;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import com.example.myfirstapp.main.Entities.*;

import static org.junit.Assert.assertEquals;

public class GenreLibraryTest {
    GenreLibrary genreLibrary = new GenreLibrary();
    ArrayList<String> recipeGenres = new ArrayList<>(Arrays.asList("Western", "Desserts"));

    Recipe recipe = new Recipe("Boil ", "water",
            recipeGenres, "Stew", 5, 50, "img", "",30);

    @Before
    public void setUp() {
        genreLibrary.addRecipes("Western", recipe);}

    @Test(timeout = 50)
    public void TestGenreLibraryAddRecipes() {
        HashMap<Integer, Recipe> recipe_map = new HashMap<>();
        recipe_map.put(recipe.getID(), recipe);
        HashMap<String, HashMap<Integer, Recipe>> genremap = new HashMap<>();
        genremap.put(recipe.getGenre().get(1), recipe_map);
        System.out.println(genremap.get("Western"));
        System.out.println(genreLibrary.getAllRecipes("Western"));
        assertEquals(genremap.get("Western"), genreLibrary.getAllRecipes("Western"));
    }
}
