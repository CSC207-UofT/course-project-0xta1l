package com.example.myfirstapp.loginActivity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Controllers.UserRequestCreateLogin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
    /**
     * //        The page where user is able to sign up
     * //
     */

    private boolean[] selectedInterest;
    private ArrayList<Integer> interestList = new ArrayList<>();
    // Getting all genres
    private ArrayList<String> genres = Constants.GENRELIBRARY.getAllGenres();
    private String[] genreList = new String[genres.size()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");

        genreList = genres.toArray(genreList); // List of genre (strings)
        TextView interestText = (TextView) findViewById(R.id.signupInterestInput);
        selectedInterest = new boolean[genreList.length];
        String[] finalGenreList = genreList;
        interestText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize alert dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(SignUpActivity.this);

                // set title
                builder.setTitle("Select Interest");

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


    }

    public void onSignUp(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        EditText usernameText = (EditText) findViewById(R.id.signupUsernameInput);
        EditText passwordText = (EditText) findViewById(R.id.signupPasswordInput);
        EditText confirmText = (EditText) findViewById(R.id.signupConfirmInput);
        EditText displayText = (EditText) findViewById(R.id.signupDisplayNameInput);
        EditText bioText = (EditText) findViewById(R.id.signupBioInput);
        EditText ageText = (EditText) findViewById(R.id.signupAgeInput);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        String confirm = confirmText.getText().toString();
        String displayName = displayText.getText().toString();
        String bio = bioText.getText().toString();
        String age = ageText.getText().toString();

        // Creates user in UserSecurity
        if (!Constants.USERSECURITY.getUsernames().containsKey(username)) {
            UserRequestCreateLogin CreateLoginController = new UserRequestCreateLogin();
            HashMap<String, Object> UserInfo = new HashMap<>();
            UserInfo.put("username", username);
            UserInfo.put("password", password);
            UserInfo.put("display_name", displayName);
            UserInfo.put("age", Integer.parseInt(age));
            UserInfo.put("biography", bio);
            // Adding all interest from checkbox
            ArrayList<String> interests = new ArrayList<>();
            for (int i : interestList) {
                interests.add(genreList[i]);
            }
            UserInfo.put("interests", interests);
            try {
                CreateLoginController.createUser(username, password, displayName,
                        Integer.parseInt(age), bio, interests);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (password.equals(confirm)) {
            startActivity(intent);
        } else {
            Notification.displaySnackBar(view.findViewById(R.id.signupPage), "Retype Password");
        }
        //startActivity(intent);
    }
}