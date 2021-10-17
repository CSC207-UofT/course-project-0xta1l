package Entities;

import java.util.ArrayList;

/**
 * This class is the User Entity. It possesses 7 attributes:
 *  •displayName- the name the user chooses to make public(String)
 *  •age - the age of the user (int)
 *  •password - a collection of characters used to gain access to the user's account (String)
 *  •username - the user's unique identifier; used in conjunction with password to login. Sometimes called ID(String)
 *  •biography- a description of the user(String)
 *  •interests- a list of genres(Strings) the user is interested in (ArrayList<String>)
 *  •SavedRecipes - a list of the recipes the user has saved (ArrayList<Recipe>)
 *  •UserReviews - a list of the reviews the user has made (ArrayList<Review>)
 */
public class User {
    private String displayName;
    private int age;
    private String password;
    private String username;
    private String biography;
    private ArrayList<String> interests= new ArrayList<>();
    private ArrayList<Recipe> SavedRecipes = new ArrayList<>();

    // For now until we properly use the review entity in the future, Entities.User reviews is an ArrayList
    private ArrayList<Review> UserReviews = new ArrayList<>();

    public User(){
        this.interests = new ArrayList<>();
    }

    /**
     * Constructor for User
     */
    public User(String username, String pws, String name, int age, String bio, ArrayList<String> interests){
        this.displayName = name;
        this.age = age;
        this.password = pws;
        this.username = username;
        this.biography = bio;
        this.interests = interests;}

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
    public String getDisplayName(){return displayName;}
    public int getAge() {return age;}
    public String getPassword() {return password;}
    public String getUsername() {return username;}
    public String getBiography() {return biography;}
    public ArrayList<String> getInterests() {return interests;}
    public ArrayList<Recipe> getSavedRecipes() {return SavedRecipes;}
    public ArrayList<Review> getUserReviews() {return UserReviews;}

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
    public void setDisplayName(String displayName) {this.displayName = displayName;}
    public void setAge(int age) {this.age = age;}
    public void setPassword(String password) {this.password = password;}
    public void setUsername(String username) {this.username = username;}
    public void setBiography(String biography) {this.biography = biography;}
    public void addInterests(String interest) {this.interests.add(interest);}


    public void addSavedRecipes(Recipe recipe) {this.SavedRecipes.add(recipe);}

    /**
     * Generates a profile based on a given User's displayname, username, interests, biography and age
     * @return ArrayList<Object> representing the profile that has been generated
     */
    public ArrayList<Object> getProfile(){
        ArrayList<Object> profile = new ArrayList<>();
        profile.add(getDisplayName());
        profile.add(getUsername());
        profile.add(getInterests());
        profile.add(getBiography());
        profile.add(getAge());
        return profile;

    }
}
