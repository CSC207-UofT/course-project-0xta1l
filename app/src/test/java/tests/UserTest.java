package tests;

import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserInfo;
import com.example.myfirstapp.main.Gateways.Constants;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

import android.provider.ContactsContract;


public class UserTest {
    ArrayList<String> genre = new ArrayList<>(Arrays.asList("Jamaican", "Meals"));
    Recipe recipe = new Recipe("just cook", "water flour sugar", genre, "Oxtail Stew", 5, 50, "img", "description", 5);
    User user = new User();
    ArrayList<String> interests = new ArrayList<>();

    @Before
    public void setUp() {
        Constants.GENRELIBRARY.addRecipes("All", recipe);
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
        assertEquals(lst.get(0), user.getSavedRecipes().get(0));
    }

    @Test(timeout = 50)
    public void TestgetUserGetProfile() {
        ArrayList<String> interestlist = new ArrayList<>();
        UserInfo profileTest = new UserInfo("Amir", "password", "MirSki", 20, "boy from BimTown", interestlist);
        assertEquals(profileTest.getAge(), user.getProfile().getAge());
        assertEquals(profileTest.getBiography(), user.getProfile().getBiography());
        assertEquals(profileTest.getDisplayName(), user.getProfile().getDisplayName());
        assertEquals(profileTest.getUsername(), user.getProfile().getUsername());
        assertEquals(profileTest.getInterests(), user.getProfile().getInterests());
        assertEquals(profileTest.getPassword(), user.getProfile().getPassword());
    }

    @Test(timeout = 50)
    public void TestUserGenreWeights() {
        HashMap<String, Double> weights = new HashMap<>();
        weights.put("Jamaican", 0.05);
        weights.put("Meals", 0.05);
        assertEquals(weights, user.getGenreWeights());
    }
}