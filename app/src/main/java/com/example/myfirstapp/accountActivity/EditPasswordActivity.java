package com.example.myfirstapp.accountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;

public class EditPasswordActivity extends AppCompatActivity {
    /**
     * editPassword method  (creates a recipe entity from user)
     * //        Takes in the current View
     * //        Gets Users input
     * //        Sets the user's password to the user's input based on the regex
     * //        password must have at least 8 characters, a special character, number and an
     * //        uppercase letter and a lowercase letter
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);
        setTitle("Your Password");
    }

    public void editPassword(View view) {
        EditText editText = (EditText) findViewById(R.id.editPasswordText);
        String password = editText.getText().toString();
        if (password.isEmpty()) {
            Notification.displaySnackBar(findViewById(R.id.editPasswordPage), "Password cannot be empty");
            return;
        }
        if (password.matches("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$")) {
            Globals.setUser_password(password);
            finish();
        } else {
            Notification.displaySnackBar(findViewById(R.id.editPasswordPage), "Invalid password");
        }
    }
}