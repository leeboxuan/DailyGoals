package com.weebly.leeboxuan.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etReflect;
    Button btnok;
    RadioGroup rg1, rg2, rg3;
    int selectedid1, selectedid2, selectedid3;
    RadioButton rb1, rb2, rb3;
    String multiline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnok = (Button) findViewById(R.id.button);
        etReflect = (EditText) findViewById(R.id.editText2);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        rg3 = (RadioGroup) findViewById(R.id.radioGroup3);



        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedid1 = rg1.getCheckedRadioButtonId();
                selectedid2 = rg2.getCheckedRadioButtonId();
                selectedid3 = rg3.getCheckedRadioButtonId();

                rb1 = (RadioButton) findViewById(selectedid1);
                rb2 = (RadioButton) findViewById(selectedid2);
                rb3 = (RadioButton) findViewById(selectedid3);
                multiline = etReflect.getText().toString();

                String[] info = {rb1.getText().toString(), rb2.getText().toString(), rb3.getText().toString(), multiline };
                Intent i = new Intent(MainActivity.this, Summary.class);
                i.putExtra("info", info);
                startActivity(i);
            }
        });







    }
    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("selectedid1", selectedid1);        // Saving integer
        editor.putInt("selectedid2", selectedid2);
        editor.putInt("selectedid3", selectedid3);        // Saving integer
        editor.putString("text", multiline);        // Saving integer

        // Save the changes in SharedPreferences
        editor.commit(); // commit changes


    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);

        int id1new =  pref.getInt("selectedid1", 0);             // getting Integer
        int id2new = pref.getInt("selectedid2", 0);             // getting Integer
        int id3new =  pref.getInt("selectedid3", 0);             // getting Integer

        String newtext = pref.getString("text", "");
        etReflect.setText(newtext);
        rg1.check(id1new);
        rg2.check(id2new);
        rg3.check(id3new);



    }

    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.putInt("selectedid1", selectedid1);        // Saving integer
        editor.putInt("selectedid2", selectedid2);
        editor.putInt("selectedid3", selectedid3);        // Saving integer
        editor.putString("text", multiline);        // Saving integer

        // Save the changes in SharedPreferences
        editor.commit(); // commit changes


    }
}

