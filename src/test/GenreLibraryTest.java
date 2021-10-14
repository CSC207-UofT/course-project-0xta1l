
import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;


public class GenreLibraryTest {
    Recipe recipe = new Recipe("Jamaican","water flour sugar","Jamaican",
            "Oxtail Stew", 5, 50,"img" );
    GenreLibrary genreLibrary = new GenreLibrary();

    @Before
    public void setUp() throws Exception {
        genreLibrary.addRecipes("Jamaican", recipe);
    }

    @Test(timeout = 50)
    public void TestgetUserSavedRecipes() {
        HashMap<Integer, Recipe> recipe_map = new HashMap<>();
        recipe_map.put(recipe.getID(), recipe);
        HashMap<String, HashMap<Integer, Recipe>> genre_map = new HashMap<>();
        genre_map.put("Jamaican", recipe_map);

        assertEquals(genre_map.keySet(), genreLibrary.getListOfAllRecipes().keySet());
        assertEquals(genre_map.get("Jamaican"), genreLibrary.getListOfAllRecipes().get("Jamaican"));
    }
}
