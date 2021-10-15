package UI;

import UseCases.GetRecipe;

import java.util.ArrayList;

public class RecipeDisplay {
    public static void showRecipe(ArrayList<Object> recipeFull) {
        for (Object property: recipeFull){
            System.out.println(property);
        }
    }
}
