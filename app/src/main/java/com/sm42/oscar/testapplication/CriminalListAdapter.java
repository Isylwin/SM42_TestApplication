package com.sm42.oscar.testapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

@SuppressLint("InflateParams")
// See: https://code.google.com/p/android-developer-preview/issues/detail?id=1203
public class CriminalListAdapter extends ArrayAdapter<Criminal> {
    private Context context;
    private List<Criminal> criminals;

    public CriminalListAdapter(Context context, List<Criminal> criminals) {
        super(context, R.layout.criminallistitem, criminals);

        this.context = context;
        this.criminals = criminals;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Criminal requestedCriminal = criminals.get(position);
        View criminalView = convertView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            criminalView = inflater.inflate(R.layout.criminallistitem, null);
        }

        TextView nameText = (TextView) criminalView.findViewById(R.id.criminal_name);
        nameText.setText(requestedCriminal.name);

        TextView bountyText = (TextView) criminalView.findViewById(R.id.criminal_bounty);
        bountyText.setText(String.format(Locale.ENGLISH, "$%d", requestedCriminal.getBountyInDollars()));

        ImageView mugshotImage = (ImageView) criminalView.findViewById(R.id.criminal_mugshot);
        mugshotImage.setImageDrawable(requestedCriminal.mugshot);

        return criminalView;
    }
}
