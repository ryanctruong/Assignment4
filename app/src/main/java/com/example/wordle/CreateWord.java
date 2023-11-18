package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateWord extends AppCompatActivity {

    EditText enterWord;
    Button add_word, go_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_word);

        enterWord = findViewById(R.id.word_box);

        add_word = findViewById(R.id.add_word_button2);
        go_back = findViewById(R.id.go_back_button);

        add_word.setOnClickListener(addWord);
        go_back.setOnClickListener(goBack);
    }

    View.OnClickListener addWord = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String word = enterWord.getText().toString();
            if (checkWord(word)) {
                Toast.makeText(getApplicationContext(), "Word Added!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Invalid Word!", Toast.LENGTH_LONG).show();
            }
        }
    };


    View.OnClickListener goBack = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    };

    public boolean checkWord(String word) {
        return word != null && word.length() == 5;
    }
}