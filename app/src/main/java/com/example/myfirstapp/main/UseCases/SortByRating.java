package com.example.myfirstapp.main.UseCases;

import com.example.myfirstapp.main.Entities.Preview;

import java.util.ArrayList;

public class SortByRating extends SortRecipes {
    /**
     * Sorts recipe ratings by rating
     *
     * @param previews is previews of the recipes
     * @return array list of sorted previews
     */
    public SortByRating(ArrayList<Preview> previews) {
        super(previews);
    }

    @Override
    public ArrayList<Preview> sort() {
        ArrayList<Preview> lst = alphabet();
        return sortByRating(lst);
    }

    /**
     * Sorts list of previews ratings by rating
     *
     * @param lst is previews of the recipes
     * @return array list of sorted previews
     */
    public ArrayList<Preview> sortByRating(ArrayList<Preview> lst) {
        ArrayList<Preview> grand_lst = new ArrayList<Preview>();
        ArrayList<Preview> lst_1 = new ArrayList<Preview>();
        ArrayList<Preview> lst_2 = new ArrayList<Preview>();
        ArrayList<Preview> lst_3 = new ArrayList<Preview>();
        ArrayList<Preview> lst_4 = new ArrayList<Preview>();
        ArrayList<Preview> lst_5 = new ArrayList<Preview>();

        for (Preview preview : lst) {
            helperPutRecipeInRatingList(preview, lst_1, lst_2, lst_3, lst_4, lst_5);
        }

        grand_lst.addAll(lst_5);
        grand_lst.addAll(lst_4);
        grand_lst.addAll(lst_3);
        grand_lst.addAll(lst_2);
        grand_lst.addAll(lst_1);

        return grand_lst;
    }

    private void helperPutRecipeInRatingList(Preview preview, ArrayList<Preview> lst_1, ArrayList<Preview> lst_2,
                                             ArrayList<Preview> lst_3, ArrayList<Preview> lst_4,
                                             ArrayList<Preview> lst_5) {
        helperDuplicate(preview, lst_1, lst_2, lst_3, lst_4, lst_5);
    }

    static void helperDuplicate(Preview preview, ArrayList<Preview> lst_1, ArrayList<Preview> lst_2,
                                ArrayList<Preview> lst_3, ArrayList<Preview> lst_4, ArrayList<Preview> lst_5) {
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
