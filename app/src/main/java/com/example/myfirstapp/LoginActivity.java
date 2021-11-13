package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.User;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
    }
    public void onSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
    public void onLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText usernameText = (EditText) findViewById(R.id.loginUsernameInput);
        EditText passwordText = (EditText) findViewById(R.id.loginPasswordInput);
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        // ensure user is in UserSecurity
        if (Constants.USERSECURITY.getUsernames().containsKey(username)){
            User user = Constants.USERSECURITY.getUserByID(username);
            if (password.equals(user.getPassword())){
                Globals.setUser_username(username);
                Globals.setUser_password(password);
                Globals.setUser_name(user.getDisplayName());
                Globals.setUser_bio(user.getBiography());
                Globals.setUserInterests(user.getInterests());
                Globals.setUserAge(user.getAge());
                startActivity(intent);
            }
        }

        //TODO Create a display for these error messages

        //startActivity(intent);
    }
}