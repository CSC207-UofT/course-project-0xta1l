package Database;

import Entities.Recipe;
import Entities.Review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class InsertRecords {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/oxtail.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertRecipe(String name, ArrayList<String> genres, int rating, int preptime, String description,
                             String ingredients, String instructions, String img) {

        String sql = "INSERT INTO recipes" +
                "(id, name, genres, rating, preptime, description, ingredients, instructions, img) " +
                "VALUES(?,?,?,?,?,?,?,?,?)";

        String genreList = String.join(", ", genres);

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, genreList);
            pstmt.setInt(3, rating);
            pstmt.setInt(4, preptime);
            pstmt.setString(5, description);
            pstmt.setString(6, ingredients);
            pstmt.setString(7, instructions);
            pstmt.setString(8, img);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertUser(String display_name, int age, String username, String password,
                           String biography, ArrayList<String> interests, ArrayList<Recipe> savedRecipes) {
        String sql = "INSERT INTO users" +
                "(display_name, age, username, password, biography, interests, saved_recipes) " +
                "VALUES(?,?,?,?,?,?,?)";

        String interestList = String.join(", ", interests);

        // If the user has no saved recipes, return an empty string.
        String savedRecipeList = "";

        if (!savedRecipes.isEmpty()) {
            ArrayList<String> savedRecipeIDList = new ArrayList<String>();
            for (Recipe recipe: savedRecipes) {
                savedRecipeIDList.add(String.valueOf(recipe.getID()));
            }
            savedRecipeList = String.join(", ", savedRecipeIDList);
        }


        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, display_name);
            pstmt.setInt(2, age);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            pstmt.setString(5, biography);
            pstmt.setString(6, interestList);
            pstmt.setString(7, savedRecipeList);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertReview(int recipeID, String username, int rating, String comment) {
        String sql = "INSERT INTO reviews" +
                "(recipe_ID, username, rating, comment) " +
                "VALUES(?,?,?,?)";

        try{
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, recipeID);
            pstmt.setString(2, username);
            pstmt.setInt(3, rating);
            pstmt.setString(4, comment);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        InsertRecords app = new InsertRecords();

        // Inserting test user Billy
        ArrayList<String> billyInterests = new ArrayList<String>(Arrays.asList("Chinese", "Mexican"));
        ArrayList<Recipe> billySavedRecipes = new ArrayList<Recipe>();
        System.out.println(billySavedRecipes.isEmpty());
        app.insertUser("Billy", 20, "billybobjoe", "password",
                "test user", billyInterests, billySavedRecipes );

        // Inserting test user Bobby
        ArrayList<String> bobbyInterests = new ArrayList<String>(Arrays.asList("Western"));
        ArrayList<Recipe> bobbySavedRecipes = new ArrayList<Recipe>();
        app.insertUser("Bobby", 20, "bobbybobbitybob", "password",
                "test user", bobbyInterests, bobbySavedRecipes );

        // Creating test reviews
        app.insertReview(1, "billybobjoe", 5, "tastes amazing!");
        app.insertReview(1, "bobbybobbitybob", 2, "tastes burnt");
        app.insertReview(3, "billybobjoe", 1, "im a vegan");

    }

}