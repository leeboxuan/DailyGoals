package com.weebly.leeboxuan.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {
String message = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");
        TextView tv = (TextView) findViewById(R.id.textView7);
        message += "Read up on mateirals before class: " + info[0];
        message += "\nArrive on time so as not to miss important part of the lesson: " + info[1];
        message += "\n Attempt the problem myself: " + info[2];
        message += "\n Reflection: " + info[3];
        tv.setText(message);

        Button btndone = (Button) findViewById(R.id.buttonbtndone);
        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
