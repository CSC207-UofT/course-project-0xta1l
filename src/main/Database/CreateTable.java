package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createNewTableRecipe() {
        // SQLite connection string  
        String url = "jdbc:sqlite:C://sqlite/oxtail.db";

        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n"
                + " id integer PRIMARY KEY,\n"
                + " name TEXT NOT NULL,\n"
                + " genres TEXT NOT NULL,\n"
                + " rating integer real,\n"
                + " preptime integer real,\n"
                + " description TEXT NOT NULL,\n"
                + " ingredients TEXT NOT NULL,\n"
                + " instructions TEXT NOT NULL,\n"
                + " img TEXT NOT NULL\n"
                + ");";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNewTableUser() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/oxtail.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS employees (\n"
                + " id integer PRIMARY KEY,\n"
                + " display_name TEXT NOT NULL,\n"
                + " age integer real,\n"
                + " username TEXT NOT NULL,\n"
                + " password TEXT NOT NULL,\n"
                + " biography TEXT NOT NULL,\n"
                + " interests TEXT NOT NULL,\n"
                + " saved_recipes TEXT NOT NULL\n"
                + " saved_reviews TEXT NOT NULL\n"
                + ");";

        try{
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments 
     */
    public static void main(String[] args) {
        createNewTableUser();
        createNewTableRecipe();
    }

}  