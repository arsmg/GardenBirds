package com.example.android.gardenbirdsquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the View that shows the Picture Quiz category
        TextView pictures = (TextView) findViewById(R.id.picturesQuiz);

        // Set a click listener on that View
        pictures.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, ByPicture.class);
                startActivity(numbersIntent);
            }
        });


        // Find the View that shows the Songs Quiz category
        TextView songs = (TextView) findViewById(R.id.songsQuiz);

        // Set a click listener on that View
        songs.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, BySong.class);
                startActivity(numbersIntent);
            }
        });
    }
}
