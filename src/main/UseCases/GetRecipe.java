package UseCases;

import Entities.GenreLibrary;
import Entities.Recipe;
import Entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetRecipe {
    public HashMap<Integer, ArrayList<Object>> getUserSavedRecipes(User user) {
        ArrayList<Recipe> userRecipeList = user.getSavedRecipes();

        GenreLibrary userLibrary = new GenreLibrary();
        HashMap<Integer, ArrayList<Object>> recipeMap = new HashMap<Integer, ArrayList<Object>>();

        for (Recipe recipe: userRecipeList) {
            Recipe variable = userLibrary.getRecipeByID("All", recipe.getID());
            recipeMap.put(variable.getID(), variable.getPreview());
        }

        return recipeMap;
    }

    public ArrayList<Object> getSingleRecipe (int recipeID, String fullOrPreview) throws Exception {
        ArrayList<String> validOptionsFull = new ArrayList<String>();
        validOptionsFull.add("Full");
        validOptionsFull.add("full");
        validOptionsFull.add("f");
        validOptionsFull.add("F");

        ArrayList<String> validOptionsPreview = new ArrayList<String>();
        validOptionsPreview.add("Preview");
        validOptionsPreview.add("preview");
        validOptionsPreview.add("prev");
        validOptionsPreview.add("p");
        validOptionsPreview.add("P");

        GenreLibrary userLibrary = new GenreLibrary();
        ArrayList<Object> recipeProperties = new ArrayList<Object>();

        if (!validOptionsPreview.contains(fullOrPreview)
                && !validOptionsFull.contains(fullOrPreview)) {
            throw new Exception("not a valid option");
        } else if (validOptionsPreview.contains(fullOrPreview)) {
            recipeProperties = userLibrary.getRecipeByID("All", recipeID).getFull();
        } else if (validOptionsFull.contains(fullOrPreview)) {
            recipeProperties = userLibrary.getRecipeByID("All", recipeID).getFull();
        }

        return recipeProperties;


    }

    public ArrayList<ArrayList<Object>> getGenreRecipes (String genreName) {
        GenreLibrary genreLibrary = new GenreLibrary();

        HashMap<Integer, Recipe> genre = new HashMap<Integer, Recipe>();
        genre = genreLibrary.getAllRecipes(genreName);

        ArrayList<ArrayList<Object>> previewList = new ArrayList<>();
        for (Recipe recipe : genre.values()) {
            previewList.add(recipe.getPreview());
        }

        return previewList;
    }
}