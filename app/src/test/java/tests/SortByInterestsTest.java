package tests;

import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.SortByInterests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SortByInterestsTest {

    User user = new User();
    ArrayList<String> interests = new ArrayList<>();

    ArrayList<String> genre1 = new ArrayList<>(Arrays.asList("Jamaican", "Meals"));
    Recipe recipe1 = new Recipe("just cook", "water flour sugar", genre1, "Oxtail Stew", 5, 50, "img", "description",5);
    ArrayList<String> genre2 = new ArrayList<>(Arrays.asList("Japanese", "Meals"));
    Recipe recipe2 = new Recipe("just cook", "water tofu", genre2, "Tea Egg", 4, 50, "img", "description",10);
    ArrayList<String> genre3 = new ArrayList<>(Arrays.asList("Chinese", "Meals"));
    Recipe recipe3 = new Recipe("just cook", "tea egg", genre3, "Miso", 4, 50, "img", "description",15);

    ArrayList<Preview> recipes = new ArrayList<>();
    ArrayList<Preview> sorted_lst = new ArrayList<>();

    @Before
    public void setUp() {

        user.setAge(19);
        user.setUsername("Jo");
        user.setBiography("likes food");
        user.setPassword("123");
        user.setDisplayName("Jo");
        interests.add("Chinese");
        interests.add("Japanese");
        user.setInterests(interests);

        recipes.add(recipe1.getPreview());
        recipes.add(recipe2.getPreview());
        recipes.add(recipe3.getPreview());
        SortByInterests s = new SortByInterests(recipes, user);
        sorted_lst = s.sort();
    }

    @Test(timeout = 50)
    public void Testsort() {
        ArrayList<Preview> actual_recipes = new ArrayList<>();
        actual_recipes.add(recipe3.getPreview());
        actual_recipes.add(recipe2.getPreview());
        actual_recipes.add(recipe1.getPreview());
        assertEquals(actual_recipes, sorted_lst);
    }

}