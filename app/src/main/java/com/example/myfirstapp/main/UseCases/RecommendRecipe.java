package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.GenreLibrary;
import com.example.myfirstapp.main.Entities.Preview;
import com.example.myfirstapp.main.Entities.Recipe;
import com.example.myfirstapp.main.Entities.User;

import java.util.*;

public class RecommendRecipe {
    /**
     * generates list of recommendations for user
     *
     * @param user    the user
     * @param recsNum the amount of recommendations wanted to generate
     * @return list of recommendations
     */

    public ArrayList<Preview> recommend(User user, int recsNum, GenreLibrary genreLibrary) {
        /**
         * If the generated list of recommendations from their favourite genre is less than required size recsNum,
         * the remainder of list is composed of recipes from their second best and so on.
         * The method takes in the String username of a user in USERSECURITY and the desired number of recommendations
         * This methods works correctly for 0 <= recsNum <= Constants.GENRELIBRARY.getAllRecipes("All").size()
         */
        HashMap<String, Double> genreWeights = user.getGenreWeights();
        ArrayList<String> sortedGenres = sortByWeight(genreWeights);
        System.out.println(sortedGenres);
        String bestGenre = sortedGenres.get(0);
        ArrayList<Preview> sortedRecipes = getSortedPreviewsFromGenre(bestGenre, genreLibrary);
        ArrayList<Preview> recommendations = new ArrayList<>();

        if (sortedRecipes.size() > recsNum) {
            for (int i = 0; i < recsNum; i++) {
                recommendations.add(sortedRecipes.get(i));
            }
            return recommendations;
        } else
            return recursiveRecommend(recommendations, sortedGenres, 0, recsNum, genreLibrary);
    }

    /**
     * helper method for recommend method
     *
     * @param recommends list of recommendations
     * @param genres     list of genres
     * @param genreNum   number of genres
     * @param rest       remaining number of recipes to be generated
     * @return list of recommendations
     */
    private ArrayList<Preview> recursiveRecommend
    (ArrayList<Preview> recommends, ArrayList<String> genres,
     int genreNum, int rest, GenreLibrary genreLibrary) {

        if (rest == 0) {
            return recommends;
        }

        ArrayList<Preview> previews = getSortedPreviewsFromGenre(genres.get(genreNum), genreLibrary);
        int numAdded = 0;
        for (Preview newRecommendation : previews) {
            if (!(recommends.contains(newRecommendation))) {
                recommends.add(newRecommendation);
                numAdded++;
            }
        }

        int remainder = rest - numAdded;
        if (genres.size() >= genreNum + 1) {
            ArrayList<Preview> previews2 = getSortedPreviewsFromGenre(genres.get(genreNum + 1), genreLibrary);

            if (remainder > previews2.size()) {
                return recursiveRecommend(recommends, genres, genreNum + 1, remainder, genreLibrary);
            }
            //else
            for (int i = 0; i < remainder; i++) {
                recommends.add(previews2.get(i));
            }
        }
        return recommends;

    }


    private ArrayList<Preview> getSortedPreviewsFromGenre(String genre, GenreLibrary genreLibrary) {
        /**
         * Returns list of previews for the given genre from highest to lowest rating
         * @param genre is the genre whose recipes are needed to be sorted
         * @return a list of recipe previews from highest to lowest rating
         */
        HashMap<Integer, Recipe> recipesWithID = genreLibrary.getAllRecipes(genre);
        ArrayList<Recipe> recipes = new ArrayList<>(recipesWithID.values());
        ArrayList<Preview> previews = new ArrayList<>();
        for (Recipe recipe : recipes) {
            previews.add(recipe.getPreview());
        }
        SortByRating sortByRating = new SortByRating(previews);
        return sortByRating.sort();
    }

    public ArrayList<String> sortByWeight(HashMap<String, Double> genreWeights) {
        /**
         * This method returns a list of the String keys (the genres) in the given mapping, from
         * highest to lowest Double value (their weight)
         * @param genreWeights is the mapping of genre to weights for a given User
         * @return a list of strings representing the genres from highest to lowest weight for the user
         */
        ArrayList<Double> repeatedWeights = new ArrayList<>(genreWeights.values());
        //given list might contain duplicates, so we create a new list without them
        ArrayList<Double> weights = new ArrayList<>();
        for (Double rw : repeatedWeights) {
            if (!weights.contains(rw)) {
                weights.add(rw);
            }
        }
        Collections.sort(weights);
        Collections.reverse(weights);
        ArrayList<String> sortedGenres = new ArrayList<>();
        for (Double weight : weights) {
            for (String genre : genreWeights.keySet()) {
                if (Objects.equals(genreWeights.get(genre), weight)) {
                    sortedGenres.add(genre);
                }
            }
        }
        return sortedGenres;
    }

}

