package com.example.android.gardenbirdsquiz;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ByPicture extends AppCompatActivity {

    private RadioGroup radioQuestion1;
    private RadioGroup radioQuestion2;
    private RadioGroup radioQuestion3;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private EditText editText1;
    private Button submitButton;
    private Button resetButton;


    int basescore = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_picture);

        radioQuestion1 = (RadioGroup) findViewById(R.id.firstQuestion);
        radioQuestion2 = (RadioGroup) findViewById(R.id.secondQuestion);
        radioQuestion3 = (RadioGroup) findViewById(R.id.thirdQuestion);
        checkBox1 = (CheckBox) findViewById(R.id.question4answer1);
        checkBox2 = (CheckBox) findViewById(R.id.question4answer2);
        checkBox3 = (CheckBox) findViewById(R.id.question4answer3);
        checkBox4 = (CheckBox) findViewById(R.id.question4answer4);
        editText1 = (EditText) findViewById(R.id.question5answer);
        submitButton = (Button) findViewById(R.id.submit);

    }


    public void submitAnswer (View view) {

        count++;


        int question1_id = radioQuestion1.getCheckedRadioButtonId();

        // I am checking if question 1 is answered
        if (question1_id == -1) {
            basescore = 0;
            return;
        }

        // I am checking if the right answer to Question 1 was given
        RadioButton radioButton1 = (RadioButton) radioQuestion1.findViewById(question1_id);
        String answer1_text = (String) radioButton1.getText();
        if (answer1_text.equalsIgnoreCase(getString(R.string.Goldfinch))) {
            basescore++;
        }

        // I am checking if the right answer to Question 2 was given
        int question2_id = radioQuestion1.getCheckedRadioButtonId();

        // I am checking if question 2 is answered
        if (question2_id == -1) {
           basescore = 0;
            return;
        }
        RadioButton radioButton2 = (RadioButton) radioQuestion2.findViewById(question2_id);
        String answer2_text = (String) radioButton1.getText();
        if (answer1_text.equalsIgnoreCase(getString(R.string.Bluetit))) {
            basescore++;
        }

        // I am checking if the right answer to Question 3 was given
        int question3_id = radioQuestion1.getCheckedRadioButtonId();

        // I am checking if question 3 is answered
        if (question3_id == -1) {
            basescore = 0;
            return;
        }
        RadioButton radioButton3 = (RadioButton) radioQuestion3.findViewById(question3_id);
        String answer3_text = (String) radioButton1.getText();
        if (answer1_text.equalsIgnoreCase(getString(R.string.Bluetit))) {
            basescore++;
        }

        // I am checking if the right answer to Question 4 was given
        if (checkBox1.isChecked() && checkBox3.isChecked()) {
            basescore += 2;
        } else if (checkBox1.isChecked() || checkBox3.isChecked()) {
            basescore++;
        }

        // Toast message with the score
        Toast.makeText(this, getString(R.string.result_summery) + basescore, Toast.LENGTH_SHORT).show();

        // Switch off Submit button after first submit
        if (count >= 1) {
            submitButton.setEnabled(false);
        }
    }

}