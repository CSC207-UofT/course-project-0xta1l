package com.example.myfirstapp.loginActivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.MainActivity;
import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Constants.Constants;
import com.example.myfirstapp.main.Entities.User;
import com.google.android.material.snackbar.Snackbar;

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
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onLogin(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText usernameText = (EditText) findViewById(R.id.loginUsernameInput);
        EditText passwordText = (EditText) findViewById(R.id.loginPasswordInput);
        String username = usernameText.getText().toString();
        String password = passwordText.getText().toString();

        ConstraintLayout constraintLayout = findViewById(R.id.loginPage);

        // ensure user is in UserSecurity
        if (Constants.USERSECURITY.getUsernames().containsKey(username)){
            User user = Constants.USERSECURITY.getUserByID(username);
            if (password.equals(user.getPassword())){
                Globals.setUser(user);
                startActivity(intent);
            } else {
                Notification.displaySnackBar(constraintLayout, "Wrong password!", "top");
            }
        } else {
             Notification.displaySnackBar(constraintLayout, "Wrong username", "top");
        }
    }
}