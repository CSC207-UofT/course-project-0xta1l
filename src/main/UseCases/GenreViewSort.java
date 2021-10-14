package UseCases;

import Entities.GenreLibrary;
import Entities.User;
import java.util.Collections;
import java.util.ArrayList;

//genresViewList method (takes in userID)
//        Calls GenreLibrary.getAllGenres() to get list of string genres
//        Sorts the strings
//        If userID.getInterests() is empty:
//        Sort strings into alphabetical order
//        If userID.getInterests() is NOT empty:
//        Put strings in Interests first in list, all others in alphabetical order
//        Outputs the list of genre strings
//
//        genreRecipeSort method  (sorts the recipes in a genre)
//        Takes in a list of recipe previews, and a sorting key (string either “rating” or “”)
//        Rating (High to low)
//        Alphabetical (default)
//        Sorts list of recipe previews according to key
//        Outputs rearranged list

class GenreViewSort{

    public ArrayList<String> genresViewList(User user){
        GenreLibrary genrelibrary = new GenreLibrary();
        ArrayList<String> genres = genrelibrary.getAllGenres();
        if (user.getInterests().isEmpty()) {
            Collections.sort(genres);
        } else {
            genres.removeIf(genre -> user.getInterests().contains(genre));
            Collections.sort(genres);
            for (String interest : user.getInterests()) {
                genres.add(0, interest);
            }
        }
        return genres;
    }

}
