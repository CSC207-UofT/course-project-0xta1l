import java.util.ArrayList;

public class User {
    private String displayName;
    private int age;
    private String password;
    private String username;
    private String biography;
    private ArrayList<Recipe> SavedRecipes;
    private ArrayList<Review> UserReviews;

    public String getDisplayName(){return displayName;}
    public int getAge() {return age;}
    public String getPassword() {return password;}
    public String getUsername() {return username;}
    public String getBiography() {return biography;}
    public ArrayList<Recipe> getSavedRecipes() {
        return SavedRecipes;
    }
    public ArrayList<Review> getUserReviews() {
        return UserReviews;
    }

    public void setDisplayName(String displayName) {this.displayName = displayName;}
    public void setAge(int age) {this.age = age;}
    public void setPassword(String password) {this.password = password;}
    public void setUsername(String username) {this.username = username;}
    public void setBiography(String biography) {this.biography = biography;}

    public void addSavedRecipes(Recipe recipe) {this.SavedRecipes.add(recipe);}


    public ArrayList<Recipe> getUserSavedRecipes(){return this.getSavedRecipes();}

}
