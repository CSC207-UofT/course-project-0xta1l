package com.example.myfirstapp.accountActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Gateways.Constants;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private boolean[] selectedInterest;
    private ArrayList<Integer> interestList = new ArrayList<>();
    // Getting all genres
    private ArrayList<String> genres = Constants.GENRELIBRARY.getUploadGenres();
    private String[] genreList = new String[genres.size()];

    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     * <p>
     * The Account Page where the user can change their personal information
     */


    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        genreList = genres.toArray(genreList); // List of genre (strings)
        TextView interestText = (TextView) v.findViewById(R.id.account_interest);
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
                        interestText.setText("Interest: " + stringBuilder.toString());
                        ArrayList<String> uploadGenres = new ArrayList<>();
                        for (int m : interestList) {
                            uploadGenres.add(genreList[m]);
                        }
                        Globals.setUserInterests(uploadGenres);
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

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        View v = getView();
        // Load and use views afterwards
        TextView tv1 = v.findViewById(R.id.account_name);
        TextView tv2 = v.findViewById(R.id.account_bio);
        TextView tv3 = v.findViewById(R.id.account_interest);
        TextView tv4 = v.findViewById(R.id.account_username);
        TextView tv5 = v.findViewById(R.id.account_password);
        TextView tv6 = (TextView) v.findViewById(R.id.account_age);

        tv1.setText("Name: " + Globals.getUser_name());
        tv2.setText("Bio: " + Globals.getUser_bio());
        tv3.setText("Interest: " + Globals.getUserStringInterests());
        tv4.setText("Username: " + Globals.getUser_username());
        tv5.setText("Password: " + Globals.getUser_password());
        tv6.setText("Age: " + Globals.getUserAge());

        ImageButton edit_name_button = v.findViewById(R.id.account_name_edit);
        edit_name_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getContext();
                Intent intent = new Intent(context, EditNameActivity.class);
                startActivity(intent);
            }
        });

        ImageButton edit_bio_button = v.findViewById(R.id.account_bio_edit);
        edit_bio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditBioActivity.class);
                startActivity(intent);
            }
        });

        ImageButton edit_username_button = v.findViewById(R.id.account_username_edit);
        edit_username_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditUsernameActivity.class);
                startActivity(intent);
            }
        });
        Button logoutButton = v.findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        ImageButton passwordButton = v.findViewById(R.id.account_password_edit);
        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditPasswordActivity.class);
                startActivity(intent);
            }
        });

        ImageButton ageButton = v.findViewById(R.id.account_age_edit);
        ageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EditAgeActivity.class);
                startActivity(intent);
            }
        });

        //TODO Add Interest Activity


    }

}