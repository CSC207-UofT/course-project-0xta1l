package com.example.myfirstapp.accountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.R;

public class EditBioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bio);
        setTitle("Your Biography");

    }
    public void editBio(View view) {
        EditText editText = findViewById(R.id.edit_bio_text);
        String s = editText.getText().toString();
        Globals.setUser_bio(s);
        finish();
    }
}