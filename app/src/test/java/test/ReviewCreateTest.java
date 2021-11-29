package test;

import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;
import com.example.myfirstapp.main.UseCases.RecipeCreate;
import com.example.myfirstapp.main.UseCases.RecipeReviewAdd;
import com.example.myfirstapp.main.UseCases.UserCreate;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ReviewCreateTest {
    RecipeCreate recipeCreate = new RecipeCreate();
    UserCreate create = new UserCreate();
    RecipeReviewAdd reviewCreate = new RecipeReviewAdd();
    int id;

    @Before
    public void setUp() {
        ArrayList<String> interests = new ArrayList<>();
        interests.add("Western");
        ArrayList<String> genres = new ArrayList<>();
        interests.add("Western");
        interests.add("Meal");
        create.userCreate("testUser", "123",
                "Jo", 19,"hi", interests);
        id = recipeCreate.CreateRecipeFromUser("testUser", "just cook", "water flour sugar", genres, "Hi Stew", 5, "no.png", "description", 5);
    }

    @Test(timeout = 50)
    public void TestReviewCreateAdded() {
        Recipe testRecipe = Constants.GENRELIBRARY.getRecipeByID("All", id);
        User testUser = Constants.USERSECURITY.getUserByID("testUser");
        System.out.println(testRecipe.getRating());

        reviewCreate.addReview("testUser", id, "Test Comment", 1);
        System.out.println(testRecipe.getRating());

        assertNotNull(testUser.getUserReviews().get(id));
        assertNotNull(testRecipe.getRecipeReviews().get("testUser"));
        assertEquals(testRecipe.getRating(), 3);
    }

}
