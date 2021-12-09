package com.example.myfirstapp.fragments;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.MainActivity;
import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Controllers.UserRequestCreateRecipe;
import com.example.myfirstapp.main.Gateways.Constants;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UploadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UploadFragment extends Fragment {


    private boolean[] selectedInterest;
    private ArrayList<Integer> interestList = new ArrayList<>();
    // Getting all genres
    private ArrayList<String> genres = Constants.GENRELIBRARY.getUploadGenres();
    private String[] genreList = new String[genres.size()];

    public UploadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UploadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UploadFragment newInstance(String param1, String param2) {
        UploadFragment fragment = new UploadFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_upload, container, false);

        genreList = genres.toArray(genreList); // List of genre (strings)
        TextView interestText = (TextView) v.findViewById(R.id.uploadGenreInput);
        selectedInterest = new boolean[genreList.length];
        String[] finalGenreList = genreList;
        interestText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

                // set title
                builder.setTitle("Select Genres");

                // set dialog non cancelable
                builder.setCancelable(false);

                builder.setMultiChoiceItems(finalGenreList, selectedInterest, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        // check condition
                        if (b) {
                            // when checkbox selected
                            // Add position  in lang list
                            interestList.add(i);
                            // Sort array list
                            Collections.sort(interestList);
                        } else {
                            // when checkbox unselected
                            // Remove position from langList
                            interestList.remove(Integer.valueOf(i));
                        }
                    }
                });

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Initialize string builder
                        StringBuilder stringBuilder = new StringBuilder();
                        // use for loop
                        for (int j = 0; j < interestList.size(); j++) {
                            // concat array value
                            stringBuilder.append(finalGenreList[interestList.get(j)]);
                            // check condition
                            if (j != interestList.size() - 1) {
                                // When j value  not equal
                                // to lang list size - 1
                                // add comma
                                stringBuilder.append(", ");
                            }
                        }
                        // set text on textView
                        interestText.setText(stringBuilder.toString());
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // dismiss dialog
                        dialogInterface.dismiss();
                    }
                });
                builder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // use for loop
                        for (int j = 0; j < selectedInterest.length; j++) {
                            // remove all selection
                            selectedInterest[j] = false;
                            // clear interest list
                            interestList.clear();
                            // clear text view value
                            interestText.setText("");
                        }
                    }
                });
                // show dialog
                builder.show();
            }
        });

        Button b = v.findViewById(R.id.uploadButtonSubmit);
        UploadFragment that = this;
        b.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v_useless) {
                that.onSubmit(v);
            }
        });

        return v;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onSubmit(View view) {
        EditText uploadTextName = (EditText) view.findViewById(R.id.uploadTextName);
        EditText uploadTextInstructions = (EditText) view.findViewById(R.id.uploadTextInstructions);
        EditText uploadTextIngredients = (EditText) view.findViewById(R.id.uploadTextIngredients);
        EditText uploadTextDescription = (EditText) view.findViewById(R.id.uploadTextDescription);
        EditText uploadTextImage = (EditText) view.findViewById(R.id.uploadTextImage);
        EditText uploadTextPreptime = (EditText) view.findViewById(R.id.uploadTextPreptime);

        String name = uploadTextName.getText().toString();
        String instructions = uploadTextInstructions.getText().toString();
        String ingredients = uploadTextIngredients.getText().toString();
        String description = uploadTextDescription.getText().toString();
        String image = uploadTextImage.getText().toString();
        String preptime_str = uploadTextPreptime.getText().toString();


        ArrayList<String> uploadGenres = new ArrayList<>();
        for (int genre : interestList) {
            uploadGenres.add(genreList[genre]);
        }

        if (name.isEmpty() || instructions.isEmpty() || ingredients.isEmpty()
                || description.isEmpty() || image.isEmpty() || preptime_str.isEmpty()) {
            Notification.displaySnackBar(getView().findViewById(R.id.UploadPage), "Please fill in everything");
            return;
        } else {
            int id = Constants.GENRELIBRARY.getNewId();
            UserRequestCreateRecipe recipeController = new UserRequestCreateRecipe();

            recipeController.recipe(
                    Globals.getUser_username(),
                    instructions,
                    ingredients,
                    uploadGenres,
                    name,
                    "0",
                    id,
                    image,
                    description,
                    preptime_str
            );
            MainActivity main = (MainActivity) getActivity();
            main.initFragment(R.id.menu_home);
        }


    }
}