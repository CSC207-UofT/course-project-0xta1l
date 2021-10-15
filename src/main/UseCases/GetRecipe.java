package UseCases;

import Entities.Recipe;
import Entities.User;
import Constants.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GetRecipe {
    public HashMap<Integer, ArrayList<Object>> getUserSavedRecipes(User user) {
        ArrayList<Recipe> userRecipeList = user.getSavedRecipes();

        HashMap<Integer, ArrayList<Object>> recipeMap = new HashMap<>();

        for (Recipe recipe: userRecipeList) {
            Recipe variable = Constants.GENRELIBRARY.getRecipeByID("All", recipe.getID());
            recipeMap.put(variable.getID(), variable.getPreview());
        }

        return recipeMap;
    }

    public ArrayList<Object> getSingleRecipe (int recipeID, String fullOrPreview) throws Exception {
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

        ArrayList<Object> recipeProperties = new ArrayList<>();

        if (!validOptionsPreview.contains(fullOrPreview)
                && !validOptionsFull.contains(fullOrPreview)) {
            throw new Exception("not a valid option");
        } else if (validOptionsPreview.contains(fullOrPreview)) {
            recipeProperties = Constants.GENRELIBRARY.getRecipeByID("All", recipeID).getFull();
        } else if (validOptionsFull.contains(fullOrPreview)) {
            recipeProperties = Constants.GENRELIBRARY.getRecipeByID("All", recipeID).getFull();
        }

        return recipeProperties;


    }

    public ArrayList<ArrayList<Object>> getGenreRecipes (String genreName) {

        HashMap<Integer, Recipe> genre;

        genre = Constants.GENRELIBRARY.getAllRecipes(genreName);

        ArrayList<ArrayList<Object>> previewList = new ArrayList<>();
        for (Recipe recipe : genre.values()) {
            previewList.add(recipe.getPreview());
        }

        return previewList;
    }
}