/*
 * Copyright (c) MiR FeRdOuS
 */

package com.example.f.schMon.conf.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mir Ferdous on 10/24/2017.
 */

public class Data {
    public static String topicWisDefalut = "The Role of Gender In Policy and Administrative Processes";
    public static String countryWisDefalut = "The Role of Gender Policy and Administrative Process";

    public static ArrayList<String> getThemeTopicWise() {
        ArrayList<String> list = new ArrayList<>();
        list.add("The Role of Gender In Policy and Administrative Processes");
        list.add("Gender and Practice of Sustainable Development");
        list.add("Gender & Political Value");

        return list;
    }


    public static ArrayList<String> getThemeCountryWise() {
        ArrayList<String> list = new ArrayList<>();
        list.add("The Role of Gender Policy and Administrative Process");
        list.add("Institutionalism and Gender Process, Practice and Value");
        list.add("Gender and Practice of Sustainable Development");
        list.add("Gender and Political Value");

        return list;
    }

    public static List<String> getThemeOfSpeakersRunTime() {
        List<String> list = new ArrayList<>();
        list = DAO.all_unique_values_from_a_Column(DB.speaker_all.table, DB.speaker_all.theme);
        return list;
    }


}
