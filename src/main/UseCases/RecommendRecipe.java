package UseCases;

import Entities.Recipe;
import Entities.User;
import Constants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RecommendRecipe {
    public void recommend(String username, int recsNum){
        User user = Constants.USERSECURITY.getUserByID(username);
        HashMap<String, Double> genreWeights = user.getGenreWeights();
        ArrayList<String> highestGenres = getHighest(genreWeights);
        // randomly choose one genre out of the highest
        Random rand = new Random();
        String recGenre = highestGenres.get(rand.nextInt(highestGenres.size()));
        /// now get genre, and sort by rating, get one highest one random

    }

    private ArrayList<String> getHighest(HashMap<String, Double> genreWeights){
        ArrayList<String> highestGenres = new ArrayList<>();
        Double highestWeight = null;

        for (String genre: genreWeights.keySet()){
            if (genreWeights.get(genre) > highestWeight){
                highestGenres = new ArrayList<>();
                highestGenres.add(genre);
            } else if (genreWeights.get(genre).equals(highestWeight)){
                highestGenres.add(genre);
            }
        }

        return highestGenres;
    }
}
