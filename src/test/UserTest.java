
import Entities.Recipe;
import Entities.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class UserTest {
    Recipe recipe = new Recipe();
    User user = new User();
    @Before
    public void setUp() {
        ArrayList<String> genre = new ArrayList<>();
        genre.add("Jamaican");
        recipe.setGenre(genre);
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
        assertEquals(lst.get(0), user.getSavedRecipes().get(0));
    }

    @Test(timeout = 50)
    public void TestgetUserGetProfile() {
        ArrayList<Object> profile = new ArrayList<>();
        profile.add("MirSki");
        profile.add("Amir");
        ArrayList<String> interestlist = new ArrayList<>();
        interestlist.add("German");
        profile.add(interestlist);
        profile.add("boy from BimTown");
        profile.add(20);
        assertEquals(profile, user.getProfile());
    }
}
