//package UseCases;
//import Entities.Recipe;
//import Entities.Review;
//import Constants.Constants;
//
//import java.util.ArrayList;
//
//public class RecipeCreate {
//    //CreateRecipeFromUser method  (creates a recipe entity from user)
//    //        Takes in a list of recipe attributes
//    //        Creates recipe entity and adds it to the GenreLibrary
//    //        Outputs the created recipe
//
//    public Recipe CreateRecipeFromUser(String instructions, String ingredients, ArrayList<String> genres, String name,
//                                       int rating, int ID, ArrayList<Review> RecipeReviews, String image,
//                                       String descriptions ){
//
//        Recipe recipe = new Recipe(instructions,ingredients, genres, name, rating, ID, image, descriptions);
//        for(String genre: genres){
//            Constants.GENRELIBRARY.addRecipes(genre, recipe);
//        }
//        return recipe;
//    }
//}