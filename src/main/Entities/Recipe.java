package Entities;

import java.util.ArrayList;

public class Recipe {
    private String instructions;
    private String ingredients;
    private String genre;
    private String name;
    private int rating;
    private int ID;
    private ArrayList<Review> RecipeReviews = new ArrayList<>();
    private String image;

    Recipe(){}
    Recipe(String i, String ing, String g, String name, int rating, int id, String img){
        this.instructions = i;
        this.ingredients = ing;
        this.genre = g;
        this.name = name;
        this.rating = rating;
        this.ID = id;
        this.image = img;}

    public String getInstructions() {return instructions;}
    public String getIngredients() {return ingredients;}
    public String getGenre() {return genre;}
    public String getName() {return name;}
    public int getRating() {return rating;}
    public int getID() {return ID;}
    public String getImage() {return image;}
    public ArrayList<Review> getRecipeReviews() {return RecipeReviews;}

    public void setInstructions(String instructions) {this.instructions = instructions;}
    public void setIngredients(String ingredients) {this.ingredients = ingredients;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setRating(int rating) {this.rating = rating;}
    public void setID(int ID) {this.ID = ID;}
    public void setName(String name) {this.name = name;}

    public void setImage(String image) {this.image = image;}





}


