package UseCases;

import Entities.Preview;
import Entities.Recipe;
import Entities.User;
import Constants.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GetRecipe {
    public HashMap<Integer, Preview> getUserSavedRecipes(User user) {
        ArrayList<Recipe> userRecipeList = user.getSavedRecipes();

        HashMap<Integer, Preview> recipeMap = new HashMap<>();

        for (Recipe recipe: userRecipeList) {
            Recipe variable = Constants.GENRELIBRARY.getRecipeByID("All", recipe.getID());
            recipeMap.put(variable.getID(), variable.getPreview());
        }

        return recipeMap;
    }

    public Preview getSingleRecipe (int recipeID, String fullOrPreview) throws Exception {
        ArrayList<String> validOptionsFull = new ArrayList<>();
        validOptionsFull.add("Full");
        validOptionsFull.add("full");
        validOptionsFull.add("f");
        validOptionsFull.add("F");

        ArrayList<String> validOptionsPreview = new ArrayList<>();
        validOptionsPreview.add("Preview");
        validOptionsPreview.add("preview");
        validOptionsPreview.add("prev");
        validOptionsPreview.add("p");
        validOptionsPreview.add("P");

        Preview recipeProperties = new Preview();

        if (!validOptionsPreview.contains(fullOrPreview)
                && !validOptionsFull.contains(fullOrPreview)) {
            throw new Exception("not a valid option");
        } else if (validOptionsPreview.contains(fullOrPreview)) {
            recipeProperties = Constants.GENRELIBRARY.getRecipeByID("All", recipeID).getPreview();
        } else if (validOptionsFull.contains(fullOrPreview)) {
            recipeProperties = Constants.GENRELIBRARY.getRecipeByID("All", recipeID).getFull();
        }

        return recipeProperties;


    }

    public ArrayList<Preview> getGenreRecipes (String genreName) {

        HashMap<Integer, Recipe> genre;

        genre = Constants.GENRELIBRARY.getAllRecipes(genreName);

        ArrayList<Preview> previewList = new ArrayList<>();
        for (Recipe recipe : genre.values()) {
            previewList.add(recipe.getPreview());
        }
        return previewList;
    }

    // TODO: ADD TEST CASE
}