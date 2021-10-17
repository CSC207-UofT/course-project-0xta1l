package Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class is the Recipe Entity. It possesses 9 attributes:
 *  •instructions - the instruction to make the recipe (String)
 *  •ingredients - the different ingredients required (String where each ingredient is
 *                 separated by a comma)
 *  •genre - the type of recipe in question, for example "Jamaican" (String)
 *  •name - the name of the recipe (String)
 *  •rating - the rating given to the Recipe as designated by users (int from 1-5)
 *  •ID - the unique identifier for the recipe (int)
 *  •RecipeReviews - a list of reviews generated from users (ArrayList<Review>)
 *  •image - text representing a jpg file of the recipe (String)
 *  •description - brief description of the recipe(String)
 */

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

    /**
     * Constructor for Recipe
     */
    public Recipe(){}
    public Recipe(String i, String ing, String g, String name, int rating, int id, String img, String description){
        this.instructions = i;
        this.ingredients = ing;
        this.genre = g;
        this.name = name;
        this.rating = rating;
        this.ID = id;
        this.image = img;
        this.description = description;}

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
     * getPreview - generates and returns a preview for the recipe as an ArrayList<Object>
     *              (ID, name, rating, genre, description)
     * getFull - generates and returns all of the
     */
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
        ArrayList<Object> previewList= new ArrayList<>();
        previewList.add(getID());
        previewList.add(getName());
        previewList.add(getRating());
        previewList.add(getGenre());
        previewList.add(getDescription());

        return previewList;
    }

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
     * •setGenre - accepts genre attribute for a recipe
     * •setName - accepts name attribute for a recipe
     * •setRating - accepts rating attribute for a recipe
     * •setID - accepts ID attribute for a recipe
     * •setImage - accepts image attribute for a recipe
     * •setDescription - accepts Description attribute for a recipe
     */
    public void setInstructions(String instructions) {this.instructions = instructions;}
    public void setIngredients(String ingredients) {this.ingredients = ingredients;}
    public void setGenre(String genre) {this.genre = genre;}
    public void setRating(int rating) {this.rating = rating;}
    public void setID(int ID) {this.ID = ID;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}

    public void setImage(String image) {this.image = image;}





}


