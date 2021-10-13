import java.util.ArrayList;

public class User {
    private String displayName;
    private int age;
    private String password;
    private String username;
    private String biography;
    private String interests;
    private ArrayList<Recipe> SavedRecipes = new ArrayList<>();

    // For now until we properly use the review entity in the future, User reviews is an ArrayList
    private ArrayList<Recipe> SavedRecipes = new ArrayList<>();
    private ArrayList<Review> UserReviews = new ArrayList<>();

    public String getDisplayName(){return displayName;}
    public int getAge() {return age;}
    public String getPassword() {return password;}
    public String getUsername() {return username;}
    public String getBiography() {return biography;}
    public String getInterests() {return interests;}
    public ArrayList<Recipe> getSavedRecipes() {return SavedRecipes;}
    public ArrayList<Review> getUserReviews() {return UserReviews;}

    public void setDisplayName(String displayName) {this.displayName = displayName;}
    public void setAge(int age) {this.age = age;}
    public void setPassword(String password) {this.password = password;}
    public void setUsername(String username) {this.username = username;}
    public void setBiography(String biography) {this.biography = biography;}
    public void setInterests(String interests) {this.interests = interests;}

    public ArrayList<Object> getProfile(){
        ArrayList<Object> profile = new ArrayList<>();
        profile.add(getDisplayName());
        profile.add(getUsername());
        profile.add(getInterests());
        profile.add(getBiography());
        profile.add(getAge());
        return profile;
      
    public void addSavedRecipes(Recipe recipe) {this.SavedRecipes.add(recipe);}
    public ArrayList<Recipe> getUserSavedRecipes(){return this.getSavedRecipes();}


    }
}
