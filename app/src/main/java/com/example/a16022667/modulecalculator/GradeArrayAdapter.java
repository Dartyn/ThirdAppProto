package com.example.a16022667.modulecalculator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GradeArrayAdapter extends ArrayAdapter<Grade> {
    ArrayList<Grade> notes;
    private Context context;
    int resource;


    public GradeArrayAdapter(@NonNull Context context, int resource, ArrayList<Grade> objects) {
        super(context, resource, objects);
        this.notes = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        TextView tvName = (TextView) rowView.findViewById(R.id.textViewName);
        TextView tvGrade = (TextView) rowView.findViewById(R.id.textViewGrade);


        Grade currentCountry = notes.get(position);

        tvName.setText(currentCountry.getName());
        tvGrade.setText(currentCountry.getGrade());

        return rowView;
    }
}




