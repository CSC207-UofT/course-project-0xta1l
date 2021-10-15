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

        Recipe recipe1 = new Recipe("Set on Fire", "Salt",
                "Mexican", "Burnt Food", 5, 1, "burnt.jpg");

        Recipe recipe2 = new Recipe("Throw in Oven", "Chicken",
                "Chinese", "Chicken", 4, 2, "chicken.jpg");

        Recipe recipe3 = new Recipe("Pan fry in pan", "Steak, butter",
                "Western", "Good Steak", 5, 3, "steak.jpg");

        Recipe recipe4 = new Recipe("Boil in water", "Spinach, Mushrooms",
                "Egyptian", "Random Veggies", 2, 4, "veg.jpg");

        Recipe recipe5 = new Recipe("Throw maple syrup on pancakes", "Pancakes, salt, butter",
                "Canadian", "Pancakes", 3, 5, "pancake.jpg");

        dataset.addRecipes(recipe1.getGenre(), recipe1);
        dataset.addRecipes(recipe2.getGenre(), recipe2);
        dataset.addRecipes(recipe3.getGenre(), recipe3);
        dataset.addRecipes(recipe4.getGenre(), recipe4);
        dataset.addRecipes(recipe5.getGenre(), recipe5);
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
            String result = s[5].replaceAll("^\"+|\"+$", "").replaceAll("\\s+","");
            ArrayList<String> s5 = new ArrayList<String>(Arrays.asList(result.split(",")));
            User user = new User(s[0],s[1],s[2],Integer.parseInt(s[3]),s[4],s5);
            userSecurity.addUser(user);
        } return userSecurity;
    }

    public static void main(String[] args) throws FileNotFoundException {
        UserSecurity us = CSVUserReader("src/main/Constants/users.csv");
    }

}
