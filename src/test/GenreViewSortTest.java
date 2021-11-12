import Entities.GenreLibrary;
import Entities.Preview;
import Entities.Recipe;
import Entities.User;
import UseCases.GenreViewSort;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
// TODO: figure out why this works
public class GenreViewSortTest {
    GenreLibrary dataset = new GenreLibrary();
    User user = new User();
    ArrayList<String> r1genre = new ArrayList<>(Arrays.asList("Mexican", "Meals"));
    ArrayList<String> r2genre = new ArrayList<>(Arrays.asList("Chinese", "Meals"));
    ArrayList<String> r3genre = new ArrayList<>(Arrays.asList("Western", "Drinks"));
    ArrayList<String> r4genre = new ArrayList<>(Arrays.asList("Chinese", "Meals", "Western"));

    Recipe recipe1 = new Recipe("Set on Fire", "Salt",
            r1genre, "Burnt Food", 3, 1, "burnt.jpg", "",5);

    Recipe recipe2 = new Recipe("Throw in Oven", "Chicken",
            r2genre, "Chicken", 4, 2, "chicken.jpg", "",10);

    Recipe recipe3 = new Recipe("Pan fry in pan", "Steak, butter",
            r3genre, "Good Steak", 5, 3, "steak.jpg", "",25);

    Recipe recipe4 = new Recipe("Pan fry in pan", "Lobster, garlic",
            r4genre, "Garlic Lobster", 5, 3, "lobster.jpg", "",20);

    ArrayList<Preview> recipelist = new ArrayList<>();
    @Before
    public void setUp() {

        for (String g: recipe1.getGenre()){
            dataset.addRecipes(g, recipe1);
        }
        for (String g: recipe2.getGenre()){
            dataset.addRecipes(g, recipe2);
        }
        for (String g: recipe2.getGenre()){
            dataset.addRecipes(g, recipe3);
        }
        for (String g: recipe4.getGenre()){
            dataset.addRecipes(g, recipe4);
        }
        /*dataset.addRecipes(recipe1.getGenre(), recipe1);
        dataset.addRecipes(recipe2.getGenre(), recipe2);
        dataset.addRecipes(recipe3.getGenre(), recipe3);*/
        user.addInterests("Western");

    }

    @Test(timeout = 50)
    public void TestGenresViewList() {
        GenreViewSort genreViewSort = new GenreViewSort();
        ArrayList<String> viewlist = genreViewSort.genresViewList(user);
        ArrayList<String> genrelist = new ArrayList<>();

        genrelist.add("Western");
        genrelist.add("All");
        genrelist.add("Canadian");
        genrelist.add("Chinese");
        genrelist.add("Egyptian");
        genrelist.add("Mexican");
        assertEquals(viewlist, genrelist);
    }
    }


