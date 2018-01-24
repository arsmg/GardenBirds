package com.example.android.gardenbirdsquiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class quiz_activity extends AppCompatActivity {

    private RadioGroup radioQuestion1;
    private RadioGroup radioQuestion2;
    private RadioGroup radioQuestion3;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private EditText editText1;
    private Button submitButton;

    private final String QUESTION1 = "question1";
    private final String QUESTION2 = "question2";
    private final String QUESTION3 = "question3";
    private final String QUESTION4_cb_1 = "checkbox1";
    private final String QUESTION4_cb_2 = "checkbox2";
    private final String QUESTION4_cb_3 = "checkbox3";
    private final String QUESTION4_cb_4 = "checkbox4";
    private final String QUESTION5 = "edittext1";
    private final String SUBMIT = "submit_btn";
    private final String BASESCORE = "score";




    int basescore = 0;
    int count = 0;
    int numberOfCheckboxesChecked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_quiz);

        radioQuestion1 = (RadioGroup) findViewById(R.id.firstQuestion);
        radioQuestion2 = (RadioGroup) findViewById(R.id.secondQuestion);
        radioQuestion3 = (RadioGroup) findViewById(R.id.thirdQuestion);
        checkBox1 = (CheckBox) findViewById(R.id.question4answer1);
        checkBox2 = (CheckBox) findViewById(R.id.question4answer2);
        checkBox3 = (CheckBox) findViewById(R.id.question4answer3);
        checkBox4 = (CheckBox) findViewById(R.id.question4answer4);
        editText1 = (EditText) findViewById(R.id.question5answer);
        submitButton = (Button) findViewById(R.id.submit);

        if (savedInstanceState != null) {
            int q1 = savedInstanceState.getInt(QUESTION1);
            int q2 = savedInstanceState.getInt(QUESTION2);
            int q3 = savedInstanceState.getInt(QUESTION3);
            boolean q4_1 = savedInstanceState.getBoolean(QUESTION4_cb_1);
            boolean q4_2 = savedInstanceState.getBoolean(QUESTION4_cb_2);
            boolean q4_3 = savedInstanceState.getBoolean(QUESTION4_cb_3);
            boolean q4_4 = savedInstanceState.getBoolean(QUESTION4_cb_4);
            int score = savedInstanceState.getInt(BASESCORE);
            radioQuestion1.check(q1);
            radioQuestion2.check(q2);
            radioQuestion3.check(q3);
            checkBox1.setChecked(q4_1);
            checkBox2.setChecked(q4_2);
            checkBox3.setChecked(q4_3);
            checkBox4.setChecked(q4_4);
        }



}


    // Setting the rules of the game to pop up as message
    public void info(View view) {
        AlertDialog.Builder altdial = new AlertDialog.Builder(quiz_activity.this);
        altdial.setMessage(getString(R.string.info_list1) + "\n" + "\n" + getString(R.string.info_list2)
                + "\n" + getString(R.string.info_list3) + "\n" + getString(R.string.info_list4)
                + "\n" + getString(R.string.info_list5) + "\n" + "\n" + getString(R.string.info_list6)
                + "\n" + "\n" + getString(R.string.info_list7)).setCancelable(false)
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

        public void submitAnswer(View view) {

        count++;


        int question1_id = radioQuestion1.getCheckedRadioButtonId();
        // I am checking if question 1 is answered
        if (question1_id == -1) {
            Toast.makeText(this, getString(R.string.blank_question), Toast.LENGTH_SHORT).show();
            basescore = 0;
            return;
        }

        // I am checking if the right answer to Question 1 was given
        RadioButton radioButton1 = (RadioButton) radioQuestion1.findViewById(question1_id);
        String answer1_text = (String) radioButton1.getText();
        if (answer1_text.equalsIgnoreCase(getString(R.string.Goldfinch))) {
            count++;
            basescore++;
        }

        // I am checking if the right answer to Question 2 was given
        int question2_id = radioQuestion2.getCheckedRadioButtonId();

        // I am checking if question 2 is answered
        if (question2_id == -1) {
            Toast.makeText(this, getString(R.string.blank_question), Toast.LENGTH_SHORT).show();
            basescore = 0;
            return;
        }
        RadioButton radioButton2 = (RadioButton) radioQuestion2.findViewById(question2_id);
        String answer2_text = (String) radioButton2.getText();
        if (answer2_text.equalsIgnoreCase(getString(R.string.Bluetit))) {
            count++;
            basescore++;
        }

        // I am checking if the right answer to Question 3 was given
        int question3_id = radioQuestion3.getCheckedRadioButtonId();

        // I am checking if question 3 is answered
        if (question3_id == -1) {
            Toast.makeText(this, getString(R.string.blank_question), Toast.LENGTH_SHORT).show();
            basescore = 0;
            return;
        }
        RadioButton radioButton3 = (RadioButton) radioQuestion3.findViewById(question3_id);
        String answer3_text = (String) radioButton3.getText();
        if (answer3_text.equalsIgnoreCase(getString(R.string.Bluetit))) {
            count++;
            basescore++;
        }


         //I am checking if the right answer to Question 4 was given
        if (checkBox1.isChecked() && checkBox3.isChecked()) {
            count++;
            basescore += 2;
        } else if (checkBox1.isChecked() || checkBox3.isChecked()) {
            count++;
            basescore++;
        }

        if (checkBox2.isChecked()){
            count++;
            basescore--;
        }

        if (checkBox4.isChecked()){
                count++;
                basescore--;
            }

        // I am checking if the right answer to Question 5 was given
        String edittexttest = editText1.getText().toString();

        if (edittexttest.equalsIgnoreCase(getString(R.string.editTextRightAnswer))) {
            count++;
            basescore += 3;
        }

        // Toast message with the score
        Toast.makeText(this, getString(R.string.result_summery) + basescore, Toast.LENGTH_SHORT).show();

        // Switch off Submit button after first submit
        if (count >= 1) {
            submitButton.setEnabled(false);
        }
    }


    // Setting a reset button with alert.dialog message
    public void reset(View view) {
        AlertDialog.Builder altdial = new AlertDialog.Builder(quiz_activity.this);
        altdial.setMessage(getString(R.string.java_reset_alert)).setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        // reset score
                        basescore = 0;
                        count = 0;

                        // reset radio buttons of questions 1-3
                        radioQuestion1.clearCheck();
                        radioQuestion2.clearCheck();
                        radioQuestion3.clearCheck();

                        // reset checkboxes of question 4
                        checkBox1.setChecked(false);
                        checkBox2.setChecked(false);
                        checkBox3.setChecked(false);
                        checkBox4.setChecked(false);

                        // clear text of question 5
                        editText1.setText("");

                        // enables submit button to be used again
                        submitButton.setEnabled(true);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = altdial.create();
        alert.setTitle(getString(R.string.title_reset_java));
        alert.show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(QUESTION1, radioQuestion1.getCheckedRadioButtonId());
        outState.putInt(QUESTION2, radioQuestion2.getCheckedRadioButtonId());
        outState.putInt(QUESTION3, radioQuestion3.getCheckedRadioButtonId());
        outState.putBoolean(QUESTION4_cb_1, checkBox1.isChecked());
        outState.putBoolean(QUESTION4_cb_2, checkBox2.isChecked());
        outState.putBoolean(QUESTION4_cb_3, checkBox3.isChecked());
        outState.putBoolean(QUESTION4_cb_4, checkBox4.isChecked());
    }


}