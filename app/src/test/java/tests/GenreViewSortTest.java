package tests;

import static org.junit.Assert.assertEquals;

import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.GenreViewSort;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GenreViewSortTest {
    ArrayList<String> userInterests = new ArrayList<>();
    ArrayList<String> genrelist = new ArrayList<>();
    User user = new User("user1", "password", "jim", 29, "bio", userInterests, genrelist);
    ArrayList<String> listgenres = new ArrayList<>();
    GenreViewSort g = new GenreViewSort();
    ArrayList<String> listgenres2 = new ArrayList<>();

    @Before
    public void setUp() {
        userInterests.add("Western");
        listgenres.add("All");
        listgenres.add("Canadian");
        listgenres.add("Chinese");
        listgenres.add("Western");
        listgenres.add("Egyptian");
        listgenres.add("Mexican");

        listgenres2.add("All");
        listgenres2.add("Western");
        listgenres2.add("Canadian");
        listgenres2.add("Chinese");
        listgenres2.add("Egyptian");
        listgenres2.add("Mexican");
    }

    @Test(timeout = 50)
    public void TestgenresViewList() {
        ArrayList<String> sortedlist = g.genresViewList(listgenres, user);
        assertEquals(sortedlist, listgenres2);
        }
    }
