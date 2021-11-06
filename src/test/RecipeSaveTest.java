import Constants.Constants;
import Entities.Recipe;
import Entities.User;
import UseCases.RecipeSave;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RecipeSaveTest {
    Recipe recipe = Constants.GENRELIBRARY.getRecipeByID("Mexican", 1);
    User user = Constants.USERSECURITY.getUsernames().get("username1");
    RecipeSave recipeSave = new RecipeSave();

    @Test(timeout = 50)
    public void TestRecipeSave() throws Exception {
        boolean bool = recipeSave.saveToUser("username1", 1, "Mexican");
        assertTrue(bool);
    }

    @Test(timeout = 50)
    public void TestRecipeSaveWeight() throws Exception {
        boolean bool = recipeSave.saveToUser("username1", 1, "Mexican");
        HashMap<String, Double> genreWeights = user.getGenreWeights();
        Double weight = genreWeights.get("Mexican");
        assertEquals(java.util.Optional.ofNullable(weight), java.util.Optional.ofNullable(0.05));
    }

}