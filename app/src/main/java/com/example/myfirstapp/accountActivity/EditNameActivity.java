package com.example.myfirstapp.accountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.MainActivity;
import com.example.myfirstapp.R;

public class EditNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);
        setTitle("Your Display Name");
    }
    public void editName(View view) {
        EditText editText = (EditText) findViewById(R.id.editNameText);
        String s = editText.getText().toString();
        Globals.setUser_name(s);
        finish();
    }
}