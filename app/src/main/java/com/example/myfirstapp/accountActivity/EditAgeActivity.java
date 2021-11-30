package com.example.myfirstapp.accountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;

public class EditAgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_age);
        setTitle("Your Age");
    }
    public void editAge(View view) {
        EditText editText = (EditText) findViewById(R.id.edit_age_text);
        String s = editText.getText().toString();
        if(s.isEmpty()) {
            Notification.displaySnackBar(findViewById(R.id.editAgePage),"Age cannot be empty");
            return;
        }
        int i = Integer.parseInt(s);
        Globals.setUserAge(i);
        finish();
    }
}