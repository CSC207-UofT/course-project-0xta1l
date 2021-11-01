package Constants;

import Entities.GenreLibrary;
import Entities.Recipe;
import Entities.User;
import Entities.UserSecurity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Constants {
    // Create Constants
    public static UserSecurity USERSECURITY;

    static {
        try {
            USERSECURITY = Constants.CSVUserReader("src/main/Constants/users.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static GenreLibrary GENRELIBRARY =  Constants.createDataset();

    public static GenreLibrary createDataset() {
        GenreLibrary dataset = new GenreLibrary();
        ArrayList<String> r1genres = new ArrayList<>();
        r1genres.add("Mexican");
        ArrayList<String> r2genres = new ArrayList<>();
        r2genres.add("Chinese");
        ArrayList<String> r3genres = new ArrayList<>();
        r3genres.add("Western");
        ArrayList<String> r4genres = new ArrayList<>();
        r4genres.add("Egyptian");
        ArrayList<String> r5genres = new ArrayList<>();
        r5genres.add("Canadian");

        Recipe recipe1 = new Recipe("Set on Fire", "Salt",
                r1genres, "Burnt Food", 5, 1, "burnt.jpg", "");

        Recipe recipe2 = new Recipe("Throw in Oven", "Chicken",
                r2genres, "Chicken", 4, 2, "chicken.jpg", "");

        Recipe recipe3 = new Recipe("Pan fry in pan", "Steak, butter",
                r3genres, "Good Steak", 5, 3, "steak.jpg", "");

        Recipe recipe4 = new Recipe("Boil in water", "Spinach, Mushrooms",
                r4genres, "Random Veggies", 2, 4, "veg.jpg", "");

        Recipe recipe5 = new Recipe("Throw maple syrup on pancakes", "Pancakes, salt, butter",
                r5genres, "Pancakes", 3, 5, "pancake.jpg", "");

        for (String g: recipe1.getGenre()){
            dataset.addRecipes(g, recipe1);
        }
        for (String g: recipe2.getGenre()){
            dataset.addRecipes(g, recipe2);
        }
        for (String g: recipe3.getGenre()){
            dataset.addRecipes(g, recipe3);
        }
        for (String g: recipe4.getGenre()){
            dataset.addRecipes(g, recipe4);
        }
        for (String g: recipe5.getGenre()){
            dataset.addRecipes(g, recipe5);
        }
        return dataset;
    }

    public static UserSecurity CSVUserReader(String fileName) throws FileNotFoundException {
        UserSecurity userSecurity = new UserSecurity();
        Path pathToFile = Paths.get(fileName);
        Path path = pathToFile.toAbsolutePath();

        FileReader fr = new FileReader(path.toString());
        BufferedReader br = new BufferedReader(fr);
        Stream<String> stream = br.lines();
        Object[] list = stream.toArray();
        for (int j = 0; j < list.length; j++) {
            String[] s = list[j].toString().split(",", 6);
            String result = s[5].replaceAll("^\"+|\"+$\\s", "");
            ArrayList<String> s5 = new ArrayList<>(Arrays.asList(result.split(",")));
            User user = new User(s[0],s[1],s[2],Integer.parseInt(s[3]),s[4],s5);
            userSecurity.addUser(user);
        } return userSecurity;
    }

    public static void main(String[] args) throws FileNotFoundException {
        UserSecurity us = CSVUserReader("src/main/Constants/users.csv");
    }

}