package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();

        String goal1 = i.getStringExtra("goal1");
        String goal2 = i.getStringExtra("goal2");
        String goal3 = i.getStringExtra("goal3");
        String goal4 = i.getStringExtra("goal4");

        TextView tv1 = findViewById(R.id.textView);
        TextView tv2 = findViewById(R.id.textView2);
        TextView tv3 = findViewById(R.id.textView3);
        TextView tv4 = findViewById(R.id.textView4);

        tv1.setText("Read up on materials before class: \n" + goal1);
        tv2.setText("Arrive on time so as not to miss important part of the lesson: \n" + goal2);
        tv3.setText("Attempt the problem myself: \n" + goal3);
        tv4.setText("Reflection: \n" + goal4);

        Button close = findViewById(R.id.closeBtn);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
