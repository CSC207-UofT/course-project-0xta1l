package com.example.myfirstapp.accountActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;
import com.google.android.material.snackbar.Snackbar;

public class EditPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);
        setTitle("Your Password");
    }

    public void editPassword(View view) {
        EditText editText = (EditText) findViewById(R.id.editPasswordText);
        String s = editText.getText().toString();
        if(s.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$"))
        {Globals.setUser_password(s);
            finish();}
        else{
            System.out.println("wrong password :(");
            //TODO add snackbar
        }
    }
}