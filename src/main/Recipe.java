package main;
import java.util.ArrayList;

public class Recipe {
    private String instructions;
    private String ingredients;
    private String genre;
    private int rating;
    private int ID;
    private ArrayList<Review> RecipeReviews;

    public String getInstructions() {return instructions;}
    public String getIngredients() {return ingredients;}
    public String getGenre() {return genre;}
    public int getRating() {return rating;}
    public int getID() {return ID;}
    public ArrayList<Review> getRecipeReviews() {return RecipeReviews;}

    public void setInstructions(String instructions) {this.instructions = instructions;}
    public void setIngredients(String ingredients) {this.ingredients = ingredients;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setRating(int rating) {this.rating = rating;}
    public void setID(int ID) {this.ID = ID;}

}


