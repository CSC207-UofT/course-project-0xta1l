package tests;

import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;
import com.example.myfirstapp.main.UseCases.RecommendRecipe;

import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecommendRecipeTest {

    RecommendRecipe r = new RecommendRecipe();
    ArrayList<String> userInterests = new ArrayList<>();
    ArrayList<String> actualRecommends = new ArrayList<>();
    ArrayList<String> genrelist = new ArrayList<>();
    User user1 = new User("user1", "password", "jim", 29, "bio", userInterests, genrelist);
    UserSecurity us = Constants.createUsers();
    ArrayList<String> interests = new ArrayList<>();
    GenreLibrary genrelibrary = Constants.createDataset();

    @Before
    public void setUp() {
        us.addUser(user1);
        interests.add("Western");
        user1.initializeGenreWeights(interests, genrelibrary.getAllGenres());
        user1.updateGenreWeightsTest1("Canadian");
        user1.updateGenreWeightsTest2("Egyptian");
        user1.updateGenreWeightsTest5("Mexican");
        user1.updateGenreWeightsTest3("Chinese");

        genrelist.add("Canadian");
        genrelist.add("Egyptian");
        genrelist.add("Mexican");
        genrelist.add("Chinese");
        genrelist.add("Western");

    }

    @Test(timeout = 50)
    public void Test3Recommends() {
        ArrayList<String> expectedRecommends  = new ArrayList<>(Arrays.asList("Good Steak","French Fries", "Burnt Food"));
        ArrayList<Preview> returnedList = r.recommend(user1, 3, genrelibrary);
        for (Preview preview : returnedList){
            actualRecommends.add(preview.getName());
        }
        assertEquals(expectedRecommends, actualRecommends);
    }

    @Test(timeout = 50)
    public void Test5Recommends() {
        ArrayList<String> expectedRecommends  = new ArrayList<>(Arrays.asList("Good Steak","French Fries",
                "Burnt Food","Chicken","Random Veggies","Pancakes"));
        ArrayList<Preview> returnedList = r.recommend(user1, 6, genrelibrary);
        for (Preview preview : returnedList){
            actualRecommends.add(preview.getName());
        }
        assertEquals(expectedRecommends, actualRecommends);
    }

    @Test(timeout = 50)
    public void Test1Recommends() {
        List<String> strings = new ArrayList<>();
        strings.add("Good Steak");
        ArrayList<String> expectedRecommends  = new ArrayList<>(strings);
        ArrayList<Preview> returnedList = r.recommend(user1, 1, genrelibrary);
        for (Preview preview : returnedList){
            actualRecommends.add(preview.getName());
        }
        assertEquals(expectedRecommends, actualRecommends);
    }
}
