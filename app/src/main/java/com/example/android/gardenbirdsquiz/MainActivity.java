package com.example.android.gardenbirdsquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
                Intent numbersIntent = new Intent(MainActivity.this, quiz_activity.class);
                startActivity(numbersIntent);
            }
        });


    }

    // Setting the rules of the game to pop up as message
    public void info(View view) {
        AlertDialog.Builder altdial = new AlertDialog.Builder(MainActivity.this);
        altdial.setMessage(getString(R.string.info_list1) + "\n" + "\n"+ getString(R.string.info_list2)
                + "\n"+ getString(R.string.info_list3)+ "\n"+ getString(R.string.info_list4)
                + "\n"+ getString(R.string.info_list5)+ "\n"+ "\n"+ getString(R.string.info_list6)
                + "\n"+ "\n" + getString(R.string.info_list7)).setCancelable(false)
                .setPositiveButton("", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = altdial.create();
        alert.setTitle(getString(R.string.title_rules_java));
        alert.show();
    }
}

