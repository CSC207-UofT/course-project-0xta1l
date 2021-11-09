//
//import Entities.Recipe;
//import Entities.User;
//import Constants.*;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//
//import static org.junit.Assert.assertEquals;
//
//
//public class UserTest {
//    ArrayList<String> genre = new ArrayList<>(Arrays.asList("Jamaican", "Meals"));
//    Recipe recipe = new Recipe("just cook", "water flour sugar", genre, "Oxtail Stew", 5, 50, "img", "description");
//    User user = new User();
//    @Before
//    public void setUp() {
//        Constants.GENRELIBRARY.addRecipes("All", recipe);
//        user.setAge(20);
//        user.setUsername("Amir");
//        user.setBiography("boy from BimTown");
//        user.setPassword("password");
//        user.setDisplayName("MirSki");
//        user.addSavedRecipes(recipe);
//        user.addInterests("German");
//    }
//
//    @Test(timeout = 50)
//    public void TestgetUserSavedRecipes() {
//        ArrayList<Recipe> lst = new ArrayList<>();
//        lst.add(recipe);
//        assertEquals(lst.get(0), user.getSavedRecipes().get(0));
//    }
//
//    @Test(timeout = 50)
//    public void TestgetUserGetProfile() {
//        ArrayList<Object> profile = new ArrayList<>();
//        profile.add("MirSki");
//        profile.add("Amir");
//        ArrayList<String> interestlist = new ArrayList<>();
//        interestlist.add("German");
//        profile.add(interestlist);
//        profile.add("boy from BimTown");
//        profile.add(20);
//        assertEquals(profile, user.getProfile());
//    }
//
//    @Test(timeout = 50)
//    public void TestUserGenreWeights() {
//        HashMap<String, Double> weights = new HashMap<>();
//        weights.put("German", 0.85);
//        weights.put("Jamaican", 0.05);
//        weights.put("Meals", 0.05);
//        assertEquals(weights, user.getGenreWeights());
//    }
//}
