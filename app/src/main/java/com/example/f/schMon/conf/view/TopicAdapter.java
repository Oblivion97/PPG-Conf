/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

/**
 * Created by Mir Ferdous on 13/06/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.Person;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopicAdapter extends ArrayAdapter<Person> {
    private final Context context;
    View rowView;
    private List<Person> list;

    public TopicAdapter(Context context, int rootView, List<Person> list) {
        super(context, -1, list);
        this.context = context;
        this.list = list;
    }

    static class ViewHolder {
        @BindView(R.id.cName)
        TextView name;
        @BindView(R.id.cTheme)
        TextView theme;
        @BindView(R.id.cSL)
        TextView sl;
        @BindView(R.id.cTopic)
        TextView topic;


        public ViewHolder(View convertView) {
            ButterKnife.bind(this, convertView);
        }
    }

    ViewHolder h;
    LayoutInflater li;

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        //  LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // rowView = li.inflate(R.layout.row_topic, parent, false);

        if (convertView == null) {
            li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = li.inflate(R.layout.row_topic, null);
            h = new ViewHolder(convertView);
            convertView.setTag(h);

        } else {
            h = (ViewHolder) convertView.getTag();
        }

        h.sl.setText(list.get(i).sl);
        h.name.setText(" " + list.get(i).name);
        //h.theme.setText("Thematic Area: " + list.get(i).theme);
        h.topic.setText("Topic: " + list.get(i).topic);


        //___________________set data___________________


        return convertView;
    }
}