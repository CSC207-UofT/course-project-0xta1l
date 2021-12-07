package tests;

import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.RecipeSave;
import org.junit.*;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.os.Build;

public class RecipeSaveTest {
    Recipe recipe = Constants.GENRELIBRARY.getRecipeByID("Mexican", 1);
    User user = Constants.USERSECURITY.getUsernames().get("username1");
    RecipeSave recipeSave = new RecipeSave();

    @Test(timeout = 50)
    public void TestRecipeSave() throws Exception {
        boolean bool = recipeSave.saveToUser(user, recipe);
        assertTrue(bool);
    }

    @Test(timeout = 50)
    public void TestRecipeSaveWeight() {
        HashMap<String, Double> genreWeights = user.getGenreWeights();
        Double weight = genreWeights.get("Mexican");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            assertEquals(Optional.ofNullable(weight), Optional.of(0.05));
        }
    }

}