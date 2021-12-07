package com.example.myfirstapp.main.Entities;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is the User Entity. It possesses 7 attributes:
 * •displayName- the name the user chooses to make public(String)
 * •age - the age of the user (int)
 * •password - a collection of characters used to gain access to the user's account (String)
 * •username - the user's unique identifier; used in conjunction with password to login. Sometimes called ID(String)
 * •biography- a description of the user(String)
 * •interests- a list of genres(Strings) the user is interested in (ArrayList<String>)
 * •SavedRecipes - a list of the recipes the user has saved (ArrayList<Recipe>)
 * •UserReviews - a list of the reviews the user has made (ArrayList<Review>)
 */
public class User {
    private String displayName;
    private int age;
    private String password;
    private String username;
    private String biography;
    private ArrayList<String> interests;
    private ArrayList<Recipe> SavedRecipes = new ArrayList<>();

    private HashMap<Integer, Review> UserReviews = new HashMap<>();
    private HashMap<String, Double> GenreWeights = new HashMap<>();

    public User() {
        this.interests = new ArrayList<>();
    }

    /**
     * Constructor for User
     */
    public User(String username, String pws, String name, int age, String bio, ArrayList<String> interests, ArrayList<String> genreList) {
        this.displayName = name;
        this.age = age;
        this.password = pws;
        this.username = username;
        this.biography = bio;
        this.interests = interests;
        initializeGenreWeights(this.interests, genreList);
    }

    /* Updates GenreWeights to match interests */
    public void initializeGenreWeights(ArrayList<String> interests, ArrayList<String> genreList) {
        for (String interest : interests) {
            if (!this.GenreWeights.containsKey(interest)) {
                this.GenreWeights.put(interest, 0.70);
            }
        }
        for (String genre : genreList) {
            if (!this.GenreWeights.containsKey(genre)) {
                this.GenreWeights.put(genre, 0.0);
            }
        }

    }

    /* Updates GenreWeights to match interests */
    private void updateGenreWeights(ArrayList<String> interests) {
        for (String interest : interests) {
            this.GenreWeights.put(interest, (this.GenreWeights.get(interest) + 0.70));
        }
    }

    private void deleteGenreWeights(ArrayList<String> deleted) {
        for (String delete : deleted) {
            this.GenreWeights.put(delete, (this.GenreWeights.get(delete) - 0.70));
        }
    }

    public void updateGenreWeight(String genre, Double weight) {
        this.GenreWeights.put(genre, weight);
    }

    /* Updates GenreWeights when a recipe is saved */
    private void updateGenreWeights(Recipe recipe) {
        ArrayList<String> recipeGenre = recipe.getGenre();
        for (String genre : recipeGenre) {
            if (!genre.equals("All") && !genre.equals("Meal") && !genre.equals("Appetizer")) {
                if (!GenreWeights.containsKey(genre)) {
                    this.GenreWeights.put(genre, 0.05);
                } else {
                    if (GenreWeights.get(genre) <= 0.95) {
                        GenreWeights.put(genre, GenreWeights.get(genre) + 0.05);
                    }
                }

            } // make sure that GenreWeights.get(genre) is not greater than 1.0
        }
    }

    /* Updates GenreWeights when an interest is removed */
    private void updateGenreWeights(String genre) {
        this.GenreWeights.put(genre, 0.0);
    }

    public void updateGenreWeightsTest5(String genre) {
        this.GenreWeights.put(genre, 0.5);
    }

    public void updateGenreWeightsTest3(String genre) {
        this.GenreWeights.put(genre, 0.3);
    }

    public void updateGenreWeightsTest2(String genre) {
        this.GenreWeights.put(genre, 0.2);
    }

    public void updateGenreWeightsTest1(String genre) {
        this.GenreWeights.put(genre, 0.1);
    }


    /**
     * Getter Methods for User:
     * •getDisplayName - returns displayname
     * •getAge -  returns age
     * •getPassword - returns password
     * •getUsername - returns username
     * •getBiography - returns biography
     * •getInterests - returns interests
     * •getSavedRecipes - returns SavedRecipes
     * •getUserReviews - returns UserReviews
     */
    public String getDisplayName() {
        return displayName;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getBiography() {
        return biography;
    }

    public ArrayList<String> getInterests() {
        return interests;
    }

    public ArrayList<Recipe> getSavedRecipes() {
        return SavedRecipes;
    }

    public HashMap<Integer, Recipe> getSavedRecipesHash() {
        HashMap<Integer, Recipe> h = new HashMap<>();
        for (Recipe recipe : SavedRecipes) {
            h.put(recipe.getID(), recipe);
        }
        return h;
    }

    public HashMap<Integer, Review> getUserReviews() {
        return UserReviews;
    }

    public HashMap<String, Double> getGenreWeights() {
        return GenreWeights;
    }

    /**
     * Setter Methods for User:
     * •setDisplayName - accepts displayname attribute for a User
     * •setAge -  accepts age attribute for a User
     * •setPassword - accepts password attribute for a User
     * •setUsername - accepts username attribute for a User
     * •setBiography - accepts biography attribute for a User
     * •addInterests - adds an interest to the given User's interests
     * •addSavedRecipes - adds a Recipe to the given User's  SavedRecipes
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setInterests(ArrayList<String> s) {
        this.interests = s;
    }

    public void setInterests(ArrayList<String> previousInterests, ArrayList<String> interests) {
        this.interests = interests;
        deleteGenreWeights(previousInterests);
        updateGenreWeights(interests);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addSavedRecipes(Recipe recipe) {
        SavedRecipes.add(recipe);
        updateGenreWeights(recipe);
    }

    public void addSavedReviews(int recipeID, Review review) {
        UserReviews.put(recipeID, review);
    }

    /**
     * Generates a profile based on a given User's displayname, username, interests, biography and age
     *
     * @return ArrayList<Object> representing the profile that has been generated
     */
    public UserInfo getProfile() {
        return new UserInfo(username, password, displayName, age, biography, interests);
    }


    public void removeSavedRecipes(Recipe recipe) {
        SavedRecipes.remove(recipe);
    }
}
