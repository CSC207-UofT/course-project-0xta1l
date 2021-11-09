package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recipe {
    private String instructions;
    private String ingredients;
    private ArrayList<String> genre;
    private String name;
    private int rating;
    private int ID;
    private ArrayList<Review> RecipeReviews = new ArrayList<>();
    private String image;
    private String description;
    private int preptime;

    public Recipe(){}
    public Recipe(String instructions, String ingredients, ArrayList<String> genre, String name, int rating, int id,
                  String image, String description, int preptime){
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.genre = genre;
        this.name = name;
        this.rating = rating;
        this.ID = id;
        this.description = description;
        this.preptime = preptime;
        this.image = image;}


    public String getInstructions() {return instructions;}
    public String getIngredients() {return ingredients;}
    public ArrayList<String> getGenre() {return genre;}
    public String getName() {return name;}
    public int getRating() {return rating;}
    public int getID() {return ID;}
    public String getImage() {return image;}
    public String getDescription() {return description;}
    public ArrayList<Review> getRecipeReviews() {return RecipeReviews;}
    public int getPreptime() {return preptime;}
    public Preview getPreview() {
        return new Preview(ID, name, rating, genre, description);
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
        fullList.add(getPreptime());

        return fullList;
    }

    public void setInstructions(String instructions) {this.instructions = instructions;}
    public void setIngredients(String ingredients) {this.ingredients = ingredients;}
    public void setGenre(ArrayList<String> genre) {this.genre = genre;}
    public void setRating(int rating) {this.rating = rating;}
    public void setID(int ID) {this.ID = ID;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}
    public void setPreptime(int preptime) {this.preptime = preptime;}

    public void setImage(String image) {this.image = image;}





}


