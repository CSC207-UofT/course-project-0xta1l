package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * This class is the Recipe Entity. It possesses 10 attributes:
 *  •instructions - the instructions to make the recipe (String)
 *  •ingredients - the different ingredients required (String where each ingredient is
 *                 separated by a comma)
 *  •genre - the types of recipe in question, for example "Jamaican" and "Dessert" (ArrayList of Strings)
 *  •name - the name of the recipe (String)
 *  •rating - the rating given to the Recipe as designated by users (int from 1-5)
 *  •ID - the unique identifier for the recipe (int)
 *  •RecipeReviews - a list of reviews generated from users (ArrayList<Review>)
 *  •image - text representing a jpg file of the recipe (String)
 *  •description - brief description of the recipe(String)
 *  •preview - contains a subset of the recipe's attributes (name, id, genres, rating, description)
 */

public class Recipe {
    private String instructions;
    private String ingredients;
    private ArrayList<String> genre;
    private String name;
    private int rating;
    private int ID;
    private HashMap<String, Review> RecipeReviews;
    private String image;
    private String description;
    public Preview preview;

    /**
     * Constructor for Recipe
     */
    public Recipe(){this.preview = new Preview();}
    public Recipe(String i, String ing, ArrayList<String>  g, String name, int rating, int id, String img, String description){
        this.instructions = i;
        this.ingredients = ing;
        ArrayList<String> genres = new ArrayList<>();
        genres.add("All");
        genres.addAll(g);
        this.genre = genres;
        this.name = name;
        this.rating = rating;
        this.ID = id;
        this.image = img;
        this.description = description;
        this.RecipeReviews = new Hashmap<>();
        this.preview = new Preview(id, name, rating, genres, description);
    }


    /**
     * Getter Methods for Recipe:
     * •getInstructions - returns instructions
     * •getIngredients -  returns ingredients
     * •getGenre - returns genre
     * •getName - returns name
     * •getRating - returns rating
     * •getID - returns ID
     * •getImage - returns image
     * •getDescription - returns Description
     * •getRecipeReviews - returns RecipeReviews
     * getPreview - generates and returns a preview for the recipe as a Preview Entity with attributes:
     *              ID, name, rating, genre, description
     * getFull - generates and returns all the attributes
     */
    public String getInstructions() {return instructions;}
    public String getIngredients() {return ingredients;}
    public ArrayList<String> getGenre() {return genre;}
    public String getName() {return name;}
    public int getRating() {return rating;}
    public int getID() {return ID;}
    public String getImage() {return image;}
    public String getDescription() {return description;}
    public HashMap<String, Review> getRecipeReviews() {return RecipeReviews;}
    public Preview getPreview() {return preview;}

    public ArrayList<Object> getFull() {
        ArrayList<Object> fullList = new ArrayList<>();
        fullList.add(getID());
        fullList.add(getName());
        fullList.add(getRating());
        fullList.add(getGenre());
        fullList.add(getDescription());
        fullList.add(getIngredients());
        fullList.add(getInstructions());

        return fullList;
    }

    /**
     * Setter Methods for Recipe:
     * •setInstructions - accepts instruction attribute for a recipe
     * •setIngredients - accepts ingredients attribute for a recipe
     * •setGenre - accepts genre attribute for a recipe, alters recipe's preview
     * •setName - accepts name attribute for a recipe, alters recipe's preview
     * •setRating - accepts rating attribute for a recipe, alters recipe's preview
     * •setID - accepts ID attribute for a recipe, alters recipe's preview
     * •setImage - accepts image attribute for a recipe
     * •setDescription - accepts Description attribute for a recipe, alters recipe's preview
     */
    public void setInstructions(String instructions) {this.instructions = instructions;}
    public void setIngredients(String ingredients) {this.ingredients = ingredients;}
    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
        this.preview.setGenre(genre);}
    public void setRating(int rating) {
        this.rating = rating;
        this.preview.setRating(rating);}
    public void setID(int ID) {
        this.ID = ID;
        this.preview.setID(ID);}
    public void setName(String name) {
        this.name = name;
        this.preview.setName(name);}
    public void setDescription(String description) {
        this.description = description;
        this.preview.setDescription(description);}
    public void setImage(String image) {this.image = image;}


}


