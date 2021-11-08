package UseCases;

import Entities.Recipe;

import java.util.ArrayList;

public class SortByRating extends SortRecipes{

    public SortByRating(ArrayList<Recipe> previews) {
        super(previews);
    }

    @Override
    public ArrayList<Recipe> sort(){
        ArrayList<Recipe> lst = alphabet();
            return sortByRating(lst);
        }

    public ArrayList<Recipe> sortByRating(ArrayList<Recipe> lst){
        ArrayList<Recipe> grand_lst = new ArrayList<Recipe>();
        ArrayList<Recipe> lst_1 = new ArrayList<Recipe>();
        ArrayList<Recipe> lst_2 = new ArrayList<Recipe>();
        ArrayList<Recipe> lst_3 = new ArrayList<Recipe>();
        ArrayList<Recipe> lst_4 = new ArrayList<Recipe>();
        ArrayList<Recipe> lst_5 = new ArrayList<Recipe>();

        for (Recipe preview : lst) {
            helperPutRecipeInRatingList(preview, lst_1, lst_2, lst_3, lst_4, lst_5);
        }

        grand_lst.addAll(lst_5);
        grand_lst.addAll(lst_4);
        grand_lst.addAll(lst_3);
        grand_lst.addAll(lst_2);
        grand_lst.addAll(lst_1);

        return grand_lst;
    }

    private void helperPutRecipeInRatingList(Recipe preview, ArrayList<Recipe> lst_1, ArrayList<Recipe> lst_2,
                                             ArrayList<Recipe> lst_3, ArrayList<Recipe> lst_4,
                                             ArrayList<Recipe> lst_5) {
        helperDuplicate(preview, lst_1, lst_2, lst_3, lst_4, lst_5);
    }

    static void helperDuplicate(Recipe preview, ArrayList<Recipe> lst_1, ArrayList<Recipe> lst_2,
                                ArrayList<Recipe> lst_3, ArrayList<Recipe> lst_4, ArrayList<Recipe> lst_5) {
        int rating = preview.getRating();
        if (rating == 1) {
            lst_1.add(preview);
        } else if (rating == 2) {
            lst_2.add(preview);
        } else if (rating == 3) {
            lst_3.add(preview);
        } else if (rating == 4) {
            lst_4.add(preview);
        } else if (rating == 5) {
            lst_5.add(preview);
        }
    }
}
