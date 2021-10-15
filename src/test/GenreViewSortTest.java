import Entities.GenreLibrary;
import Entities.Recipe;
import Entities.User;
import UseCases.GenreViewSort;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GenreViewSortTest {
    GenreLibrary dataset = new GenreLibrary();

    Recipe recipe1 = new Recipe("Set on Fire", "Salt",
            "Mexican", "Burnt Food", 3, 1, "burnt.jpg");

    Recipe recipe2 = new Recipe("Throw in Oven", "Chicken",
            "Chinese", "Chicken", 4, 2, "chicken.jpg");

    Recipe recipe3 = new Recipe("Pan fry in pan", "Steak, butter",
            "Western", "Good Steak", 5, 3, "steak.jpg");

    User user = new User();
    ArrayList<Recipe> recipelist = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        dataset.addRecipes(recipe1.getGenre(), recipe1);
        dataset.addRecipes(recipe2.getGenre(), recipe2);
        dataset.addRecipes(recipe3.getGenre(), recipe3);
        user.addInterests("Western");

    }

    @Test(timeout = 50)
    public void TestGenresViewList() {
        GenreViewSort genreViewSort = new GenreViewSort();
        ArrayList<String> viewlist = genreViewSort.genresViewList(user, dataset);
        ArrayList<String> genrelist = new ArrayList<>();

        genrelist.add("Western");
        genrelist.add("Chinese");
        genrelist.add("Mexican");
        assertEquals(viewlist, genrelist);
    }
    @Test(timeout = 50)
    public void TestgenreRecipeSort() {
        GenreViewSort genreViewSort = new GenreViewSort();
        recipelist.add(recipe3);
        recipelist.add(recipe2);
        recipelist.add(recipe1);
        ArrayList<Recipe> rlist = genreViewSort.genreRecipeSort(recipelist, "rating");
        assertEquals(recipelist, rlist);
    }

    }


