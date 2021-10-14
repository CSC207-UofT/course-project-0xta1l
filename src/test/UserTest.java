
import Entities.Recipe;
import Entities.User;
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
        user.addInterests("German");
    }

    @Test(timeout = 50)
    public void TestgetUserSavedRecipes() {
        ArrayList<Recipe> lst = new ArrayList<>();
        lst.add(recipe);
        assertEquals(lst.get(0), user.getUserSavedRecipes().get(0));
    }

    @Test(timeout = 50)
    public void TestgetUserGetProfile() {
        ArrayList<Object> profile = new ArrayList<>();
        profile.add("MirSki");
        profile.add("Amir");
        ArrayList<String> interests = new ArrayList<>();
        interests.add("German");
        profile.add(interests);
        profile.add("boy from BimTown");
        profile.add(20);
        assertEquals(profile, user.getProfile());
    }
}
