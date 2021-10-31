import Entities.GenreLibrary;
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
    ArrayList<String> r2genre = new ArrayList<>(Arrays.asList("Chinese", "Desserts"));
    ArrayList<String> r3genre = new ArrayList<>(Arrays.asList("Western", "Drinks"));

    Recipe recipe1 = new Recipe("Set on Fire", "Salt",
            r1genre, "Burnt Food", 3, 1, "burnt.jpg", "");

    Recipe recipe2 = new Recipe("Throw in Oven", "Chicken",
            r2genre, "Chicken", 4, 2, "chicken.jpg", "");

    Recipe recipe3 = new Recipe("Pan fry in pan", "Steak, butter",
            r3genre, "Good Steak", 5, 3, "steak.jpg", "");

    ArrayList<Recipe> recipelist = new ArrayList<>();
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


