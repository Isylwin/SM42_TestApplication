package com.sm42.oscar.testapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Created by Oscar on 16-Mar-17.
 */

public class CrimeListAdapter extends ArrayAdapter<Crime> {
    private Context context;
    private List<Crime> crimes;

    public CrimeListAdapter(Context context, List<Crime> crimes) {
        super(context, R.layout.crimelistitem, crimes);
        this.context = context;
        this.crimes = crimes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Crime crime = crimes.get(position);
        View crimeView = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            crimeView = inflater.inflate(R.layout.crimelistitem, null);
        }

        TextView nameText = (TextView) crimeView.findViewById(R.id.crime_name);
        nameText.setText(crime.name);

        TextView bountyText = (TextView) crimeView.findViewById(R.id.crime_bounty);
        bountyText.setText(String.format(Locale.ENGLISH, "$%d", crime.bountyInDollars));

        TextView descriptionText = (TextView) crimeView.findViewById(R.id.crime_description);
        descriptionText.setText(crime.description);

        return crimeView;
    }
}
