package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.okBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg1 = findViewById(R.id.rg1);
                RadioGroup rg2 = findViewById(R.id.rg2);
                RadioGroup rg3 = findViewById(R.id.rg3);

                int selected1 = rg1.getCheckedRadioButtonId();
                int selected2 = rg2.getCheckedRadioButtonId();
                int selected3 = rg3.getCheckedRadioButtonId();

                RadioButton rb1 = findViewById(selected1);
                RadioButton rb2 = findViewById(selected2);
                RadioButton rb3 = findViewById(selected3);

                EditText etGoal = findViewById(R.id.editTextGoal);

                Intent i = new Intent(MainActivity.this, Main2Activity.class);

                i.putExtra("goal1", rb1.getText());
                i.putExtra("goal2", rb2.getText());
                i.putExtra("goal3", rb3.getText());
                i.putExtra("goal4", etGoal.getText().toString());

                startActivity(i);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        RadioGroup rg1 = findViewById(R.id.rg1);
        RadioGroup rg2 = findViewById(R.id.rg2);
        RadioGroup rg3 = findViewById(R.id.rg3);
        EditText etGoal = findViewById(R.id.editTextGoal);

        int selected1 = rg1.getCheckedRadioButtonId();
        int selected2 = rg2.getCheckedRadioButtonId();
        int selected3 = rg3.getCheckedRadioButtonId();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putInt("goal1", selected1);
        prefEdit.putInt("goal2", selected2);
        prefEdit.putInt("goal3", selected3);
        prefEdit.putString("goal4", etGoal.getText().toString());

        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);

        int goal1 = prefs.getInt("goal1", 1);
        int goal2 = prefs.getInt("goal2", 1);
        int goal3 = prefs.getInt("goal3", 1);
        String goal4 = prefs.getString("goal4", "");

        RadioGroup rg1 = findViewById(R.id.rg1);
        RadioGroup rg2 = findViewById(R.id.rg2);
        RadioGroup rg3 = findViewById(R.id.rg3);
        EditText etGoal = findViewById(R.id.editTextGoal);

        rg1.check(goal1);
        rg2.check(goal2);
        rg3.check(goal3);
        etGoal.setText(goal4 + "");
    }
}
