package UI;


import java.util.ArrayList;

public class ListDisplay {
    public void DisplayGenre(ArrayList<String> browseInfo) {
        System.out.println("Genres: ");
        System.out.println("All");
        /*for(String str: browseInfo){
            System.out.println(str);
        }*/
    }
    public void DisplayListOfRecipes(ArrayList<ArrayList<Object>> browseInfo) {
        if (browseInfo.size() == 0){
            System.out.println("No recipes to display.");
        } else{
            for (ArrayList<Object> recipe : browseInfo) {
                System.out.println("Recipe ID: " + recipe.get(0));
                System.out.println("Recipe Name: " + recipe.get(1));
                System.out.println("Recipe Rating: " + recipe.get(2) + "\n");
            }
        }
    }
}