package com.example.myfirstapp.loginActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.R;
import com.example.myfirstapp.loginActivity.LoginActivity;
import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Controllers.UserRequestCreateLogin;

import java.util.ArrayList;
import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("Sign Up");
    }
    public void onSignUp(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        EditText usernameText = (EditText) findViewById(R.id.signupUsernameInput);
        EditText passwordText = (EditText) findViewById(R.id.signupPasswordInput);
        EditText confirmText = (EditText) findViewById(R.id.signupConfirmInput);
        EditText displayText = (EditText) findViewById(R.id.signupDisplayNameInput);
        EditText bioText = (EditText) findViewById(R.id.signupBioInput);
        EditText interestText = (EditText) findViewById(R.id.signupInterestInput);
        EditText ageText = (EditText) findViewById(R.id.signupAgeInput);

        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();
        String confirm = confirmText.getText().toString();
        String displayName = displayText.getText().toString();
        String bio = bioText.getText().toString();
        String interest = interestText.getText().toString();
        String age = ageText.getText().toString();

        // Creates user in UserSecurity
        if(!Constants.USERSECURITY.getUsernames().containsKey(username)){
            UserRequestCreateLogin CreateLoginController = new UserRequestCreateLogin();
            HashMap<String, Object> UserInfo = new HashMap<>();
            UserInfo.put("username", username);
            UserInfo.put("password", password);
            UserInfo.put("display_name", displayName);
            UserInfo.put("age", Integer.parseInt(age));
            UserInfo.put("biography", bio);
            ArrayList<String> interests = new ArrayList<>();
            interests.add(interest);
            UserInfo.put("interests", interests);
            // TODO Make User Choose interests using a tickbox?
            try {
                CreateLoginController.createUser(username, password, displayName,
                        Integer.parseInt(age),bio, interest);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(password.equals(confirm)){
            startActivity(intent);
        } else{
            // TODO: Put a display message
            System.out.println("Retype Password");
        }
        //startActivity(intent);
    }
}