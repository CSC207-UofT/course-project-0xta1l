package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe {
    private String instructions;
    private String ingredients;
    private String genre;
    private String name;
    private int rating;
    private int ID;
    private ArrayList<Review> RecipeReviews = new ArrayList<>();
    private String image;
    private String description;

    public Recipe(){}
    public Recipe(String i, String ing, String g, String name, int rating, int id, String img){
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
    public String getDescription() {return description;}
    public ArrayList<Review> getRecipeReviews() {return RecipeReviews;}
    public ArrayList<Object> getPreview() {
        ArrayList<Object> previewList= new ArrayList<Object>();
        previewList.add(getID());
        previewList.add(getName());
        previewList.add(getRating());
        previewList.add(getGenre());
        previewList.add(getDescription());

        return previewList;
    }

    public ArrayList<Object> getFull() {
        ArrayList<Object> fullList = new ArrayList<Object>();
        fullList.add(getID());
        fullList.add(getName());
        fullList.add(getRating());
        fullList.add(getGenre());
        fullList.add(getDescription());
        fullList.add(getIngredients());
        fullList.add(getInstructions());

        return fullList;
    }

    public void setInstructions(String instructions) {this.instructions = instructions;}
    public void setIngredients(String ingredients) {this.ingredients = ingredients;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setRating(int rating) {this.rating = rating;}
    public void setID(int ID) {this.ID = ID;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}

    public void setImage(String image) {this.image = image;}





}


