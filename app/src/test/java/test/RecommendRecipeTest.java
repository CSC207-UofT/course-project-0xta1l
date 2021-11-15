/*
package com.example.myfirstapp.test;

import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.User;
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


    @Before
    public void setUp() {
        Constants.createDataset();
        userInterests.add("Western");
        User user = new User("user1","password","jim",29, "bio",userInterests);
        Constants.USERSECURITY.addUser(user);
        user.updateGenreWeightsTest1("Canadian");
        user.updateGenreWeightsTest2("Egyptian");
        user.updateGenreWeightsTest5("Mexican");
        user.updateGenreWeightsTest3("Chinese");

    }

    @Test(timeout = 50)
    public void Test3Recommends() {
        ArrayList<String> expectedRecommends  = new ArrayList<>(Arrays.asList("Good Steak","French Fries", "Burnt Food"));
        ArrayList<Preview> returnedList = r.recommend("user1", 3);
        for (Preview preview : returnedList){
            actualRecommends.add(preview.getName());
        }
        assertEquals(expectedRecommends, actualRecommends);
    }

    @Test(timeout = 50)
    public void Test5Recommends() {
        ArrayList<String> expectedRecommends  = new ArrayList<>(Arrays.asList("Good Steak","French Fries",
                "Burnt Food","Chicken","Random Veggies","Pancakes"));
        ArrayList<Preview> returnedList = r.recommend("user1", 6);
        for (Preview preview : returnedList){
            actualRecommends.add(preview.getName());
        }
        assertEquals(expectedRecommends, actualRecommends);
    }

    @Test(timeout = 50)
    public void Test1Recommends() {
        ArrayList<String> expectedRecommends  = new ArrayList<>(List.of("Good Steak"));
        ArrayList<Preview> returnedList = r.recommend("user1", 1);
        for (Preview preview : returnedList){
            actualRecommends.add(preview.getName());
        }
        assertEquals(expectedRecommends, actualRecommends);
    }
}
*/