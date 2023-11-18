package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button submitButton, restartButton, clearButton, addWordButton;
    EditText editText;

    FirebaseDatabase fb;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submit_button);
        restartButton = findViewById(R.id.restart_button);
        clearButton = findViewById(R.id.clear_button);
        addWordButton = findViewById(R.id.add_word_button);
        editText = findViewById(R.id.editText);

        fb = FirebaseDatabase.getInstance();
        db = fb.getReference();


        submitButton.setOnClickListener(submit_listener);
        restartButton.setOnClickListener(restart_listener);
        clearButton.setOnClickListener(clear_listener);
        addWordButton.setOnClickListener(add_word_listener);

    }

    View.OnClickListener submit_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Is this the word?", Toast.LENGTH_LONG).show();
        }
    };

    View.OnClickListener restart_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Game has been Restarted", Toast.LENGTH_LONG).show();
        }
    };
    View.OnClickListener clear_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "Gusses Cleared", Toast.LENGTH_LONG).show();
        }
    };
    View.OnClickListener add_word_listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), CreateWord.class);
            startActivity(intent);
        }
    };
}