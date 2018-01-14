package com.example.android.gardenbirdsquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ByPicture extends AppCompatActivity {

    int basescore = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_picture);
    }


    public void submitAnswer (View view) {
        RadioButton radioButton1 = findViewById(R.id.radiobutton1);
        boolean isRadioButton1Checked = radioButton1.isChecked();

        RadioButton radioButton2 = findViewById(R.id.radiobutton2);
        boolean isRadioButton2Checked = radioButton2.isChecked();

        RadioButton radioButton3 = findViewById(R.id.radiobutton3);
        boolean isRadioButton3Checked = radioButton3.isChecked();

        RadioButton radioButton4 = findViewById(R.id.radiobutton4);
        boolean isRadioButton4Checked = radioButton4.isChecked();

        int score = calculateScore(isRadioButton1Checked, isRadioButton2Checked,
                isRadioButton3Checked, isRadioButton4Checked);

        String scoreMessage = scoreSummery(score);

        if(count == 1) {
            displayMessage(scoreMessage);}
            else{
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
            }
        }


    private int calculateScore(boolean radioButton1Checked, boolean radioButton2Checked,
                           boolean radioButton3Checked, boolean radioButton4Checked){

        if(radioButton1Checked) {
            count++;
            basescore++;
        }
        if(radioButton2Checked){
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
        }
        if(radioButton3Checked){
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
        }
        if(radioButton4Checked){
            Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();
        }
        return (basescore);
    }

    private String scoreSummery (int score) {
            String scoreMessage = "Customer" + score;
            return scoreMessage;
    }


    private void displayMessage(String scoreMessage) {
        TextView orderSummeryTextView = (TextView) findViewById(R.id.score);
        orderSummeryTextView.setText(scoreMessage);
    }

}