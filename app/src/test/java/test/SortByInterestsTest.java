//import Constants.Constants;
//import Entities.Preview;
//import Entities.Recipe;
//import Entities.User;
//import UseCases.SortByInterests;
//import UseCases.SortRecipes;
//import UseCases.UserCreate;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static org.junit.Assert.assertEquals;
//
//public class SortByInterestsTest {
//
//    ArrayList<String> genre1 = new ArrayList<>(Arrays.asList("Jamaican", "Meals"));
//    Recipe recipe1 = new Recipe("just cook", "water flour sugar", genre1, "Oxtail Stew", 5, 50, "img", "description",5);
//    ArrayList<String> genre2 = new ArrayList<>(Arrays.asList("Japanese", "Meals"));
//    Recipe recipe2 = new Recipe("just cook", "water tofu", genre2, "Miso Soup", 4, 50, "img", "description",10);
//    ArrayList<String> genre3 = new ArrayList<>(Arrays.asList("Mexican", "Meals"));
//    Recipe recipe3 = new Recipe("just cook", "tea egg", genre3, "Tea Egg", 2, 50, "img", "description",15);
//
//    ArrayList<Preview> recipes = new ArrayList<>();
//    ArrayList<Preview> sorted_lst = new ArrayList<>();
//
//    @Before
//    public void setUp() {
//        recipes.add(recipe1.getPreview());
//        recipes.add(recipe3.getPreview());
//        recipes.add(recipe2.getPreview());
//        SortByInterests s = new SortByInterests(recipes, );
//        sorted_lst = s.sort();
//    }
//
//    @Test(timeout = 50)
//    public void Testsort() {
//        ArrayList<Preview> actual_recipes = new ArrayList<>();
//        actual_recipes.add(recipe1.getPreview());
//        actual_recipes.add(recipe2.getPreview());
//        actual_recipes.add(recipe3.getPreview());
//        assertEquals(actual_recipes, sorted_lst);
//    }
//
//}