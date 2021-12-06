package com.example.myfirstapp.loginActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.MainActivity;
import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;
import com.example.myfirstapp.main.Gateways.Constants;
import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Gateways.Read;

public class LoginActivity extends AppCompatActivity {
    /**
     * //        The login page were the user logins
     * //
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Login");
        Read read = new Read();
        read.populateGenreLibrary(genreLibrary -> Constants.GENRELIBRARY = genreLibrary);
        read.populateUserSecurity(userSecurity -> Constants.USERSECURITY = userSecurity);
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

        ConstraintLayout constraintLayout = findViewById(R.id.loginPage);

        // ensure user is in UserSecurity
        if (Constants.USERSECURITY.getUsernames().containsKey(username)) {
            User user = Constants.USERSECURITY.getUserByID(username);
            if (password.equals(user.getPassword())) {
                Globals.setUser(user);
                startActivity(intent);
            } else {
                Notification.displaySnackBar(constraintLayout, "Incorrect Password!", "top");
            }
        } else {
            Notification.displaySnackBar(constraintLayout, "Incorrect Username", "top");
        }
    }
}