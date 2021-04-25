/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

/**
 * Created by Mir Ferdous on 13/06/2017.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.A;
import com.example.f.schMon.conf.model.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SpeakerAdapter extends ArrayAdapter<Person> implements Filterable {
    private final Context context;
    private List<Person> list;
    private List<Person> listFiltered = new ArrayList<>();

    public SpeakerAdapter(Context context, int rootView, List<Person> list) {
        super(context, -1, list);
        this.context = context;
        this.list = list;
        this.listFiltered.addAll(list);
    }

    static class ViewHolder {
        @BindView(R.id.cSL)
        TextView sl;
        @BindView(R.id.cName)
        TextView name;
        @BindView(R.id.cTopic)
        TextView topic;
        @BindView(R.id.cTheme)
        TextView theme;
        @BindView(R.id.cCountry)
        TextView country;
        @BindView(R.id.cDigit)
        TextView digit;
        @BindView(R.id.parentCard)
        CardView cardView;


        public ViewHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }

    ViewHolder h;
    LayoutInflater li;

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        //  LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // rowView = li.inflate(R.layout.row_topic, parent, false);

        if (convertView == null) {
            li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.row_speaker, null);
            h = new ViewHolder(convertView);
            convertView.setTag(h);

        } else {
            h = (ViewHolder) convertView.getTag();
        }


        //___________________set data___________________
        h.sl.setText(list.get(i).sl+". ");
        h.name.setText( list.get(i).name);
        h.topic.setText(list.get(i).topicExtra);


     /*   h.theme.setText(list.get(i).themeExtra);
        h.country.setText(list.get(i).countryExtra);
        h.digit.setText(list.get(i).digitExtra);*/

     //   hideBlankTextView();


        h.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                A.setPerson(list.get(i));
                DialogFragment dialog = new InfoDialog();
                dialog.show(((AppCompatActivity) context).getSupportFragmentManager(), "dialog");
            }
        });
        return convertView;
    }


    void hideBlankTextView() {
        if (h.topic.getText().toString().equals(""))
            h.topic.setVisibility(View.GONE);
        if (h.theme.getText().toString().equals(""))
            h.theme.setVisibility(View.GONE);
        if (h.country.getText().toString().equals(""))
            h.country.setVisibility(View.GONE);
        if (h.digit.getText().toString().equals(""))
            h.digit.setVisibility(View.GONE);
    }


    //========================= filter ============================================
    @NonNull
    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    ValueFilter valueFilter;

    class ValueFilter extends Filter {//not used

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                List<Person> filterList = new ArrayList();
                for (int i = 0; i < listFiltered.size(); i++) {
                    if ((listFiltered.get(i).name.equalsIgnoreCase(constraint.toString()))) {
                        filterList.add(listFiltered.get(i));
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = listFiltered.size();
                results.values = listFiltered;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
           /* list.clear();
            list.addAll((List<Person>) results.values);*/

            list = (List<Person>) results.values;
            notifyDataSetChanged();
        }

    }
}