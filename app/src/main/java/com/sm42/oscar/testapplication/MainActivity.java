package com.sm42.oscar.testapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity {

    public static final String POSITION = "criminalPosition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Some example code below on how to use CriminalProvider:
        CriminalProvider criminalProvider = new CriminalProvider(getApplicationContext());
        CriminalListAdapter adapter = new CriminalListAdapter(this, criminalProvider.GetCriminals());

        ListView criminalList = (ListView) findViewById(R.id.criminal_listview);
        criminalList.setAdapter(adapter);

        criminalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(POSITION, position);

                MainActivity.this.startActivity(intent);
            }
        });

        /*TextView header = (TextView) findViewById(R.id.textHeader);
        header.setText(String.format("Criminals [%d]:",criminals.size()));

        String boxText = "";
        for(Criminal criminal : criminals) {
            List<Crime> crimes = criminal.crimes;
            boxText += criminal.name + " has " + crimes.size() + " crimes\n";
        }

        EditText textCriminal = (EditText) findViewById(R.id.textCriminals);
        textCriminal.setText(boxText);*/
    }
}
