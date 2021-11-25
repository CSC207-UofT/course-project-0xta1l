package com.example.myfirstapp.accountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;

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
        Globals.setUser_password(s);
        finish();
    }
}