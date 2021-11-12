package UseCases;

import Entities.Preview;
import Entities.Recipe;
import Entities.User;
import Constants.*;
import java.util.*;

public class RecommendRecipe {
    public ArrayList<Preview> recommend(String username, int recsNum) {
        /**
         * This method returns an ArrayList of Preview Entities of size recsNum.
         * If the generated list of best recommendations is less than required size recsNum,
         * the remainder of list is composed of random recipes
         * The method takes in the String username of a user in USERSECURITY and the desired number of recommendations
         */
        User user = Constants.USERSECURITY.getUserByID(username);
        HashMap<String, Double> genreWeights = user.getGenreWeights();
        ArrayList<String> sortedGenres = sortByWeight(genreWeights);
        String bestGenre = sortedGenres.get(0);
        ArrayList<Preview> sortedRecipes = getSortedPreviewsFromGenre(bestGenre);
        ArrayList<Preview> recommendations = new ArrayList<>();
        int remainder = recsNum - sortedRecipes.size();

        if (sortedRecipes.size() > remainder){
            for (int i = 0; i < recsNum; i++) {
                recommendations.add(sortedRecipes.get(i));
            }
            return recommendations;
        }
        else
            return recursiveRecommend(recommendations, sortedGenres,0, recsNum);


    }

    private ArrayList<Preview> recursiveRecommend
            (ArrayList<Preview> recommends, ArrayList<String> genres, int genreNum, int rest){

        ArrayList<Preview> previews = getSortedPreviewsFromGenre(genres.get(genreNum));
        ArrayList<Preview> previews2 = getSortedPreviewsFromGenre(genres.get(genreNum+1));
        recommends.addAll(previews);
        int remainder = rest - previews.size();

        if (remainder >= previews2.size()){
            return recursiveRecommend(recommends, genres, genreNum+1, remainder);}
        //else
        for (int i = 0; i < remainder; i++) {recommends.add(previews2.get(i));}
        return recommends;
    }

    private ArrayList<Preview> getSortedPreviewsFromGenre(String genre) {
        HashMap<Integer, Recipe> recipesWithID = Constants.GENRELIBRARY.getAllRecipes(genre);
        ArrayList<Recipe> recipes = new ArrayList<>(recipesWithID.values());
        ArrayList<Preview> previews = new ArrayList<>();
        for (Recipe recipe : recipes) {
            previews.add(recipe.getPreview());
        }
        SortByRating s = new SortByRating(previews);
        return s.sort();
    }

    private ArrayList<String> getHighest(HashMap<String, Double> genreWeights) {
        //not needed if we can just take first element of sort by weight method
        ArrayList<String> highestGenres = new ArrayList<>();
        Double highestWeight = 0.0;

        for (String genre : genreWeights.keySet()) {
            if (genreWeights.get(genre) > highestWeight) {
                highestGenres = new ArrayList<>();
                highestGenres.add(genre);
            } else if (genreWeights.get(genre).equals(highestWeight)) {
                highestGenres.add(genre);
            }
        }

        return highestGenres;
    }

    private ArrayList<String> sortByWeight(HashMap<String, Double> genreWeights) {
        //this method returns a list of all the genres in the given mapping but sorted from
        // highest to lowest weight
        ArrayList<Double> weights = new ArrayList<>(genreWeights.values());
        Collections.sort(weights);
        Collections.reverse(weights);
        ArrayList<String> sortedGenres = new ArrayList<>();
        for (Double w : weights) {
            for (String genre : genreWeights.keySet()) {
                if(genreWeights.get(genre).equals(w)){
                    sortedGenres.add(genre);
                }
            }
        }
        return sortedGenres;
    }

}


