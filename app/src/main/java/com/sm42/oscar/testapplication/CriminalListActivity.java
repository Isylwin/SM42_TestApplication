package com.sm42.oscar.testapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Oscar on 16-Mar-17.
 */

public class CriminalListActivity extends AppCompatActivity {

    public static final String CRIMINAL_NAME = "criminalName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criminallist);

        ListView listview = (ListView) findViewById(R.id.criminalList);
        final String[] criminals = getResources().getStringArray(R.array.names);
        listview.setAdapter(
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        criminals
                )
        );

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String name = criminals[position];
                Intent intent = new Intent(CriminalListActivity.this, MainActivity.class);
                intent.putExtra(CRIMINAL_NAME, name);

                CriminalListActivity.this.startActivity(intent);
            }
        });


    }
}
