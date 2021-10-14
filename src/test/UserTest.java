
import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;


public class UserTest {
    Recipe recipe = new Recipe();
    User user = new User();
    @Before
    public void setUp() throws Exception {

        recipe.setGenre("Jamaican");
        recipe.setID(50);
        recipe.setIngredients("water flour sugar");
        recipe.setRating(5);
        recipe.setName("Oxtail Stew");
        recipe.setInstructions("just cook");
        user.setAge(20);
        user.setUsername("Amir");
        user.setBiography("boy from BimTown");
        user.setPassword("password");
        user.setDisplayName("MirSki");
        user.addSavedRecipes(recipe);

    }

    @Test(timeout = 50)
    public void TestgetUserSavedRecipes() {
        ArrayList<Recipe> lst = new ArrayList<>();
        lst.add(recipe);
        assertEquals(lst.get(0), user.getUserSavedRecipes().get(0));

    }
}
