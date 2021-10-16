package UI;


import java.util.ArrayList;

public class ListDisplay {
    public void DisplayGenre(ArrayList<String> browseInfo) {
        for(String str: browseInfo){
            System.out.println(str + "\n");
        }
    }
    public void DisplayListOfRecipes(ArrayList<Object> browseInfo) {
        for(Object obj: browseInfo){
            System.out.println(obj + "\n");
        }
    }
    public void DisplayRecipe(ArrayList<Object> browseInfo) {
        System.out.println("RecipeID: " + browseInfo.get(0));
        System.out.println("Recipe Name: " + browseInfo.get(1));
        System.out.println("Recipe Rating: " + browseInfo.get(2));
        System.out.println("Recipe Genre: " + browseInfo.get(3));
        System.out.println("Recipe Description: " + browseInfo.get(4));
        System.out.println("Recipe Ingredients: " + browseInfo.get(5));
        System.out.println("Recipe Instructions: " + browseInfo.get(6));
    }
}