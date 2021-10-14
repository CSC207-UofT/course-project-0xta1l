import org.junit.*;
import java.util.HashMap;

import static org.junit.Assert.*;

public class GenreLibraryTest {
    GenreLibrary genreLibrary = new GenreLibrary();
    Recipe recipe = new Recipe("Boil ", "water",
            "Western", "Stew", 5, 50, "img");

    @Before
    public void setUp() throws Exception {
        genreLibrary.addRecipes("Western", recipe);

    }
    @Test(timeout = 50)
    public void TestGenreLibraryAddRecipes() {
        HashMap<Integer, Recipe> recipe_map = new HashMap<>();
        recipe_map.put(recipe.getID(), recipe);
        HashMap<String, HashMap<Integer, Recipe>> genremap = new HashMap<>();
        genremap.put(recipe.getGenre(), recipe_map);

        assertEquals(genremap.get("Western"), genreLibrary.getAllRecipes("Western"));
    }
}
