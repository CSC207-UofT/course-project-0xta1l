
import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;


public class UserTest {
    // TODO Change this file name and add testing methods for our use cases/controllers. This test is failing btw idk why
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
        Recipe recipe1= new Recipe();
        recipe1.setGenre("Jamaican");
        recipe1.setID(50);
        recipe1.setIngredients("water flour sugar");
        recipe1.setRating(5);
        recipe1.setName("Oxtail Stew");
        recipe1.setInstructions("just cook");
        lst.add(recipe1);
        assertEquals(lst, user.getUserSavedRecipes());

    }
}
