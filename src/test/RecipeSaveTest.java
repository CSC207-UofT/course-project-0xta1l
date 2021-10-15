import Constants.Constants;
import Entities.Recipe;
import Entities.User;
import UseCases.RecipeSave;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecipeSaveTest {
    Recipe recipe = Constants.GENRELIBRARY.getRecipeByID("Mexican", 1);
    User user = Constants.USERSECURITY.getUsernames().get("username1");
    RecipeSave recipeSave = new RecipeSave();

    @Test(timeout = 50)
    public void TestRecipeSave() throws Exception {
        boolean bool = recipeSave.saveToUser("username1", 1, "Mexican");
        assertEquals(true, bool);
        }
    }