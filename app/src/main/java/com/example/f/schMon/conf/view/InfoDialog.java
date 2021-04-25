/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.f.schMon.R;
import com.example.f.schMon.conf.model.A;
import com.example.f.schMon.conf.model.Person;

import java.text.SimpleDateFormat;


/**
 * Created by Mir Ferdous on 15/10/2017.
 */

public class InfoDialog extends DialogFragment {
    private final String TAG = InfoDialog.class.getName();
    View view;
    Bundle bundle;
    int icon;
    String title = "";
    private SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
    private Snackbar snackbar;
    private AlertDialog alertDialog;
    TextView name, topic, venue, td, parallel, working;
    ImageView img;

    Person person;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        person = A.getPerson();
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.dialog_info, null);

        name = view.findViewById(R.id.name);
        topic = view.findViewById(R.id.topic);
        venue = view.findViewById(R.id.venu);
        td = view.findViewById(R.id.td);
        parallel = view.findViewById(R.id.parallel);
        working = view.findViewById(R.id.working);
        img = view.findViewById(R.id.back);

        //================= DIALOG FRAG DESIGN ======================================

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setTitle(title);
        builder.setIcon(icon);


        //================= set data =================================

        setData();


        alertDialog = builder.create();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });


        return alertDialog;
    }



    //========================= Methods ============================================================
    private void setData() {
        if (person != null) {
            name.setText(person.sl+". " + person.name);
            topic.setText("Topic: "+person.topic);
            venue.setText(person.venue);
            parallel.setText(person.parallel);
            working.setText(person.working);
            td.setText(person.t_d);
        }

        Log.d(TAG,person.toString());
    }


}

