import Entities.Recipe;
import Entities.User;
import Constants.*;
import Entities.UserInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class UserTest {
    ArrayList<String> genre = new ArrayList<>(Arrays.asList("Jamaican", "Meals"));
    Recipe recipe = new Recipe("just cook", "water flour sugar", genre, "Oxtail Stew", 5, 50, "img", "description", 5);
    User user = new User();
    @Before
    public void setUp() {
        Constants.GENRELIBRARY.addRecipes("All", recipe);
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
        ArrayList<String> interestlist = new ArrayList<>();
        interestlist.add("German");
        UserInfo profile = new UserInfo("Amir", "password", "MirSki", 20, "boy from BimTown", interestlist);
        assertEquals(profile.getUsername(), user.getProfile().getUsername());
        assertEquals(profile.getPassword(), user.getProfile().getPassword());
        assertEquals(profile.getDisplayName(), user.getProfile().getDisplayName());
        assertEquals(profile.getAge(), user.getProfile().getAge());
        assertEquals(profile.getBiography(), user.getProfile().getBiography());
        assertEquals(profile.getInterests(), user.getProfile().getInterests());
    }

    @Test(timeout = 50)
    public void TestUserGenreWeights() {
        HashMap<String, Double> weights = new HashMap<>();
        weights.put("German", 0.7);
        weights.put("Jamaican", 0.05);
        weights.put("Meals", 0.05);
        assertEquals(weights, user.getGenreWeights());
    }
}
