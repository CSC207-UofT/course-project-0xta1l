package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.Review;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.UseCases.GetReview;
import com.example.myfirstapp.main.UseCases.RecipeSave;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class GetReviewTest {
    ArrayList<String> genre = new ArrayList<>(Arrays.asList("Jamaican", "Meals"));
    Recipe recipe = new Recipe("just cook", "water flour sugar", genre, "Oxtail Stew", 5, 50, "img", "description", 5);
    User user = new User();
    @Before
    public void setUp() {
        GenreLibrary genreLibrary = new GenreLibrary();
        genreLibrary.addRecipes("All", recipe);
        user.setAge(20);
        user.setUsername("Amir");
        user.setBiography("boy from BimTown");
        user.setPassword("password");
        user.setDisplayName("MirSki");
        user.addSavedRecipes(recipe);
        user.addInterests("German");
        ArrayList<String> interests = new ArrayList<>();
        interests.add("dessert");
        interests.add("chinese");
        Review review1 = new Review(10,1, user.getUsername(),
                "Yum yum in tum tum",3);

        user.addSavedReviews(10, review1);
    }
    GetReview getReview = new GetReview();


    @Test(timeout = 50)
    public void TestgetRecipeReviews() throws Exception {
        ArrayList<ArrayList<Object>> reviews = getReview.getUserReviews(user.getUsername());
        assertTrue(reviews.get(0).equals(user.getUserReviews().get(10)));
    }

}
