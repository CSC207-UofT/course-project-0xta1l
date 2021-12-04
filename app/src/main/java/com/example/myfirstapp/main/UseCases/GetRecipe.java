package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.Constants;

import java.util.ArrayList;
import java.util.HashMap;

public class GetRecipe {
    /**
     * Gets the user saved recipes by username
     * @param username is the username of the user
     * @return list of recipe previews
     */
    public ArrayList<Preview> getUserSavedRecipes(String username) {
        User user = Constants.USERSECURITY.getUserByID(username);
        ArrayList<Recipe> userRecipeList = user.getSavedRecipes();

        ArrayList<Preview> previewList = new ArrayList<>();

        for (Recipe recipe: userRecipeList) {
            previewList.add(recipe.getPreview());
        }

        return previewList;
    }
    /**
     * Gets the user saved recipes by username
     * @param recipeID is the id of the specified recipe
     * @param fullOrPreview the type of recipe you want to view
     * @return a preview of a recipe
     */
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
    /**
     * Gets the genre recipes by genreName
     * @param genreName is the name of the genre you want to be returned
     * @return list of recipe previews for a specified genre
     */
    public ArrayList<Preview> getGenreRecipes (String genreName) {

        HashMap<Integer, Recipe> genre;

        genre = Constants.GENRELIBRARY.getAllRecipes(genreName);

        ArrayList<Preview> previewList = new ArrayList<>();
        for (Recipe recipe : genre.values()) {
            previewList.add(recipe.getPreview());
        }
        return previewList;
    }
}