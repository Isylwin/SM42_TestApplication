package com.sm42.oscar.testapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Oscar on 16-Mar-17.
 */

public class DetailsActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        int criminalPosition = getIntent().getIntExtra(MainActivity.POSITION, 1);
        CriminalProvider provider = new CriminalProvider(getApplicationContext());
        Criminal criminal = provider.GetCriminal(criminalPosition);

        ImageView mugshotView = (ImageView) findViewById(R.id.details_mugshot);
        mugshotView.setImageDrawable(criminal.mugshot);

        TextView nameView = (TextView) findViewById(R.id.details_name);
        nameView.setText(criminal.name);

        TextView genderView = (TextView) findViewById(R.id.details_gender);
        genderView.setText(criminal.gender);

        TextView ageView = (TextView) findViewById(R.id.details_age);
        ageView.setText(String.format(Locale.ENGLISH, "%d", criminal.age));

        TextView bountyView = (TextView) findViewById(R.id.details_bounty);
        bountyView.setText(String.format(Locale.ENGLISH, "$%d", criminal.getBountyInDollars()));

        TextView descriptionView = (TextView) findViewById(R.id.details_description);
        descriptionView.setText(criminal.description);

        ListView crimeView = (ListView) findViewById(R.id.details_crimes);
        crimeView.setAdapter(new CrimeListAdapter(DetailsActivity.this, criminal.crimes));
    }
}
