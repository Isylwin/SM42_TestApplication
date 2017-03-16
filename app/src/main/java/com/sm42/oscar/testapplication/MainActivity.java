package com.sm42.oscar.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String name = getIntent().getStringExtra(CriminalListActivity.CRIMINAL_NAME);
        TextView nameView = (TextView) findViewById(R.id.details_name);
        nameView.setText(name);

        Button button_report = (Button) findViewById(R.id.button_report);
        button_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReportActivity.class);
                startActivity(intent);
            }
        });
    }
}
