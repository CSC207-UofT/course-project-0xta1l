package Entities;

import Entities.Recipe;

import java.util.ArrayList;

public class Preview {
    /**
     * This class is the Preview Entity for a corresponding Recipe Entity (meaning they share the same ID).
     * It possesses 5 attributes:
     * •ID - the unique identifier for the recipe (int)
     * •name - the name of the recipe (String)
     * •rating - the rating given to the Recipe as designated by users (int from 1-5)
     * •genre - the type of recipe in question, for example "Jamaican" (String)
     * •description - brief description of the recipe(String)
     */
    private int ID;
    private String name;
    private int rating;
    private ArrayList<String> genre;
    private String description;

    /**
     * Constructors for a Recipe's Preview
     */
    public Preview(){};
    public Preview(Recipe recipe){
        this.ID = recipe.getID();
        this.name = recipe.getName();
        this.rating = recipe.getRating();
        this.genre = recipe.getGenre();
        this.description = recipe.getDescription();}
    public Preview(int id, String n, int rate, ArrayList<String> g, String description){
        this.ID = id;
        this.name = n;
        this.rating = rate;
        ArrayList<String> genres = new ArrayList<>();
        genres.add("All");
        genres.addAll(g);
        this.genre = genres;
        this.description = description;}

    /**
     * Getter Methods for Preview:
     * •getGenre - returns genre
     * •getName - returns name
     * •getRating - returns rating
     * •getID - returns ID
     * •getDescription - returns Description
     */
    public ArrayList<String> getGenre() {return genre;}
    public String getName() {return name;}
    public int getRating() {return rating;}
    public int getID() {return ID;}
    public String getDescription() {return description;}


    /**
     * Setter Methods for Preview:
     * •setGenre - accepts genre attribute for a recipe
     * •setName - accepts name attribute for a recipe
     * •setRating - accepts rating attribute for a recipe
     * •setID - accepts ID attribute for a recipe
     * •setDescription - accepts Description attribute for a recipe
     */
    public void setGenre(ArrayList<String> genre) {this.genre = genre;}
    public void setRating(int rating) {this.rating = rating;}
    public void setID(int ID) {this.ID = ID;}
    public void setName(String name) {this.name = name;}
    public void setDescription(String description) {this.description = description;}


}
