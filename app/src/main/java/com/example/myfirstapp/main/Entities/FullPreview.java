package com.example.myfirstapp.main.Entities;

import java.util.ArrayList;
/**
 * This class is the FullPreview entity, which inherits the ID, name, rating, genre, and description
 * attributes from parent class Preview.
 * It possesses 4 additional attributes:
 * •preptime - the time (in minutes) it takes to make the recipe
 * •image - the filename of a photo for the recipe
 * •ingredients - the ingredients required for the recipe
 * •instructions - the instructions to follow for the recipe
 */
public class FullPreview extends Preview {
    private int ID;
    private String name;
    private int rating;
    private ArrayList<String> genre;
    private String description;
    private String image;
    private int preptime;
    private String ingredients;
    private String instructions;

    /**
     * Constructor for FullPreview
     */
    public FullPreview(Recipe recipe) {
        super(recipe.getID(), recipe.getName(), recipe.getRating(), recipe.getGenre(), recipe.getDescription());
        this.image = recipe.getImage();
        this.preptime = recipe.getPreptime();
        this.ingredients = recipe.getIngredients();
        this.instructions = recipe.getInstructions();
    }

    /**
     * Getter Methods for FullPreview:
     * •getImage - returns image file name
     * •getPreptime - returns preptime
     * •getIngredients - returns ingredients
     * •getInstructions - returns instructions
     */
    public String getImage() {
        return image;
    }

    public int getPreptime() {
        return preptime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }


    /**
     * Setter Methods for FullPreview:
     * The Preview Entity's attributes should not be set directly.
     * Instead, when their corresponding Recipe Entity's attributes
     * are changed so are the Preview's, and therefore the FullPreview's. All of Preview's
     * setter methods are inherited, and extras are defined directly.
     */
    public void setImage(String img) {
        this.image = img;
    }

    public void setPreptime(int rating) {
        this.rating = rating;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
