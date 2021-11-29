package test;

import static org.junit.Assert.assertEquals;

import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.GenreViewSort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GenreViewSortTest {

    ArrayList<String> userInterests = new ArrayList();
    ArrayList<String> test = new ArrayList<>();
    GenreViewSort g = new GenreViewSort();

    @Before
    public void setUp() {
        userInterests.add("Western");
        test.add("All");
        test.add("Western");
        test.add("Canadian");
        test.add("Chinese");
        test.add("Egyptian");
        test.add("Mexican");
    }

    @Test(timeout = 50)
    public void TestGenreReviewSort() {
        User user = new User("user1", "password", "jim", 29, "bio", userInterests);
        ArrayList<String> genrelist = g.genresViewList(user);
        assertEquals(test, genrelist);
        }
    }
