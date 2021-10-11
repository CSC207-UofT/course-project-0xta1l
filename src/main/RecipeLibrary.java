import java.util.ArrayList;

public class RecipeLibrary {
    private ArrayList<Recipe> ListOfAllRecipes;

    public ArrayList<Recipe> getListOfAllRecipes() {
        return ListOfAllRecipes;
    }

    public void addRecipes(Recipe recipe) {
        ListOfAllRecipes.add(recipe) ;
    }
}
