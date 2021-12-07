package com.example.myfirstapp.accountActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.myfirstapp.Globals;
import com.example.myfirstapp.Notification;
import com.example.myfirstapp.R;

public class EditNameActivity extends AppCompatActivity {
    /**
     * editName method  (creates a recipe entity from user)
     * //        Takes in the current View
     * //        Gets Users input
     * //        Sets the user's display name to the user's input
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_name);
        setTitle("Your Display Name");
    }

    public void editName(View view) {
        EditText editText = (EditText) findViewById(R.id.editNameText);
        String name = editText.getText().toString();
        if (name.isEmpty()) {
            Notification.displaySnackBar(findViewById(R.id.editNamePage), "Name cannot be empty");
            return;
        }
        Globals.setUser_name(name);
        finish();
    }
}